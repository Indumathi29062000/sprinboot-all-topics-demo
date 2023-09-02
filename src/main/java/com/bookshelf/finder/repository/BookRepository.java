package com.bookshelf.finder.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookshelf.finder.entity.BookEntity;
//extends mongorepository
public interface BookRepository extends MongoRepository<BookEntity,String> {
    void deleteByBookName(String bookName);
    BookEntity  findByBookName(String bookName);

}
