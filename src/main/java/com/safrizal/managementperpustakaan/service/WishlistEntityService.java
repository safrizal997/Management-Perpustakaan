package com.safrizal.managementperpustakaan.service;

import com.safrizal.managementperpustakaan.entity.UserEntity;
import com.safrizal.managementperpustakaan.entity.WishlistEntity;
import com.safrizal.managementperpustakaan.model.WishlistRequest;

import java.util.List;

public interface WishlistEntityService {

    List<WishlistEntity> getWislistByUserId (Integer userId);

    WishlistEntity addWislist (WishlistRequest wishlistRequest);

    Boolean deleteWishlist(Integer wishlistEntityId);
}
