package com.safrizal.managementperpustakaan.model;

import com.safrizal.managementperpustakaan.entity.DetailTransactionEntity;
import com.safrizal.managementperpustakaan.entity.TransactionEntity;

import java.util.List;

public class TransactionResponse {

   private TransactionEntity pinjam;
   private List<DetailTransactionEntity> books;

    public TransactionResponse() {
    }

    public TransactionResponse(TransactionEntity pinjam, List<DetailTransactionEntity> books) {
        this.pinjam = pinjam;
        this.books = books;
    }

    public TransactionEntity getPinjam() {
        return pinjam;
    }

    public void setPinjam(TransactionEntity pinjam) {
        this.pinjam = pinjam;
    }

    public List<DetailTransactionEntity> getBooks() {
        return books;
    }

    public void setBooks(List<DetailTransactionEntity> books) {
        this.books = books;
    }
}
