package com.safrizal.managementperpustakaan.model;

public class CategoriesRequest {

    private String kategori;

    public CategoriesRequest() {
    }

    public CategoriesRequest(String kategori) {
        this.kategori = kategori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
