package com.example.demo.DAO;

import com.example.demo.Models.lessons;
import com.example.demo.Models.students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<students> Search(String surname) {
        surname = "%"+surname+"%";
        return jdbcTemplate.query(
                "select * from students where `surname` LIKE ?",
                new Object[]{surname},
                new BeanPropertyRowMapper<>(students.class)
        );
    }

    public int Update(Long id, String name, String surname){
        return jdbcTemplate.update("UPDATE students SET name = ?, surname = ? WHERE ID = ?", name, surname,id);
    }

    public int save(String name, String surname){
        return jdbcTemplate.update("INSERT INTO `students` (`ID`, `name`, `surname`) VALUES (NULL, ?, ?)", name, surname);
    }

}
