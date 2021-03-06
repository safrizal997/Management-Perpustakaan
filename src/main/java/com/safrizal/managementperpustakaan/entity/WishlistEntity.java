package com.safrizal.managementperpustakaan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_wishlist")
public class WishlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_user")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_book")
    private BookEntity bookId;
    private Date tgl = new Date();

    public WishlistEntity(UserEntity userId, BookEntity bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public WishlistEntity() {
    }

    public WishlistEntity(Date tgl) {
        this.tgl = tgl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public BookEntity getBookId() {
        return bookId;
    }

    public void setBookId(BookEntity bookId) {
        this.bookId = bookId;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }
}
