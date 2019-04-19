package io.github.liuyuyu.embedded.mysql.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DemoController {
    @Autowired private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public List<Map<String, Object>> index(){
        return this.jdbcTemplate.queryForList("select * from luck_dog");
    }
}
