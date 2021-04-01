package com.safrizal.managementperpustakaan.controller;

import com.safrizal.managementperpustakaan.entity.WishlistEntity;
import com.safrizal.managementperpustakaan.model.WishlistRequest;
import com.safrizal.managementperpustakaan.service.WishlistEntityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/wishlist", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
@Api(tags = {"Wishlist Service"}, description = "Handling Wishlist Action")
public class WishlistController{

    @Autowired
    WishlistEntityService wishlistEntityService;

    @GetMapping(path = "/{user-id}")
    public List<WishlistEntity> getWislistByUserId (@PathVariable("user-id") Integer userId){
        return wishlistEntityService.getWislistByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WishlistEntity addWislist (@RequestBody WishlistRequest wishlistRequest){
        return wishlistEntityService.addWislist(wishlistRequest);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteWishlist(@PathVariable("id") Integer wishlistEntityId){
        return wishlistEntityService.deleteWishlist(wishlistEntityId);
    }
}
