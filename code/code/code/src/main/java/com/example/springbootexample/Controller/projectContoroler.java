package com.example.springbootexample.Controller;

import com.example.springbootexample.Repository.Model.*;
import com.example.springbootexample.Service.iml.DetailsService;
import com.example.springbootexample.Service.iml.FactoryServices;
import com.example.springbootexample.Service.iml.FsService;
import com.example.springbootexample.Service.iml.SupliersServices;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/myController")
public class projectContoroler {
    @Autowired
    DetailsService detailsService;

    @Autowired
    FactoryServices factoryServices;

    @Autowired
    FsService fsService;
    @Autowired
    SupliersServices supliersServices;

    @GetMapping(value = "/get")
    public OutputModels FindFactory(@RequestParam("id") int id){

        List<FsModel> fsModelList=new ArrayList<>();
        OutputModels outputModels=new OutputModels();
        List<DetailsModels> detailsModelsList=new ArrayList<>();
        List<SupliersModels> supliersModelsList=new ArrayList<>();
        try {
        outputModels.setFactoryModel(factoryServices.find(id));
        fsModelList=fsService.findAllByFactoryId(id);
        supliersModelsList=supliersServices.findAll();
            for (int i = 0; i <supliersModelsList.size() ; i++) {
                for (int j = 0; j <fsModelList.size() ; j++) {
                    if (supliersModelsList.get(i).getId()==fsModelList.get(j).getSuplierId()){
                        break;
                    }
                    else if (j==fsModelList.size()-1){

                        supliersModelsList.remove(i);
                    }
                }

            }
        outputModels.setSupliersModelsList(supliersModelsList);
        detailsModelsList=detailsService.findAll(fsModelList);
        outputModels.setDetailsModelsList(detailsModelsList);


        }catch (Exception e){

            System.out.println("notfound"+e);
        }
        return outputModels;
    }
    @PostMapping(value = "/saveFactory")
    public InputModels saveFactory(@RequestBody InputModels inputModels){
        boolean out=false;
        InputModels inputModelsNotAdd=new InputModels();
        String message="this supliliers notFound:";
        List<SupliersModels> supliersModelsList;
        List<FactoryModel>factoryModels;
        List<DetailsModels> detailsModelsList=new ArrayList<>();
        List<FsModel> FsModelsfinalList=new ArrayList<>();

        try {
            factoryModels=factoryServices.findAll();
            for (int i = 0; i <factoryModels.size() ; i++) {
                if (factoryModels.get(i).getId()==inputModels.getFactoryModel().getId()){

                    out=true;
                    break;
                }
            } if (out){
            supliersModelsList=supliersServices.findAll();
            for (int i = 0; i < inputModels.getFsModelList().size(); i++) {
                for (int j = 0; j <supliersModelsList.size() ; j++) {
                    if (supliersModelsList.get(j).getId()==inputModels.getFsModelList().get(i).getSuplierId()){
                         FsModelsfinalList.add(inputModels.getFsModelList().get(i));
                        break;
                    }
                    else if (j==supliersModelsList.size()-1){
                        inputModelsNotAdd.getFsModelList().add(inputModels.getFsModelList().get(i));

                    }
                }

            }
            for (int i = 0; i <inputModels.getDetailsModelslist().size() ; i++) {
                for (int j = 0; j <supliersModelsList.size() ; j++) {
                    if (supliersModelsList.get(j).getId()==inputModels.getDetailsModelslist().get(i).getSupliersId()){
                        detailsModelsList.add(inputModels.getDetailsModelslist().get(i));
                        break;
                    }
                    else if (j==supliersModelsList.size()-1){
                        inputModelsNotAdd.getDetailsModelslist().add(inputModels.getDetailsModelslist().get(i));
                    }
                }

            }
        fsService.saveAll(FsModelsfinalList);
        detailsService.saveAll(inputModels.getDetailsModelslist());
            }
        else message="factory not found";

    }catch (Exception e)
        {
            message=String.valueOf(e);
            System.out.println(e);
        }
    return inputModelsNotAdd;}
    @PostMapping (value = "/update")
    public String update(){
        System.out.println("updatemethod");
        return "hello";}

    @PostMapping(value = "/insetedfactory")
    public int save(@RequestBody FactoryModel factoryModel){
        try {
            System.out.println(factoryModel.getAdress());
            factoryModel=factoryServices.save(factoryModel)  ;
        }catch (Exception e){
            factoryModel.setId(-10000);
            System.out.println(e);
        }

        return factoryModel.getId();
    }
    @PostMapping(value = "/insetedsuplier")

    public int save(@RequestBody SupliersModels supliersModels){
        try {
            supliersModels=supliersServices.save(supliersModels) ;
        }catch (Exception e){
            supliersModels.setId(-10000);
            System.out.println(e);
        }

        return supliersModels.getId();
    }

    @GetMapping(value = "/delletedDetailsModels")
    public int removeDetailsModels(@RequestParam("id") int id){
      int i=-10000;
        try {

              detailsService.deleted(id);
              i=id;
        }
        catch (Exception e){


        }

        return i;
    }
    @GetMapping(value = "/delletedFactoryModel")
    public int removeFactoryModel(@RequestParam("id") int id){
        int i=0;

      try {
          List<FsModel>fsModelList=fsService.findAllByFactoryId(id);
           if (factoryServices.find(id).getId()!=0) {
               if (fsModelList.size() == 0) {

                   factoryServices.deleted(id);
                   i = id;
               }
               else i=-10;
           }

      }catch (Exception e){
       id=-10000;
       System.out.println(e);
      }
      return id;
    }
    @GetMapping(value = "/deletedFsModel")
    public int removeFsModel(@RequestParam("id")int id){
       int i=0;
        try {
            fsService.remove(id);
            i=id;

        }catch (Exception e){
            System.out.println(e);
            i=-10000;

        }

        return 0;
    }
    @GetMapping(value = "/deletedsupliers")
    public int remove(@RequestParam("id")int id){
        int i=0;
        boolean out=false;
        try {
            List<DetailsModels>detailsModelsList=detailsService.findall();
            List<FsModel> fsModelList=fsService.findAll();
                for (int j = 0; j < fsModelList.size(); j++) {
                    if(fsModelList.get(i).getSuplierId()==id) {
                     out=true;
                     break;
                    }
                }
            if (!out){
                for (int j = 0; j < detailsModelsList.size() ; j++) {
                    if (detailsModelsList.get(i).getSupliersId()==id){
                        out=true;
                        i=-10;
                        break;

                    }
                }
            }
            if (!out) {
                supliersServices.deleted(id);
                i = id;
            }else {i=-20;}
        }catch (Exception e){
        i=-10000;
            System.out.println(e);
        }

        return 0;
    }
}
