package com.safrizal.managementperpustakaan.repository;

import com.safrizal.managementperpustakaan.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookEntityRepository extends JpaRepository<BookEntity, Integer> {

    @Modifying
    @Query("update BookEntity b set b.jumlah = :jumlah where b.id = :id")
    void updateJumlah(@Param("jumlah")  Integer jumlah,@Param("id")  Integer id);
}
