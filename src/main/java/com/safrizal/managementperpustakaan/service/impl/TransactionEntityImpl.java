package com.safrizal.managementperpustakaan.service.impl;

import com.safrizal.managementperpustakaan.entity.BookEntity;
import com.safrizal.managementperpustakaan.entity.DetailTransactionEntity;
import com.safrizal.managementperpustakaan.entity.TransactionEntity;
import com.safrizal.managementperpustakaan.entity.UserEntity;
import com.safrizal.managementperpustakaan.model.TransactionRequest;
import com.safrizal.managementperpustakaan.model.TransactionResponse;
import com.safrizal.managementperpustakaan.repository.BookEntityRepository;
import com.safrizal.managementperpustakaan.repository.DetailTransactionEntityRepository;
import com.safrizal.managementperpustakaan.repository.TransactionEntityRepository;
import com.safrizal.managementperpustakaan.repository.UserEntityRepository;
import com.safrizal.managementperpustakaan.service.TransactionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    BookEntityRepository bookEntityRepository;


    @Override
    public TransactionResponse getTransactionByUserId(Integer id) {

        Optional<TransactionEntity> transactionEntity = transactionEntityRepository
                .findById(id);

        if (transactionEntity.isPresent()) {

            TransactionEntity transaction = transactionEntity.get();

            List<DetailTransactionEntity> bookDetail = detailTransactionEntityRepository
                    .findByTransactionId(transaction);

            TransactionResponse transactionResponse = new TransactionResponse();
            transactionResponse.setTransaction(transaction);
            transactionResponse.setBooks(bookDetail);

            return transactionResponse;

        }

        return null;
    }

    @Override
    @Transactional
    public TransactionResponse addTransaction(TransactionRequest transactionRequest) {

        // 01. Get user from DB by ID
        Optional<UserEntity> userEntity = userEntityRepository.findById(transactionRequest.getUserId());

        // 02. Check if user present
        if (userEntity.isPresent()) {
            //03. Set new user prasent
            UserEntity user = userEntity.get();

            // 04. Set object transaction to save
            TransactionEntity transactionToSave = new TransactionEntity(
                    transactionRequest.getTglPinjam(),
                    transactionRequest.getTglKembali(),
                    user
            );

            // 05. Set and calculate lamaPeminjaman
            long lamaPinjam = transactionRequest.getTglKembali().getTime() - transactionRequest.getTglPinjam().getTime();
            int lamaPeminjaman = (int) lamaPinjam / (24 * 60 * 60 * 1000);

            // 06. Save transaction to DB
            TransactionEntity transactionFromDB = transactionEntityRepository
                    .save(transactionToSave);

            // 07. Get list of book from transaction request
            List<BookEntity> bookEntityList = transactionRequest.getBookEntityList();
            List<DetailTransactionEntity> newTransactionDetailToSave = new ArrayList<>();

            for (BookEntity books : bookEntityList) {
                // 08. Update jumlah buku
                int newJumlahBuku = books.getJumlah() - 1;
                bookEntityRepository.updateJumlah(newJumlahBuku, books.getId());

                Optional<BookEntity> optBook = bookEntityRepository.findById(books.getId());

                // 09. Set newTransactionDetailToSave
                    newTransactionDetailToSave.add(
                            new DetailTransactionEntity(
                                    optBook.orElse(null),
                                    transactionFromDB,
                                    lamaPeminjaman,
                                    1
                            )
                    );
            }

            // 10. Save newTransactionDetailToSave to BD
            List<DetailTransactionEntity> detailTransactionFromDB = detailTransactionEntityRepository
                    .saveAll(newTransactionDetailToSave);

            // 11. Final Return Transaction Response
            return new TransactionResponse(transactionFromDB, detailTransactionFromDB);

        }

        // 12. Default Response
        return null;
    }
}
