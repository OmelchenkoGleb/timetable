package com.example.demo.reporm;

import com.example.demo.Models.grouup;
import com.example.demo.Models.list;
import com.example.demo.Models.students;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface listRepository extends CrudRepository<list,Long> {
    list findByStudents(students students);
    List<list> findAllByGrouup(grouup grouup);
    List<list> findAllByStudents(students students);
    List<list> findAllByGrouupAndStudents(grouup grouup, students students);
}
