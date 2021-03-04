package com.safrizal.managementperpustakaan.model;

import com.safrizal.managementperpustakaan.entity.BookEntity;

import java.sql.Date;
import java.util.List;

public class TransactionRequest {

    private Integer userId;
    private Date tglPinjam;
    private Date tglKembali;
    private List<BookEntity> bookEntityList;

    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<BookEntity> getBookEntityList() {
        return bookEntityList;
    }

    public void setBookEntityList(List<BookEntity> bookEntityList) {
        this.bookEntityList = bookEntityList;
    }
}
