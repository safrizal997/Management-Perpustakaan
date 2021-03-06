package com.safrizal.managementperpustakaan.controller;

import com.safrizal.managementperpustakaan.entity.CategoriesEntity;
import com.safrizal.managementperpustakaan.model.CategoriesRequest;
import com.safrizal.managementperpustakaan.service.CategoriesEntityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Category Service"}, description = "Handling Category Action")
public class CategoriesController {

    final
    CategoriesEntityService categoriesEntityService;


    public CategoriesController(CategoriesEntityService categoriesEntityService) {
        this.categoriesEntityService = categoriesEntityService;
    }

    @GetMapping
    public List<CategoriesEntity> getCategories(){
        return categoriesEntityService.getCategories();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriesEntity insertCategory(@RequestBody CategoriesRequest categoriesRequest){
        return categoriesEntityService.insertCategory(categoriesRequest);
    }


}
