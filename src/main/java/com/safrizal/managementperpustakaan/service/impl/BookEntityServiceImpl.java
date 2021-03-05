package com.safrizal.managementperpustakaan.service.impl;

import com.safrizal.managementperpustakaan.entity.BookEntity;
import com.safrizal.managementperpustakaan.entity.CategoriesEntity;
import com.safrizal.managementperpustakaan.model.BookRequest;
import com.safrizal.managementperpustakaan.repository.BookEntityRepository;
import com.safrizal.managementperpustakaan.repository.CategoriesEntityRepository;
import com.safrizal.managementperpustakaan.service.BookEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookEntityServiceImpl implements BookEntityService {

    @Autowired
    BookEntityRepository bookEntityRepository;

    @Autowired
    CategoriesEntityRepository categoriesEntityRepository;

    @Override
    public List<BookEntity> getAllBook() {
        return bookEntityRepository.findAll();
    }

    @Override
    public BookEntity insertBook(BookRequest bookRequest) {

    BookEntity toSave = new BookEntity();

    toSave.setNamaBuku(bookRequest.getNamaBuku());
    toSave.setTahun(bookRequest.getTahun());
    toSave.setJumlah(bookRequest.getJumlah());

    Integer id;
    id = bookRequest.getKategori();
    Optional<CategoriesEntity> fromDB = categoriesEntityRepository.findById(id);

    if (fromDB.isPresent()){
        toSave.setKategori(fromDB.get());
    }

    toSave.getJumlah(bookRequest.getJumlah());

        return bookEntityRepository.save(toSave);
    }
}
