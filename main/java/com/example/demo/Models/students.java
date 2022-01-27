package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="name")
    private String name;
    @Column(name ="surname")
    private String surname;

    @OneToMany(mappedBy = "students", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<list> list;

    public List<com.example.demo.Models.list> getList() {
        return list;
    }

    public void setList(List<com.example.demo.Models.list> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
