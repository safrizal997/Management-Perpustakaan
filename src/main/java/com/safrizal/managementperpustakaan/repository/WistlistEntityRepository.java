package com.safrizal.managementperpustakaan.repository;

import com.safrizal.managementperpustakaan.entity.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WistlistEntityRepository extends JpaRepository<WishlistEntity, Integer> {
}
