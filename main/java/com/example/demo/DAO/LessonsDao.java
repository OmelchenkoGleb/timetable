package com.example.demo.DAO;


import com.example.demo.Models.grouup;
import com.example.demo.Models.lessons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LessonsDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<lessons> Search(String name) {
        name = "%"+name+"%";
        return jdbcTemplate.query(
                "select * from lessons where `name` LIKE ?",
                new Object[]{name},
                new BeanPropertyRowMapper<>(lessons.class)
        );
    }

    public int Update(Long id, String name){
        return jdbcTemplate.update("UPDATE lessons SET name = ? WHERE ID = ?", name,id);
    }

    public int save(String name){
        return jdbcTemplate.update("INSERT INTO `lessons` (`ID`, `name`) VALUES (NULL, ?)", name);
    }
}
