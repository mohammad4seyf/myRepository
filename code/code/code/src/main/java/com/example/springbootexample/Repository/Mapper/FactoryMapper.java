package com.example.springbootexample.Repository.Mapper;

import com.example.springbootexample.Repository.Entity.FactoryEntity;
import com.example.springbootexample.Repository.Model.FactoryModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FactoryMapper {
    FactoryEntity modelToEntity(FactoryModel factoryModel);
    FactoryModel entityToModel(FactoryEntity factoryEntity);
}
