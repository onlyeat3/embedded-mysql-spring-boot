package io.github.liuyuyu.embedded.mysql.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Service
public class DemoService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> listAllLuckDog(){
        return this.jdbcTemplate.queryForList("select * from luck_dog");
    }
}
