package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Reader;

@SpringBootTest
class ReaderServiceTest {
	org.apache.logging.log4j.Logger logger= LogManager.getLogger(ReaderServiceTest.class);
	
	@Autowired
	IReaderService readerService;

	//To register Reader
	@Test
	void testRegisterReader() {
		Reader reader= new Reader("abc","Sandhyana","N","9739450654","san@gmail.com");
		Reader reader1=readerService.register(reader);
		logger.info(reader1);
		
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
		logger.info(reader1);
		assertEquals("San", reader1.getFirstName());
	}
	
	// To view all Readers
	@Test
	void testViewReaderList() {
		List<Reader> reader= readerService.viewReadersList();
		logger.info(reader);
		assertEquals(2, reader.size());
	}
	
	// To view reader by id
	@Test
	void testViewReaderById() {
		Reader reader=readerService.viewReaderById(101);
		logger.info(reader);
		assertEquals("San", reader.getFirstName());
	}

	// To delete reader by id
	@Test
	void testDeleteReaderById() {
		Reader reader= readerService.deleteReader(101);
		logger.info(reader);
		assertEquals(101, reader.getId() );
	}
	
}
