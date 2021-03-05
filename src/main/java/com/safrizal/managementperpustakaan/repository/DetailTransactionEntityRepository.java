package com.safrizal.managementperpustakaan.repository;

import com.safrizal.managementperpustakaan.entity.DetailTransactionEntity;
import com.safrizal.managementperpustakaan.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailTransactionEntityRepository extends JpaRepository<DetailTransactionEntity, Integer> {


    List<DetailTransactionEntity> findByTransactionId(TransactionEntity transactionId);

}
