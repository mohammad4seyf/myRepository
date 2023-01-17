package com.example.springbootexample.Repository.Entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class bookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "book_name",nullable = false)
    String name;
    @Column(name = "book_publication",nullable = false)
    String publication;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }
}
