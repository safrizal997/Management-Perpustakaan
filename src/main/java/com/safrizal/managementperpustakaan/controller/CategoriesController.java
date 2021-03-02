package com.safrizal.managementperpustakaan.controller;

import com.safrizal.managementperpustakaan.entity.CategoriesEntity;
import com.safrizal.managementperpustakaan.model.CategoriesRequest;
import com.safrizal.managementperpustakaan.service.CategoriesEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public CategoriesEntity insertCategory(@RequestBody CategoriesRequest categoriesRequest){
        return categoriesEntityService.insertCategory(categoriesRequest);
    }


}
