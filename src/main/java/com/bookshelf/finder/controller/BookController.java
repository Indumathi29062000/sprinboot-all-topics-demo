package com.bookshelf.finder.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.bookshelf.finder.entity.BookEntity;
import com.bookshelf.finder.repository.BookRepository;

@Controller
public class BookController {
	Logger logger = LogManager.getLogger(BookController.class);

	@Autowired 
	 private  BookRepository bookRepository;

	@GetMapping("/getlocalbook")
	@Cacheable("books") //it will cache the data in the name books
	@ResponseBody //to get data in json format without any html page
       public List<BookEntity> getAllBooks() {
	    logger.info("Displaying all books that are in mongodb collection.");
        return bookRepository.findAll();
}
	@GetMapping("/getlocalbook/{bookName}")
	public ResponseEntity<BookEntity> getByBookName (@PathVariable String bookName) {
	    BookEntity getBook = bookRepository.findByBookName(bookName);
	    logger.info("Displaying the specific books based on bookname");

            if (getBook != null) {
	        return ResponseEntity.status(HttpStatus.OK).body(getBook);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
	@PostMapping("/createlocalbook")
	public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity bookEntity) {
	    BookEntity savedBook = bookRepository.save(bookEntity);
	    logger.info("create a book in mongodb");
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	}
	
	@DeleteMapping("/deletelocalbook/{bookName}")
	public ResponseEntity<String> deleteBook (@PathVariable String  bookName) {
		bookRepository.deleteByBookName(bookName);
	    logger.info("delete a book based on bookname");
		return ResponseEntity.status(HttpStatus.OK).body(bookName);
	}
	
	@PutMapping("/updatelocalbook/{bookId}")
	public ResponseEntity<Void> updateBook(@PathVariable String bookId, @RequestBody BookEntity updatedBook) {
	    updatedBook.setBookId(bookId);
	    bookRepository.save(updatedBook);
	    logger.info("update a book based on bookid");
	    return ResponseEntity.noContent().build();

	}
	
	@GetMapping("/books/search")
	@Cacheable("googlebooks")
    public ResponseEntity<Object> searchBooks(@RequestParam String query) {
        String apiKey = "AIzaSyAgPIkCnMzvEQpIOQtOmidYiT7BX8fPn2w";
        String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=" + query + "&key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate(); // send an HTTP GET request to the Google Books API URL
        ResponseEntity<Object> response = restTemplate.getForEntity(apiUrl, Object.class); //response entity
	    logger.info("get a book from google book api/ redis cache");
        return response;
    }

}
