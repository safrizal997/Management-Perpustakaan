package com.safrizal.managementperpustakaan.model;

import com.safrizal.managementperpustakaan.entity.BookEntity;
import com.safrizal.managementperpustakaan.entity.UserEntity;

public class WishlistRequest {

    private Integer userId;
    private Integer bookId;

    public WishlistRequest(Integer userId, Integer bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
