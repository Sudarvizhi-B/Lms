package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
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

	// To add publisher
	@Test
	@Disabled
	void testAddPublisher() {
		Publishers p = new Publishers(1005, "Kamala Publications", "9999958585", "Kamala@gmail.com", "1 st Street",
				"Lal Road", "Chennai", "Tamilnadu", 641011);

		Publishers persistedpubl = pService.addPublisher(p);

		assertEquals("XY Publications", persistedpubl.getPublisherName());
	}

	// To view publisher
	@Test
	@Disabled
	void testViewPublishers() {
		List<Publishers> publishers = pService.viewPublishersList();

		assertEquals(2, publishers.size());
	}

	// To Delete publisher
	@Test
	@Disabled
	void testDeletePublisherById() throws PublisherNotFoundException {
		Publishers p = pService.removePublisher(1004);

		assertEquals(1004, p.getPublisherId());
	}

	// To update publisher
	@Test
	@Disabled
	void testUpdatePublisherDetails() throws PublisherNotFoundException {
		Publishers p = pService.viewPublisherById(1005);

		p.setContactno("9999912341");
		p.setEmail("Kamalapubli@gmail.com");

		Publishers updatepub = pService.updatePublisherDetails(p);

		assertEquals("9999912341", updatepub.getContactno());
	}

	// To view publisher by id
	@Test
	@Disabled
	void testViewPublisherById() throws PublisherNotFoundException {
		Publishers ps = pService.viewPublisherById(1005);

		assertEquals("Kamala Publications", ps.getPublisherName());
	}

}
