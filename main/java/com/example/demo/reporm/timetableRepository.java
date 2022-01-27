package com.example.demo.reporm;

import com.example.demo.Models.day;
import com.example.demo.Models.grouup;
import com.example.demo.Models.timetable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface timetableRepository extends CrudRepository<timetable,Long> {
    List<timetable> findAll();
    List<timetable> findAllByGrouup(grouup grouup);
    List<timetable> findAllByDay(day day);
    List<timetable> findAllByGrouupAndDay(grouup grouup, day day);
}
