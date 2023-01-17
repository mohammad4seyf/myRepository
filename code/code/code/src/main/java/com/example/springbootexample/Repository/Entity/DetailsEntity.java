package com.example.springbootexample.Repository.Entity;

import com.example.springbootexample.Repository.Model.SupliersModels;

import javax.persistence.*;

@Entity
@Table(name ="details_entity" )
public class DetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "value")
    int value;
    @Column(name = "supliers_id")
    int supliersId;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupliersId() {
        return supliersId;
    }

    public void setSupliersId(int supliersId) {
        this.supliersId = supliersId;
    }
}
