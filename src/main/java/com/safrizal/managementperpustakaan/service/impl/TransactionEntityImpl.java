package com.safrizal.managementperpustakaan.service.impl;

import com.safrizal.managementperpustakaan.entity.BookEntity;
import com.safrizal.managementperpustakaan.entity.DetailTransactionEntity;
import com.safrizal.managementperpustakaan.entity.TransactionEntity;
import com.safrizal.managementperpustakaan.entity.UserEntity;
import com.safrizal.managementperpustakaan.model.TransactionRequest;
import com.safrizal.managementperpustakaan.model.TransactionResponse;
import com.safrizal.managementperpustakaan.repository.DetailTransactionEntityRepository;
import com.safrizal.managementperpustakaan.repository.TransactionEntityRepository;
import com.safrizal.managementperpustakaan.repository.UserEntityRepository;
import com.safrizal.managementperpustakaan.service.TransactionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionEntityImpl implements TransactionEntityService {

    @Autowired
    TransactionEntityRepository transactionEntityRepository;

    @Autowired
    DetailTransactionEntityRepository detailTransactionEntityRepository;

    @Autowired
    UserEntityRepository userEntityRepository;


    @Override
    public TransactionResponse getTransactionByUserId(Integer id) {

        Optional<TransactionEntity> transactionEntity = transactionEntityRepository
                .findById(id);

        if (transactionEntity.isPresent()) {

            TransactionEntity pinjam = transactionEntity.get();

            List<DetailTransactionEntity> bookDetail = detailTransactionEntityRepository
                    .findByTransactionId(pinjam.getTransactionId());

            TransactionResponse transactionResponse = new TransactionResponse();
            transactionResponse.setPinjam(pinjam);
            transactionResponse.setBooks(bookDetail);

            return transactionResponse;

        }

        return null;
    }

    @Override
    public TransactionResponse addTransaction(TransactionRequest transactionRequest) {

        Optional<UserEntity> userEntity = userEntityRepository.findById(transactionRequest.getUserId());

        if (userEntity.isPresent()) {
            UserEntity user = userEntity.get();

            TransactionEntity transactionToSave = new TransactionEntity(
                    transactionRequest.getTglPinjam(),
                    transactionRequest.getTglKembali(),
                    user
            );

            int lamaPeminjaman = transactionRequest.getTglPinjam()
                    .compareTo(transactionRequest.getTglKembali());

            TransactionEntity transactionFromDB = transactionEntityRepository
                    .save(transactionToSave);

            List<BookEntity> bookEntityList = transactionRequest.getBookEntityList();
            List<DetailTransactionEntity> newTransactionDetailToSave = new ArrayList<>();


            for (BookEntity books : bookEntityList) {
                newTransactionDetailToSave.add(
                        new DetailTransactionEntity(
                                books,
                                transactionFromDB,
                                lamaPeminjaman,
                                bookEntityList.size()
                        )
                );

            }

            List<DetailTransactionEntity> detailTransactionFromDB = detailTransactionEntityRepository
                    .saveAll(newTransactionDetailToSave);

            return new TransactionResponse(transactionFromDB, detailTransactionFromDB);

        }

        return null;
    }
}
