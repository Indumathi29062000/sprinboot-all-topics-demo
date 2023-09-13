package com.bookshelf.finder.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
@ActiveProfiles("dev")
public class BookEntityTest {

	private BookEntity bookEntity;

	
	@BeforeEach
	void setup() {
		bookEntity =new BookEntity();
	}
	@Test
	void  testGetBookId() {
		bookEntity.setBookId("1");
		assertEquals("1", bookEntity.getBookId());
	}
	@Test
	void  testSetBookId() {
		bookEntity.setBookId("1");
		assertEquals("1", bookEntity.getBookId());
	}
	@Test
	void  testGetBookName() {
		bookEntity.setBookName("testbookname");
		assertEquals("testbookname", bookEntity.getBookName());
	}
	@Test
	void  testGetAuthorName() {
		bookEntity.setAuthorName("testauthorname");
		assertEquals("testauthorname", bookEntity.getAuthorName());
	}
	@Test
	void  testGetBookSerialNumber() {
		bookEntity.setBookSerialNumber("test123abc");
		assertEquals("test123abc", bookEntity.getBookSerialNumber());
	}
	
}
