package com.safrizal.managementperpustakaan.service;

import com.safrizal.managementperpustakaan.entity.BookEntity;
import com.safrizal.managementperpustakaan.entity.CategoriesEntity;
import com.safrizal.managementperpustakaan.model.BookRequest;
import com.safrizal.managementperpustakaan.model.CategoriesRequest;

import java.util.List;

public interface BookEntityService {

List<BookEntity> getAllBook();

BookEntity insertBook (BookRequest bookRequest);

}
