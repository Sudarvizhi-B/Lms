package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Publishers;
import com.cg.lms.exception.PublisherNotFoundException;

@SpringBootTest
class PublisherTest {

	@Autowired
	IPublisherService pService;

	@Test
	void testAddPublisher() {
		Publishers p = new Publishers(1005, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		
		Publishers persistedpubl = pService.addPublisher(p);
		
		assertEquals("XY Publications", persistedpubl.getPublisherName());
	}

	@Test
	void testViewPublishers() {
		List<Publishers> publishers = pService.viewPublishersList();
		
		assertEquals(2, publishers.size());
	}

	@Test
	void testDeletePublisherById() throws PublisherNotFoundException {
		Publishers p = pService.removePublisher(1004);
		
		assertEquals(1004, p.getPublisherId());
	}

	@Test
	void testUpdatePublisherDetails() throws PublisherNotFoundException {
		Publishers p = pService.viewPublisherById(1005);
		
		p.setContactno("9999912341");
		p.setEmail("fpubli@gmail.com");

		Publishers updatepub = pService.updatePublisherDetails(p);
	
		assertEquals("9999912341", updatepub.getContactno());
	}

	@Test
	void testViewPublisherById() throws PublisherNotFoundException {
		Publishers ps = pService.viewPublisherById(1005);
		
		assertEquals("XY Publications", ps.getPublisherName());
	}

}
