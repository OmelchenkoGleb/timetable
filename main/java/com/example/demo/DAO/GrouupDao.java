package com.example.demo.DAO;

import com.example.demo.Models.admin;
import com.example.demo.Models.grouup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GrouupDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<grouup> Search(String name) {
        name = "%"+name+"%";
        return jdbcTemplate.query(
                "select * from grouup where `name` LIKE ?",
                new Object[]{name},
                new BeanPropertyRowMapper<>(grouup.class)
        );
    }

    public int Update(Long id, String name){
        return jdbcTemplate.update("UPDATE grouup SET name = ? WHERE ID = ?", name,id);
    }

    public int save(String name){
        return jdbcTemplate.update("INSERT INTO `grouup` (`ID`, `name`) VALUES (NULL, ?)", name);
    }
}
