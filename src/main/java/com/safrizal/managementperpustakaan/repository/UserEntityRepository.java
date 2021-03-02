package com.safrizal.managementperpustakaan.repository;

import com.safrizal.managementperpustakaan.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    Boolean existsByEmail(String email);
}
