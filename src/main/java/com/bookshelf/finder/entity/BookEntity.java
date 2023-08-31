package com.bookshelf.finder.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;


@Document(collection="bookstore") //to mention the mongodb database with collection name
public class BookEntity {

	@Id
    private String bookId;
	private String bookName;
    private String authorName;
    private String bookSerialNumber;

    public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBookSerialNumber() {
		return bookSerialNumber;
	}
	public void setBookSerialNumber(String bookSerialNumber) {
		this.bookSerialNumber = bookSerialNumber;
	}
	
	public BookEntity(){};
}
