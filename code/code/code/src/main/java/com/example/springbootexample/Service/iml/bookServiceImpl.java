package com.example.springbootexample.Service.iml;

import com.example.springbootexample.Repository.BookRepository;
import com.example.springbootexample.Repository.Entity.bookEntity;
import com.example.springbootexample.Repository.Mapper.bookMapper;
import com.example.springbootexample.Repository.Model.bookModel;
import com.example.springbootexample.Service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class bookServiceImpl  implements bookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    bookMapper bookMapper;


    @Override
    public bookModel getbook(int id) throws Exception {

        bookEntity bookEntity=bookRepository.getById(id);

        bookModel bookModel=bookMapper.EntityToModel(bookEntity);
        return bookModel;

    }

    @Override
    public bookModel insertBook(bookModel bookModel) throws Exception {
        bookEntity bookEntity=bookMapper.ModelToEntity(bookModel);
        bookRepository.save(bookEntity);
        return  bookModel;
    }

    @Override
    public List<bookModel> getBooks() throws Exception {

       List<bookEntity> bookEntities= bookRepository.findAll();
       List<bookModel> bookModels=new ArrayList<>();
        for (bookEntity bookEntity:bookEntities) {
            bookModel bookModel=bookMapper.EntityToModel(bookEntity);
            bookModels.add(bookModel);

        }

        return bookModels;
    }
}
