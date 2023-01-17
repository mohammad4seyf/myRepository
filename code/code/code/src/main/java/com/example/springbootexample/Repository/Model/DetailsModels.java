package com.example.springbootexample.Repository.Model;

public class DetailsModels {
    int id;
    String name;
    int value;
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

    public int getSupliersId() {
        return supliersId;
    }

    public void setSupliersId(int supliersId) {
        this.supliersId = supliersId;
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
}
