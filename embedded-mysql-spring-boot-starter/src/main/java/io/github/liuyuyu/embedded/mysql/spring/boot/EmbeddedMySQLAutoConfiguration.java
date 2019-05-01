package io.github.liuyuyu.embedded.mysql.spring.boot;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.Sources;
import com.wix.mysql.config.MysqldConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;

@Configuration
@EnableConfigurationProperties(MySQLProperties.class)
@AutoConfigureBefore({DataSourceAutoConfiguration.class, FlywayAutoConfiguration.class})
@ConditionalOnProperty(name = "spring.datasource.embedded.mysql.enable",havingValue = "true")
public class EmbeddedMySQLAutoConfiguration implements InitializingBean {
    @Autowired private MySQLProperties mySQLProperties;
    @Autowired private ApplicationContext applicationContext;

    public void init(){
        String[] dataFileLocations = this.mySQLProperties.getScriptLocations();

        List<Resource> resourcesList = new ArrayList<>();
        if (dataFileLocations != null) {
            for (String dataFileLocation : dataFileLocations) {
                try {
                    Resource[] resources = applicationContext.getResources(dataFileLocation);
                    resourcesList.addAll(Arrays.asList(resources));
                } catch (IOException e) {
                    //ignore
                }
            }
        }


        MysqldConfig mysqldConfig = this.mySQLProperties.toMysqldConfig()
                .build();

        EmbeddedMysql mysqlServer = anEmbeddedMysql(mysqldConfig)
                .start();
        if (!resourcesList.isEmpty()) {
            for (Resource resource : resourcesList) {
                try {
                    mysqlServer.executeScripts(this.mySQLProperties.getDatabaseName(), Sources.fromFile(resource.getFile()));
                } catch (IOException e) {
                    throw new RuntimeException(String.format("data file:%s load fail",resource.getFilename()),e);
                }
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.init();
    }
}
