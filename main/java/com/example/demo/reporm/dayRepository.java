package com.example.demo.reporm;

import com.example.demo.Models.day;
import org.springframework.data.repository.CrudRepository;

public interface dayRepository extends CrudRepository<day,Long> {
    day findByName(String name);
}
