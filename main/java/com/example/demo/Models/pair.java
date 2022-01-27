package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class pair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "number")
    private Long number;
    @Column(name = "start")
    private String start;
    @Column(name = "finish")
    private String finish;

    @OneToMany(mappedBy = "pair", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<timetable> timetables;

    public List<timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<timetable> timetables) {
        this.timetables = timetables;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
