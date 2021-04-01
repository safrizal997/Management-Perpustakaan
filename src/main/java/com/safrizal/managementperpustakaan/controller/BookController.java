package com.safrizal.managementperpustakaan.controller;

import com.safrizal.managementperpustakaan.entity.BookEntity;
import com.safrizal.managementperpustakaan.model.BookRequest;
import com.safrizal.managementperpustakaan.service.BookEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/book", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
@Api(tags = {"Book Service"}, description = "Handling Book Action")
public class BookController {

    @Autowired
    BookEntityService bookEntityService;

    @GetMapping
    public List<BookEntity> getAllBook() {
        return bookEntityService.getAllBook();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BookEntity insertBook(@RequestBody BookRequest bookRequest) {
        return bookEntityService.insertBook(bookRequest);
    }

}
