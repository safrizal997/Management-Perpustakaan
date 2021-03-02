package com.safrizal.managementperpustakaan.service.impl;

import com.safrizal.managementperpustakaan.entity.CategoriesEntity;
import com.safrizal.managementperpustakaan.model.CategoriesRequest;
import com.safrizal.managementperpustakaan.repository.CategoriesEntityRepository;
import com.safrizal.managementperpustakaan.service.CategoriesEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesEntityServiceImpl implements CategoriesEntityService {

    @Autowired
    CategoriesEntityRepository categoriesEntityRepository;

    @Override
    public List<CategoriesEntity> getCategories() {
        return categoriesEntityRepository.findAll();
    }

    @Override
    public CategoriesEntity insertCategory(CategoriesRequest categoriesRequest) {
        CategoriesEntity toSave = new CategoriesEntity();
        toSave.setKategori(categoriesRequest.getKategori());

        return categoriesEntityRepository.save(toSave);
    }
}
