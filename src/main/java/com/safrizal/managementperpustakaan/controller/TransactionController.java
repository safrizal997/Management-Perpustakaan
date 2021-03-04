package com.safrizal.managementperpustakaan.controller;

import com.safrizal.managementperpustakaan.model.TransactionRequest;
import com.safrizal.managementperpustakaan.model.TransactionResponse;
import com.safrizal.managementperpustakaan.service.TransactionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

    @Autowired
    TransactionEntityService transactionEntityService;

    @GetMapping(path = "/{id}")
    public TransactionResponse getTransactionByUserId(@PathVariable("id") Integer id){
        return transactionEntityService.getTransactionByUserId(id);
    }

    @PostMapping
    TransactionResponse addTransaction (@RequestBody TransactionRequest transactionRequest){
        return transactionEntityService.addTransaction(transactionRequest);
    }


}
