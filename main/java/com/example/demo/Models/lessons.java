package com.example.demo.Models;
import javax.persistence.*;
import java.util.List;

@Entity
public class lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public lessons(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "lessons", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<timetable> timetables;

    public lessons() {

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
