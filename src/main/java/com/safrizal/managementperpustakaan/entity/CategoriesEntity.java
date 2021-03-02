package com.safrizal.managementperpustakaan.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_kategori")
public class CategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kategori")
    private Integer id;
    private String kategori;

    public CategoriesEntity() {
    }

    public CategoriesEntity(String kategori) {
        this.kategori = kategori;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
