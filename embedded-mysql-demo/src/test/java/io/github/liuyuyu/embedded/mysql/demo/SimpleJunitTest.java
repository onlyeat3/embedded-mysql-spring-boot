package io.github.liuyuyu.embedded.mysql.demo;

import com.wix.mysql.distribution.Version;
import org.junit.Test;

import java.util.Arrays;

public class SimpleJunitTest {
    @Test
    public void printMySQLVersion(){
        Arrays.stream(Version.values())
                .map(Enum::name)
                .forEach(System.out::println);
    }
}
