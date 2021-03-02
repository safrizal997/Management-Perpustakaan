package com.safrizal.managementperpustakaan.repository;

import com.safrizal.managementperpustakaan.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesEntityRepository extends JpaRepository<CategoriesEntity,Integer> {
}
