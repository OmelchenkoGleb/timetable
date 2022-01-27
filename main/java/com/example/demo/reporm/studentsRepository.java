package com.example.demo.reporm;

import com.example.demo.Models.students;
import org.springframework.data.repository.CrudRepository;

public interface studentsRepository extends CrudRepository<students,Long> {
    students findByNameAndSurname(String name, String surname);
    students findBySurname(String surname);
}
