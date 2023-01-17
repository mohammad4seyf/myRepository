package com.example.springbootexample.Repository.Mapper;

import com.example.springbootexample.Repository.Entity.bookEntity;
import com.example.springbootexample.Repository.Model.bookModel;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface bookMapper {

    bookModel EntityToModel(bookEntity entity);
    bookEntity ModelToEntity(bookModel bookModel);

}
