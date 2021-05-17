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

	@Test
	void testRegisterReader() {
		Reader reader= new Reader(101,"abc","Sandhyana","N","9739450654","san@gmail.com");
		Reader reader1=readerService.register(reader);
		
		assertEquals("Sandhyana",reader1.getFirstName());
	}
	
	@Test
	void testUpdateReaderDetails() {
		Reader reader= new Reader();
		
		reader.setId(101);
		reader.setFirstName("San");
		reader.setLastName("joy");
		reader.setMobileNo("1234567890");
		reader.setPassword("xyz");
		
		Reader reader1= readerService.updateReaderDetails(reader);
		
		assertEquals("San", reader1.getFirstName());
	}
	
	@Test
	void testViewReaderList() {
		List<Reader> reader= readerService.viewReadersList();
		
		assertEquals(1, reader.size());
	}
	
	@Test
	void testViewReaderById() {
		Reader reader=readerService.viewReaderById(101);
		
		assertEquals("San", reader.getFirstName());
	}

	@Test
	void testDeleteReaderById() {
		Reader reader= readerService.deleteReader(101);
		
		assertEquals(101, reader.getId() );
	}
	
}
