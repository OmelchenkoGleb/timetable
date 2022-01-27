package com.example.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DayDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int Update(Long id, String name){
        return jdbcTemplate.update("UPDATE day SET name = ? WHERE ID = ?", name,id);
    }
}
