package com.example.springbootexample.Repository.Mapper;


import com.example.springbootexample.Repository.Entity.DetailsEntity;
import com.example.springbootexample.Repository.Model.DetailsModels;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface DetailsMapper {

    DetailsEntity modelToEntity(DetailsModels detailsModels);
    DetailsModels entityToModel(DetailsEntity detailsEntity);
}
