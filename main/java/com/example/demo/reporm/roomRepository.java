package com.example.demo.reporm;

import com.example.demo.Models.room;
import org.springframework.data.repository.CrudRepository;

public interface roomRepository extends CrudRepository<room,Long> {
    room findByNumber(int number);
}
