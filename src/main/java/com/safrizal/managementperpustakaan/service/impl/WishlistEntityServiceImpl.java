package com.safrizal.managementperpustakaan.service.impl;

import com.safrizal.managementperpustakaan.entity.BookEntity;
import com.safrizal.managementperpustakaan.entity.UserEntity;
import com.safrizal.managementperpustakaan.entity.WishlistEntity;
import com.safrizal.managementperpustakaan.model.WishlistRequest;
import com.safrizal.managementperpustakaan.repository.BookEntityRepository;
import com.safrizal.managementperpustakaan.repository.UserEntityRepository;
import com.safrizal.managementperpustakaan.repository.WishlistEntityRepository;
import com.safrizal.managementperpustakaan.service.WishlistEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistEntityServiceImpl implements WishlistEntityService {

    @Autowired
    WishlistEntityRepository wishlistEntityRepository;

    @Autowired
    BookEntityRepository bookEntityRepository;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public List<WishlistEntity> getWislistByUserId(Integer userId) {
        return wishlistEntityRepository.findWishlistByUserId(userId);
    }

    @Override
    public WishlistEntity addWislist(WishlistRequest wishlistRequest) {
        // 01. findById userEntity from DB
        Optional<UserEntity> userEntity = userEntityRepository.findById(wishlistRequest.getUserId());
        // 02. Check userId
        if (userEntity.isPresent()) {
            // 03. Get data userEntity save to user variable
            UserEntity user = userEntity.get();
            // 04. findById bookEntity from BD
            Optional<BookEntity> bookEntity = bookEntityRepository.findById(wishlistRequest.getBookId());
            // 05. Check bookId
            if (bookEntity.isPresent()) {
                // 06. Get data bookEntity save to book variable
                BookEntity book = bookEntity.get();
                // 07. set userId param and bookId param to new Object
                WishlistEntity wishlistToSave = new WishlistEntity(user, book);
                // 08. save
                return wishlistEntityRepository.save(wishlistToSave);
            }
        }
        return null;
    }

    @Override
    public Boolean deleteWishlist(Integer wishlistEntityId) {
        Optional<WishlistEntity> wishlistEntityToDelete = wishlistEntityRepository
                .findById(wishlistEntityId);

        if (wishlistEntityToDelete.isPresent()){
            wishlistEntityRepository.deleteById(wishlistEntityId);

            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
