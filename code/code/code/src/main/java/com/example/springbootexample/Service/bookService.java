package com.example.springbootexample.Service;

import com.example.springbootexample.Repository.Model.bookModel;

import java.util.List;

public interface bookService {

    public bookModel getbook(int id)throws Exception;

    public bookModel insertBook(bookModel bookModel)throws Exception;

    public List<bookModel> getBooks()throws Exception;

}
