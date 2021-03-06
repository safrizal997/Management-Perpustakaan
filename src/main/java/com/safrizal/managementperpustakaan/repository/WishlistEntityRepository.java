package com.safrizal.managementperpustakaan.repository;

import com.safrizal.managementperpustakaan.entity.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistEntityRepository extends JpaRepository<WishlistEntity, Integer> {


    //@Query("select w from WishlistEntity w where w.userId.id = ?1")
    @Query(value = "select * from tbl_wishlist where user_id_id_user = ?1", nativeQuery = true)
    List<WishlistEntity> findWishlistByUserId(Integer userId);
}
