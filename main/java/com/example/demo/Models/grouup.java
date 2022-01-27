package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class grouup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;

    public grouup(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "grouup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<timetable> timetables;

    @OneToMany(mappedBy = "grouup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<list> list;

    public grouup() {

    }

    public List<com.example.demo.Models.list> getList() {
        return list;
    }

    public void setList(List<com.example.demo.Models.list> list) {
        this.list = list;
    }

    public List<timetable> getTimetables() {
        return timetables;
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
