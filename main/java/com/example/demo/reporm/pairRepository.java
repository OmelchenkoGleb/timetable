package com.example.demo.reporm;

import com.example.demo.Models.pair;
import org.springframework.data.repository.CrudRepository;

public interface pairRepository extends CrudRepository<pair,Long> {
    pair findByNumber(Long number);
}
