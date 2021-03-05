package com.safrizal.managementperpustakaan.entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_detail_transaction")
public class DetailTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail_transaction")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_book", referencedColumnName = "id_book")
    private BookEntity bookId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pinjam", referencedColumnName = "id_transaction")
    private TransactionEntity transactionId;

    private Integer lamaPeminjaman;
    private Integer jumlah;



    public DetailTransactionEntity() {
    }


    public DetailTransactionEntity(BookEntity bookId, TransactionEntity transactionId, Integer lamaPeminjaman, Integer jumlah) {
        this.bookId = bookId;
        this.transactionId = transactionId;
        this.lamaPeminjaman = lamaPeminjaman;
        this.jumlah = jumlah;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookEntity getBookId() {
        return bookId;
    }

    public void setBookId(BookEntity bookId) {
        this.bookId = bookId;
    }

    public TransactionEntity getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(TransactionEntity transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getLamaPeminjaman() {
        return lamaPeminjaman;
    }

    public void setLamaPeminjaman(Integer lamaPeminjaman) {
        this.lamaPeminjaman = lamaPeminjaman;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
