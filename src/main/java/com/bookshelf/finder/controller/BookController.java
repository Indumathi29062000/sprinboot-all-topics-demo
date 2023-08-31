package com.bookshelf.finder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshelf.finder.entity.BookEntity;
import com.bookshelf.finder.repository.BookRepository;

@Controller
public class BookController {
	@Autowired 
	 private  BookRepository bookRepository;

	@GetMapping("/allbooks")
	@Cacheable("books") //it will cache the data in the name books
	@ResponseBody //to get data in json format without any html page
       public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
}

}
