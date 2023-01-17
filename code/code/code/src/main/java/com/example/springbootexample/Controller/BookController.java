package com.example.springbootexample.Controller;


import com.example.springbootexample.Repository.Model.bookModel;
import com.example.springbootexample.Service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")

public class BookController {

  @Autowired
  bookService bookService;

    @GetMapping(value = "/getbook")
    public ResponseEntity getBooks(@RequestParam("id") int id)  {

        try {
          bookModel bookModel= bookService.getbook(id);
            return new ResponseEntity<>(bookModel, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity("data not found ",HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(value = "/insert")
    public ResponseEntity insertBook(@RequestBody bookModel bookModele){

        try {
            bookModel bookModel = bookService.insertBook(bookModele);
            return new ResponseEntity(bookModel,HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity("data not saved ",HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/getbooks")
    public ResponseEntity getBooks(){

        try
        {
           List<bookModel> bookModels= bookService.getBooks();
           return new ResponseEntity(bookModels,HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity("data not load",HttpStatus.BAD_REQUEST);
        }
    }



}
