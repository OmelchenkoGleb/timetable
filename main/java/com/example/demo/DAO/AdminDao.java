package com.example.demo.DAO;

import com.example.demo.Models.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<admin> Search(String login) {
        login = "%"+login+"%";
        return jdbcTemplate.query(
                "select * from admin where `username` LIKE ?",
                new Object[]{login},
                new BeanPropertyRowMapper<>(admin.class)
        );
    }

    public int Update(Long id, String login, String pass){
        return jdbcTemplate.update("UPDATE admin SET username = ? , password = ? WHERE ID = ?", login,pass,id);
    }

    public int save(admin admin){
        return jdbcTemplate.update("INSERT INTO `admin` (`ID`, `username`, `password`) VALUES (NULL, ?, ?)", admin.getUsername(), admin.getPassword());
    }
}
