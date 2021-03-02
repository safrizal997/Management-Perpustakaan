package com.safrizal.managementperpustakaan.model;

public class BookRequest {

    private String namaBuku;
    private Integer tahun;
    private Integer kategori;
    private Integer jumlah;

    public BookRequest() {
    }

    public BookRequest(String namaBuku, Integer tahun,Integer kategori ,Integer jumlah) {
        this.namaBuku = namaBuku;
        this.tahun = tahun;
        this.kategori = kategori;
        this.jumlah = jumlah;
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

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public Integer getKategori() {
        return kategori;
    }

    public void setKategori(Integer kategori) {
        this.kategori = kategori;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
