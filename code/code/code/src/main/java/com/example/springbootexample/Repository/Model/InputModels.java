package com.example.springbootexample.Repository.Model;

import java.util.ArrayList;
import java.util.List;

public class InputModels {
    FactoryModel factoryModel=new FactoryModel();
    List<FsModel> fsModelList=new ArrayList<>();
    List<DetailsModels> detailsModelslist=new ArrayList<>();

    public FactoryModel getFactoryModel() {
        return factoryModel;
    }

    public void setFactoryModel(FactoryModel factoryModel) {
        this.factoryModel = factoryModel;
    }

    public List<FsModel> getFsModelList() {
        return fsModelList;
    }

    public void setFsModelList(List<FsModel> fsModelList) {
        this.fsModelList = fsModelList;
    }

    public List<DetailsModels> getDetailsModelslist() {
        return detailsModelslist;
    }

    public void setDetailsModelslist(List<DetailsModels> detailsModelslist) {
        this.detailsModelslist = detailsModelslist;
    }
}
