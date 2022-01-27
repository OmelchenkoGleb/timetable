package com.example.demo.DAO;

import com.example.demo.reporm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class listsDao {
    @Autowired
    com.example.demo.reporm.studentsRepository studentsRepository;
    @Autowired
    com.example.demo.reporm.grouupRepository grouupRepository;


    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(String namegrouup, String name, String surname) {
        return jdbcTemplate.update("INSERT INTO `list` (`ID`, `students_id`, `grouup_id`) VALUES (NULL, ?, ?)"
                , studentsRepository.findByNameAndSurname(name,surname).getId(), grouupRepository.findAllByName(namegrouup).getId());
    }

    public int Update(Long id, String namegrouup, String name, String surname){
        return jdbcTemplate.update("UPDATE `list` SET `students_id` = ?, `grouup_id` = ? WHERE `list`.`ID` = ?"
                , studentsRepository.findByNameAndSurname(name,surname).getId(),grouupRepository.findAllByName(namegrouup).getId(), id);
    }
}
