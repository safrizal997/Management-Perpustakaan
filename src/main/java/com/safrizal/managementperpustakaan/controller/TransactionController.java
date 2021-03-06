package com.safrizal.managementperpustakaan.controller;

import com.safrizal.managementperpustakaan.model.TransactionRequest;
import com.safrizal.managementperpustakaan.model.TransactionResponse;
import com.safrizal.managementperpustakaan.model.TransactionWishlistRequest;
import com.safrizal.managementperpustakaan.service.TransactionEntityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Transaction Service"}, description = "Handling Transaction Action")
public class TransactionController {

    @Autowired
    TransactionEntityService transactionEntityService;

    @GetMapping(path = "/{id}")
    public TransactionResponse getTransactionByUserId(@PathVariable("id") Integer id){
        return transactionEntityService.getTransactionByUserId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    TransactionResponse addTransaction (@RequestBody TransactionRequest transactionRequest){
        return transactionEntityService.addTransaction(transactionRequest);
    }

    @PostMapping(path = "/from-wishlist")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse addTransactionFromWishlist (@RequestBody TransactionWishlistRequest transactionWishlistRequest){
        return transactionEntityService.addTransactionFromWishlist(transactionWishlistRequest);
    }


}
