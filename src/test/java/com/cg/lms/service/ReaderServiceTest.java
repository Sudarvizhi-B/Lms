package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Reader;

@SpringBootTest
class ReaderServiceTest {
	
	@Autowired
	IReaderService readerService;

	//To register Reader
	@Test
	void testRegisterReader() {
		Reader reader= new Reader(101,"abc","Sandhyana","N","9739450654","san@gmail.com");
		Reader reader1=readerService.register(reader);
		
		assertEquals("Sandhyana",reader1.getFirstName());
	}
	
	// To update reader
	@Test
	void testUpdateReaderDetails() {
		Reader reader= new Reader();
		
		reader.setId(101);
		reader.setFirstName("San");
		reader.setLastName("joy");
		reader.setMobileNo("1234567890");
		reader.setPassword("xyz");
		reader.setEmail("san@gmail.com");
		
		Reader reader1= readerService.updateReaderDetails(reader);
		
		assertEquals("San", reader1.getFirstName());
	}
	
	// To view all Readers
	@Test
	void testViewReaderList() {
		List<Reader> reader= readerService.viewReadersList();
		
		assertEquals(2, reader.size());
	}
	
	// To view reader by id
	@Test
	void testViewReaderById() {
		Reader reader=readerService.viewReaderById(101);
		
		assertEquals("San", reader.getFirstName());
	}

	// To delete reader by id
	@Test
	void testDeleteReaderById() {
		Reader reader= readerService.deleteReader(101);
		
		assertEquals(101, reader.getId() );
	}
	
}
