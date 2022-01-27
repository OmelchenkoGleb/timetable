package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;


@Entity
public class day {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "day", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<timetable> timetables;

    public day() {

    }

    public List<timetable> getTimetables() {
        return timetables;
    }

    public day(String name) {
        this.name = name;
    }

    public void setTimetables(List<timetable> timetables) {
        this.timetables = timetables;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
