package com.bookshelf.finder.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserEntityTest {
	;
	private UserEntity userEntity;
	@BeforeEach
	void setup() {
		userEntity =new UserEntity();
	}
	
	@Test
	void  testGetName() {
		userEntity.setName("Testname");
		assertEquals("Testname", userEntity.getName());
	}
	@Test
	void  testSetName() {
		userEntity.setName("Testname");
		assertEquals("Testname", userEntity.getName());
	}
	
	@Test
	void  testGetUserId() {
		userEntity.setUserId("testid@26");
		assertEquals("testid@26", userEntity.getUserId());
	}
	@Test
	void  testSetUserId() {
		userEntity.setUserId("testid@26");
		assertEquals("testid@26", userEntity.getUserId());
	}
	@Test
	void  testGetEmail() {
		userEntity.setEmail("testmail@gmail.com");
		assertEquals("testmail@gmail.com", userEntity.getEmail());
	}
	@Test
	void  testSetEmail() {
		userEntity.setEmail("testmail@gmail.com");
		assertEquals("testmail@gmail.com", userEntity.getEmail());
	}
	@Test
	void  testGetPassword() {
		userEntity.setPassword("Test@123");
		assertEquals("Test@123", userEntity.getPassword());
	}
	@Test
	void  testSetPassword() {
		userEntity.setPassword("Test@123");
		assertEquals("Test@123", userEntity.getPassword());
	}
	
	@Test
	void  testGetConfirmPassword() {
		userEntity.setConfirmPassword("Test@123");
		assertEquals("Test@123", userEntity.getConfirmPassword());
	}
	@Test
	void  testSetConfirmPassword() {
		userEntity.setConfirmPassword("Test@123");
		assertEquals("Test@123", userEntity.getConfirmPassword());
	}
	
}

	