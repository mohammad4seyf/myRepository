package com.example.springbootexample.Repository.Mapper;

import com.example.springbootexample.Repository.Entity.FsEntity;
import com.example.springbootexample.Repository.Model.FsModel;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface FsMapper {
    FsEntity modelToEntity(FsModel fsModel);
    FsModel entityToModel(FsEntity fsEntity);
}
