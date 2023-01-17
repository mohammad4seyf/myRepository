package com.example.springbootexample.Service.iml;

import com.example.springbootexample.Repository.Entity.SupliersEntity;
import com.example.springbootexample.Repository.Mapper.SupliersMapper;
import com.example.springbootexample.Repository.Model.FsModel;
import com.example.springbootexample.Repository.Model.SupliersModels;
import com.example.springbootexample.Repository.SupliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupliersServices {
    @Autowired
        SupliersRepository myRepository;
    @Autowired
        SupliersMapper myMapper;

    public SupliersModels save(SupliersModels supliersModels){
        SupliersEntity entity=myRepository.save(myMapper.modelToEntity(supliersModels));
        supliersModels=myMapper.entityToModel(entity);
        return supliersModels;
    }
    public int saveAll(List<SupliersModels> supliersModelsArrayList)throws Exception{
        int firstCounter;
        List <SupliersEntity>supliersEntityList=new ArrayList<>();
        for (int i=0;i<supliersModelsArrayList.size();i++)
            {
            SupliersEntity supliersEntity=new SupliersEntity();
            supliersEntity=myMapper.modelToEntity(supliersModelsArrayList.get(i));
            supliersEntityList.add(supliersEntity);
        }
       firstCounter=1+ myRepository.findAll().size();
       myRepository.saveAll(supliersEntityList);
       return firstCounter; }
    public SupliersModels deleted(int id){
        SupliersModels supliersModels=new SupliersModels();
        SupliersEntity supliersEntity=new SupliersEntity();
        supliersEntity=myRepository.getById(id);
        supliersModels=myMapper.entityToModel(supliersEntity);
        myRepository.deleteById(id);
        return supliersModels;
    }
    public ArrayList<SupliersModels> findAll()throws Exception{
        ArrayList <SupliersModels> supliersModelsArrayList=new ArrayList<>();
        List <SupliersEntity> supliersEntityList=new ArrayList<>();
        SupliersEntity entity=new SupliersEntity();
        SupliersModels models=new SupliersModels();

        supliersEntityList=myRepository.findAll();
        for (int i = 0; i <supliersEntityList.size() ; i++) {
            entity=supliersEntityList.get(i);
            models=myMapper.entityToModel(entity);
            supliersModelsArrayList.add(models);
        }
        System.out.println(supliersModelsArrayList.get(1).getAdress());
        return supliersModelsArrayList;
    }
    public SupliersModels find(int id)throws Exception{
        SupliersModels supliersModels=new SupliersModels();
        SupliersEntity supliersEntity=new SupliersEntity();
        supliersEntity=myRepository.getById(id);
        supliersModels=myMapper.entityToModel(supliersEntity);

        return supliersModels;
    }
}
