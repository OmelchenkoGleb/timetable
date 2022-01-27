package com.example.demo.Models;

import javax.persistence.*;

@Entity
public class list {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grouup_id", nullable = false)
    private grouup grouup;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "students_id", nullable = false)
    private students students;

    public list() {

    }

    public com.example.demo.Models.grouup getGrouup() {
        return grouup;
    }

    public list(com.example.demo.Models.grouup grouup, com.example.demo.Models.students students) {
        this.grouup = grouup;
        this.students = students;
    }

    public void setGrouup(com.example.demo.Models.grouup grouup) {
        this.grouup = grouup;
    }

    public com.example.demo.Models.students getStudents() {
        return students;
    }

    public void setStudents(com.example.demo.Models.students students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
