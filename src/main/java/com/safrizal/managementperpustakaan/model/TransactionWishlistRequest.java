package com.safrizal.managementperpustakaan.model;

import com.safrizal.managementperpustakaan.entity.BookEntity;
import com.safrizal.managementperpustakaan.entity.WishlistEntity;

import java.sql.Date;
import java.util.List;

public class TransactionWishlistRequest {

    private Integer userId;
    private Date tglPinjam;
    private Date tglKembali;
    private List<WishlistEntity> bookWishlists;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public List<WishlistEntity> getBookWishlists() {
        return bookWishlists;
    }

    public void setBookWishlists(List<WishlistEntity> bookWishlists) {
        this.bookWishlists = bookWishlists;
    }
}
