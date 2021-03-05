package com.safrizal.managementperpustakaan.model;

import com.safrizal.managementperpustakaan.entity.DetailTransactionEntity;
import com.safrizal.managementperpustakaan.entity.TransactionEntity;

import java.util.List;

public class TransactionResponse {

   private TransactionEntity transaction;
   private List<DetailTransactionEntity> books;

    public TransactionResponse() {
    }

    public TransactionResponse(TransactionEntity transaction, List<DetailTransactionEntity> books) {
        this.transaction = transaction;
        this.books = books;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public List<DetailTransactionEntity> getBooks() {
        return books;
    }

    public void setBooks(List<DetailTransactionEntity> books) {
        this.books = books;
    }
}
