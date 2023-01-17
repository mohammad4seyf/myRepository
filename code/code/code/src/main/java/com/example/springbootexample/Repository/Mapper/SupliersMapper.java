package com.example.springbootexample.Repository.Mapper;

import com.example.springbootexample.Repository.Entity.SupliersEntity;
import com.example.springbootexample.Repository.Model.SupliersModels;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupliersMapper {
    SupliersEntity modelToEntity(SupliersModels supliersModels);
    SupliersModels entityToModel(SupliersEntity supliersEntity);
}
