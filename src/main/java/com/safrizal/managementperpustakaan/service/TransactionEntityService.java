package com.safrizal.managementperpustakaan.service;

import com.safrizal.managementperpustakaan.entity.TransactionEntity;
import com.safrizal.managementperpustakaan.model.TransactionRequest;
import com.safrizal.managementperpustakaan.model.TransactionResponse;

public interface TransactionEntityService {

    TransactionResponse getTransactionByUserId(Integer id);

    TransactionResponse addTransaction (TransactionRequest transactionRequest);
}
