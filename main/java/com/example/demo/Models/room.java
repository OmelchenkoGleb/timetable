package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "number")
    private int number;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<timetable> timetables;

    public List<timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<timetable> timetables) {
        this.timetables = timetables;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
