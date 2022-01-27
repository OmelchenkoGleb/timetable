package com.example.demo.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PairDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int Update(Long id, String number, String start, String finish){
        return jdbcTemplate.update("UPDATE pair SET number = ?, start = ?, finish = ? WHERE ID = ?", number, start, finish,id);
    }

    public int save(String number, String start, String finish){
        return jdbcTemplate.update("INSERT INTO `pair` (`ID`, `number`, `start`, `finish`) VALUES (NULL, ?, ?, ?)", number, start, finish);
    }
}
