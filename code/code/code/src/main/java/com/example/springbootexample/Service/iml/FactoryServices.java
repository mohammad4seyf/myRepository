package com.example.springbootexample.Service.iml;

import com.example.springbootexample.Repository.Entity.FactoryEntity;
import com.example.springbootexample.Repository.FactoryRepository;
import com.example.springbootexample.Repository.Mapper.FactoryMapper;
import com.example.springbootexample.Repository.Model.DetailsModels;
import com.example.springbootexample.Repository.Model.FactoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactoryServices {

    @Autowired
    FactoryRepository factoryRepository;
    @Autowired
    FactoryMapper factoryMapper;

    public int saveAll(ArrayList<FactoryModel> factoryModelList)throws Exception{
        FactoryEntity factoryEntity=new FactoryEntity();
        List <FactoryEntity> factoryEntityList=new ArrayList<>();
        for (int i=0;i<factoryEntityList.size();i++)
            {
            factoryEntity=factoryMapper.modelToEntity(factoryModelList.get(i));
            factoryEntityList.add(factoryEntity);
            }
        factoryRepository.saveAll(factoryEntityList);
        return 0;}
    public FactoryModel deleted(int id)throws Exception{
        FactoryModel factoryModel=new FactoryModel();
        FactoryEntity factoryEntity=new FactoryEntity();
        factoryEntity=factoryMapper.modelToEntity(factoryModel);
        factoryEntity=factoryRepository.save(factoryEntity);
        factoryModel=factoryMapper.entityToModel(factoryEntity);
        return factoryModel;
    }
    public List<FactoryModel> findAll()throws Exception{
        List <FactoryModel> factoryModelList=new ArrayList<>();
        List <FactoryEntity> factoryEntityList=new ArrayList<>();
        factoryEntityList=factoryRepository.findAll();
        for (int i=0;i<factoryEntityList.size();i++){{
            FactoryModel factoryModel=new FactoryModel();
            factoryModel=factoryMapper.entityToModel(factoryEntityList.get(i));
            factoryModelList.add(factoryModel);

        }
        }
        return factoryModelList;
    }
    public FactoryModel save(FactoryModel factoryModel)throws Exception{

        FactoryEntity factoryEntity=new FactoryEntity();
        System.out.println(factoryModel.getAdress());
        factoryEntity=factoryMapper.modelToEntity(factoryModel);
        System.out.println(factoryEntity.getAdress());
        factoryEntity=factoryRepository.save(factoryEntity);
        factoryModel=factoryMapper.entityToModel(factoryEntity);
        return factoryModel;
    }

    public FactoryModel find(int id)throws Exception{
        FactoryModel factoryModel=new FactoryModel();
        FactoryEntity factoryEntity=new FactoryEntity();
        factoryEntity= factoryRepository.getById(id);
        factoryModel=factoryMapper.entityToModel(factoryEntity);
        return factoryModel;
    }
}
