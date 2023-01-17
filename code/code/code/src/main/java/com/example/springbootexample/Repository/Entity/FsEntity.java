package com.example.springbootexample.Repository.Entity;


import javax.persistence.*;

@Entity
@Table(name = "Fs_Entity")
public class FsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column (name = "factory_id")
    int factoryId;
    @Column(name = "suplier_id")
    int suplierId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public int getSuplierId() {
        return suplierId;
    }

    public void setSuplierId(int suplierId) {
        this.suplierId = suplierId;
    }
}
