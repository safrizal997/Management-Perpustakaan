package com.safrizal.managementperpustakaan.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Integer transactionId;
    private Date tglPinjam;
    private Date tglKembali;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_user")
    private UserEntity userId;

    public TransactionEntity() {
    }

    public TransactionEntity(Date tglPinjam, Date tglKembali, UserEntity userId) {
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.userId = userId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
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

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }
}
