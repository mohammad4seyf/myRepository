package com.example.springbootexample.Repository.Model;

import java.util.ArrayList;
import java.util.List;

public class OutputModels {
    FactoryModel factoryModel=new FactoryModel();
    List<DetailsModels> detailsModelsList=new ArrayList<>();
    List<SupliersModels> supliersModelsList=new ArrayList<>();

    public FactoryModel getFactoryModel() {
        return this.factoryModel;
    }

    public void setFactoryModel(FactoryModel factoryModel) {
        this.factoryModel = factoryModel;
    }

    public List<DetailsModels> getDetailsModelsList() {
        return detailsModelsList;
    }

    public void setDetailsModelsList(List<DetailsModels> detailsModelsList) {
        this.detailsModelsList = detailsModelsList;
    }

    public List<SupliersModels> getSupliersModelsList() {
        return supliersModelsList;
    }

    public void setSupliersModelsList(List<SupliersModels> supliersModelsList) {
        this.supliersModelsList = supliersModelsList;
    }
}
