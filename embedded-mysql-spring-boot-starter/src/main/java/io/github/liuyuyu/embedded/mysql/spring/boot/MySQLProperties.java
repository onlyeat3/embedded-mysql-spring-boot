package io.github.liuyuyu.embedded.mysql.spring.boot;

import com.wix.mysql.config.Charset;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.distribution.Version;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Data
@ConfigurationProperties(prefix = "spring.datasource.embedded.mysql")
public class MySQLProperties {
    public static final String DEFAULT_TEST_DB = "test";

    @Autowired private DataSourceProperties dataSourceProperties;

    private Boolean enable = Boolean.TRUE;

    private String[] scriptLocations;
    private String databaseName = DEFAULT_TEST_DB;

    private String version = Version.v5_6_36.name();
    private Integer port = 3333;
    private final String charsetName = Charset.defaults().getCharset();
    private final String charsetCollate = Charset.defaults().getCollate();


    private String timeZone = TimeZone.getDefault().getID();
    private final Long timeoutSeconds = 30L;
    private final Map<String,String> serverVariables = new HashMap<>();
    private String tempDir = "target/";

    public MysqldConfig.Builder toMysqldConfig(){
        MysqldConfig.Builder mysqldConfig = MysqldConfig.aMysqldConfig(Version.valueOf(this.version));
        mysqldConfig
                .withPort(this.port)
                .withCharset(Charset.aCharset(this.charsetName,this.charsetCollate))
                .withTimeZone(timeZone)
                .withTimeout(this.timeoutSeconds, TimeUnit.SECONDS)
                .withUser(this.getDataSourceProperties().getUsername(),this.getDataSourceProperties().getPassword())
                .withTempDir(this.tempDir);
        for (Map.Entry<String, String> entry : this.serverVariables.entrySet()){
            mysqldConfig.withServerVariable(entry.getKey(),entry.getValue());
        }
        return mysqldConfig;
    }
}
