package com.safrizal.managementperpustakaan.repository;

import com.safrizal.managementperpustakaan.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Integer> {
}
