package com.example.demo.DAO;

import com.example.demo.Models.lessons;
import com.example.demo.Models.room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<room> Search(String number) {
        number = "%"+number+"%";
        return jdbcTemplate.query(
                "select * from room where `number` LIKE ?",
                new Object[]{number},
                new BeanPropertyRowMapper<>(room.class)
        );
    }

    public int Update(Long id, String number){
        return jdbcTemplate.update("UPDATE room SET number = ? WHERE ID = ?", number,id);
    }

    public int save(String number){
        return jdbcTemplate.update("INSERT INTO `room` (`ID`, `number`) VALUES (NULL, ?)", number);
    }
}
