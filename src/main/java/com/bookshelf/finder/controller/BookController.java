package com.bookshelf.finder.controller;

import java.util.List;
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
	@Autowired 
	 private  BookRepository bookRepository;

	@GetMapping("/getlocalbook")
	@Cacheable("books") //it will cache the data in the name books
	@ResponseBody //to get data in json format without any html page
       public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
}
	@GetMapping("/getlocalbook/{bookName}")
	public ResponseEntity<BookEntity> getByBookName (@PathVariable String bookName) {
	    BookEntity getBook = bookRepository.findByBookName(bookName);
            if (getBook != null) {
	        return ResponseEntity.status(HttpStatus.OK).body(getBook);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
	@PostMapping("/createlocalbook")
	public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity bookEntity) {
	    BookEntity savedBook = bookRepository.save(bookEntity);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	}
	
	@DeleteMapping("/deletelocalbook/{bookName}")
	public ResponseEntity<String> deleteBook (@PathVariable String  bookName) {
		bookRepository.deleteByBookName(bookName);
		return ResponseEntity.status(HttpStatus.OK).body(bookName);
	}
	
	@PutMapping("/updatelocalbook/{bookId}")
	public ResponseEntity<Void> updateBook(@PathVariable String bookId, @RequestBody BookEntity updatedBook) {
	    updatedBook.setBookId(bookId);
	    bookRepository.save(updatedBook);
	    return ResponseEntity.noContent().build();

	}
	
	@GetMapping("/books/search")
	@Cacheable("googlebooks")
    public ResponseEntity<Object> searchBooks(@RequestParam String query) {
        String apiKey = "AIzaSyAgPIkCnMzvEQpIOQtOmidYiT7BX8fPn2w";
        String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=" + query + "&key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate(); // send an HTTP GET request to the Google Books API URL
        ResponseEntity<Object> response = restTemplate.getForEntity(apiUrl, Object.class); //response entity
        return response;
    }

}
