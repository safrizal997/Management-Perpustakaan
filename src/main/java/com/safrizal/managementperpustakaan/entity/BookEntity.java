package com.safrizal.managementperpustakaan.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_buku")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Integer id;
    private String namaBuku;
    private Integer tahun;

    @ManyToOne
    @JoinColumn(name = "fk_kategori", referencedColumnName = "id_kategori")
    private CategoriesEntity kategori;
    private Integer jumlah;

    public BookEntity() {
    }

    public BookEntity(String namaBuku, Integer tahun, Integer jumlah) {
        this.namaBuku = namaBuku;
        this.tahun = tahun;
        this.jumlah = jumlah;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    public Integer getTahun() {
        return tahun;
    }

    public CategoriesEntity getKategori() {
        return kategori;
    }

    public void setKategori(CategoriesEntity kategori) {
        this.kategori = kategori;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }


    public Integer getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
