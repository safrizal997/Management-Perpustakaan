package com.safrizal.managementperpustakaan.controller;

import com.safrizal.managementperpustakaan.entity.BookEntity;
import com.safrizal.managementperpustakaan.model.BookRequest;
import com.safrizal.managementperpustakaan.service.BookEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Autowired
    BookEntityService bookEntityService;

    @GetMapping
    public List<BookEntity> getAllBook(){
        return  bookEntityService.getAllBook();
    }

    @PostMapping
    BookEntity insertBook (@RequestBody BookRequest bookRequest){
        return bookEntityService.insertBook(bookRequest);
    }

}
