package com.example.demo.reporm;

import com.example.demo.Models.grouup;
import org.springframework.data.repository.CrudRepository;

public interface grouupRepository extends CrudRepository<grouup,Long> {
    grouup findAllByName(String name);
}
