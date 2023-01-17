package com.example.springbootexample.Service.iml;

import com.example.springbootexample.Repository.DetailsRepository;
import com.example.springbootexample.Repository.Entity.DetailsEntity;
import com.example.springbootexample.Repository.Mapper.DetailsMapper;
import com.example.springbootexample.Repository.Model.DetailsModels;
import com.example.springbootexample.Repository.Model.FsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailsService {
    @Autowired
    DetailsRepository myrepository;
    @Autowired
     DetailsMapper myMapper;
   public DetailsModels saveOne(DetailsModels detailsModels){
       DetailsEntity detailsEntity=new DetailsEntity();
       detailsEntity=myMapper.modelToEntity(detailsModels);
       myrepository.save(detailsEntity);
       return detailsModels;
   }

    public int saveAll(List <DetailsModels> detailsModelsArrayList)throws Exception{
       ArrayList<DetailsEntity> detailsEntityArrayList=new ArrayList<>();
       DetailsEntity detailsEntity=new DetailsEntity();
           for (int i=0;i<detailsModelsArrayList.size();i++){
               System.out.println(i);
               System.out.println(detailsModelsArrayList.get(i).getName());
               detailsEntity=myMapper.modelToEntity(detailsModelsArrayList.get(i));
               detailsEntityArrayList.add(detailsEntity);

           }

           myrepository.saveAll(detailsEntityArrayList);
       return 0;}
    public DetailsModels deleted(int id)throws Exception{
        DetailsModels detailsModels=new DetailsModels();
        DetailsEntity detailsEntity=new DetailsEntity();
        detailsEntity=myrepository.getById(id);
        myrepository.delete(detailsEntity);
        detailsModels=myMapper.entityToModel(detailsEntity);
       return detailsModels;
    }
    public List <DetailsModels> findAll(List<FsModel> fsModelList)throws Exception{
        DetailsModels detailsModels=new DetailsModels();
        DetailsEntity detailsEntity=new DetailsEntity();
        List <DetailsModels> detailsModelsArrayList=new ArrayList<>();
        List <DetailsEntity> detailsEntityArrayList=new ArrayList<>();

        detailsEntityArrayList=myrepository.findAll();
        for (int i=0;i<detailsEntityArrayList.size();i++){
            for (int j=0;j<fsModelList.size();i++) {
                detailsEntity=detailsEntityArrayList.get(i);
                if (detailsEntity.getSupliersId()==fsModelList.get(j).getId()) {
                    detailsModels = myMapper.entityToModel(detailsEntity);
                    detailsModelsArrayList.add(detailsModels);
                }
            }
        }
       return detailsModelsArrayList;
    }
    public List <DetailsModels> findall()throws Exception{
        List <DetailsModels> detailsModelsList=new ArrayList<>();
        List <DetailsEntity> detailsEntityList=myrepository.findAll();
        for (int i = 0; i <detailsEntityList.size() ; i++) {
            DetailsEntity detailsEntity=detailsEntityList.get(i);
            DetailsModels models=myMapper.entityToModel(detailsEntity);
            detailsModelsList.add(models);
        }
       return detailsModelsList;
    }
}
