package com.example.springbootexample.Service.iml;

import com.example.springbootexample.Repository.Entity.FsEntity;
import com.example.springbootexample.Repository.FsRepository;
import com.example.springbootexample.Repository.Mapper.FsMapper;
import com.example.springbootexample.Repository.Model.FsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FsService {
    @Autowired
    FsMapper fsMapper;
    @Autowired
    FsRepository fsRepository;

    public List<FsModel> findAllByFactoryId(int id)throws Exception{
        FsEntity fsEntity=new FsEntity();
        List<FsModel> fsModelList=new ArrayList<>();
        List<FsEntity> fsEntityList=new ArrayList<>();
        fsEntityList=fsRepository.findAll();
        for (int i=0;i<fsEntityList.size();i++){
            if (fsEntityList.get(i).getFactoryId()==id){
                fsEntity=fsEntityList.get(i);
                fsModelList.add(fsMapper.entityToModel(fsEntity));
            }

        }
        return fsModelList;
    }
    public FsModel save(FsModel fsModel)throws Exception{
        FsEntity fsEntity=new FsEntity();
        fsEntity=fsMapper.modelToEntity(fsModel);
        fsEntity=fsRepository.save(fsEntity);
        fsModel=fsMapper.entityToModel(fsEntity);
        return fsModel;
    }
    public List<FsModel> saveAll(List<FsModel> fsModel)throws Exception{
        FsEntity fsEntity=new FsEntity();
        List<FsEntity>fsEntityList=new ArrayList<>();
        for (int i=0;i<fsModel.size();i++){

            fsEntity= fsMapper.modelToEntity(fsModel.get(i));

            fsEntityList.add(fsEntity);
        }
        fsRepository.saveAll(fsEntityList);
        return fsModel;
    }
    public FsModel updat(FsModel fsModel)throws Exception{


        return fsModel;
    }
    public FsModel remove(int id)throws Exception{
        FsModel fsModel=new FsModel();
        FsEntity fsEntity=new FsEntity();
        fsEntity=fsRepository.getById(id);
        fsRepository.delete(fsEntity);
        return fsModel;
    }
    public List<FsModel> findAll()throws Exception{
        FsEntity fsEntity=new FsEntity();
        List<FsModel> fsModelList=new ArrayList<>();
        List<FsEntity> fsEntityList=new ArrayList<>();
        fsEntityList=fsRepository.findAll();
        for (int i=0;i<fsEntityList.size();i++){
                fsEntity=fsEntityList.get(i);
                fsModelList.add(fsMapper.entityToModel(fsEntity));

        }
        return fsModelList;
    }
}
