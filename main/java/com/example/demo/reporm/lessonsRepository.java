package com.example.demo.reporm;

import com.example.demo.Models.lessons;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface lessonsRepository extends CrudRepository<lessons,Long> {
    lessons findByName(String name);
}
