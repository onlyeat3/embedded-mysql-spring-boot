package io.github.liuyuyu.embedded.mysql.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DemoServiceTest extends EmbeddedMysqlDemoApplicationTests {
    @Autowired private DemoService demoService;

    @Test
    public void listAllLuckDog() {
        List<Map<String, Object>> luckDogs = this.demoService.listAllLuckDog();
        Assert.assertEquals(luckDogs.size(),2);
        for (Map<String, Object> luckDog : luckDogs) {
            for (Map.Entry<String, Object> entry : luckDog.entrySet()) {
                System.out.print(String.format("%s:%s ",entry.getKey(),entry.getValue()));
            }
            System.out.println();
        }
    }
}