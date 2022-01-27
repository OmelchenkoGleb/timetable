package com.example.demo.Models;


import javax.persistence.*;

@Entity
public class timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grouup_id", nullable = false)
    private grouup grouup;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lessons_id", nullable = false)
    private lessons lessons;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pair_id", nullable = false)
    private pair pair;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private room room;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "day_id", nullable = false)
    private day day;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public grouup getGrouup() {
        return grouup;
    }

    public timetable(grouup grouup, lessons lessons, pair pair, room room, day day) {
        this.grouup = grouup;
        this.lessons = lessons;
        this.pair = pair;
        this.room = room;
        this.day = day;
    }

    public void setGrouup(grouup grouup) {
        this.grouup = grouup;
    }
    public lessons getLessons() {
        return lessons;
    }

    public timetable() {
    }

    public void setLessons(lessons lessons) {
        this.lessons = lessons;
    }
    public pair getPair() {
        return pair;
    }
    public void setPair(pair pair) {
        this.pair = pair;
    }
    public room getRoom() {
        return room;
    }
    public void setRoom(room room) {
        this.room = room;
    }
    public day getDay() {
        return day;
    }
    public void setDay(day day) {
        this.day = day;
    }
}
