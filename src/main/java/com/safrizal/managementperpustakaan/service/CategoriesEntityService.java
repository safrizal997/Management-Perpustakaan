package com.safrizal.managementperpustakaan.service;

import com.safrizal.managementperpustakaan.entity.CategoriesEntity;
import com.safrizal.managementperpustakaan.model.CategoriesRequest;

import java.util.List;

public interface CategoriesEntityService {

    List<CategoriesEntity> getCategories();

    CategoriesEntity insertCategory(CategoriesRequest categoriesRequest);


}
