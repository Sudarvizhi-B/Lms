package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.lms.entity.Publishers;
import com.cg.lms.repository.IPublisherRepository;

@ExtendWith(SpringExtension.class)
class PublisherServiceMockitoTest {
	
	@InjectMocks
	PublisherServiceImpl ps;

	@MockBean
	IPublisherRepository pr;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testPublisherById() {
		Publishers p = new Publishers(1005, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		
		Mockito.when(pr.findById(1005)).thenReturn(Optional.of(p));
		
		Publishers p1 = ps.viewPublisherById(1005);
		
		assertEquals(1005, p1.getPublisherId());
		assertEquals("XY Publications",p1.getPublisherName());
		assertEquals("7777788777",p1.getContactno());
		assertEquals("xy@gmail.com",p1.getEmail());
	}

	@Test
	void testAddPublishers() {
		Publishers p = new Publishers(1006, "ABC Publications", "7777788888", "abc@gmail.com", "2nd street", "a layout",
				"Coimbatore", "Tamilnadu", 641004);
		
		Mockito.when(pr.save(p)).thenReturn(p);
		
		Publishers p2 = ps.addPublisher(p);
		
		assertEquals(1006, p2.getPublisherId());
		assertEquals("ABC Publications", p2.getPublisherName());
	}

	@Test
	void testAllPublishers() {
		Publishers p = new Publishers(1005, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		Publishers p2 = new Publishers(1006, "ABC Publications", "7777788888", "abc@gmail.com", "2nd street",
				"a layout", "Coimbatore", "Tamilnadu", 641004);
		
		List<Publishers> pList = new ArrayList<>();
		pList.add(p);
		pList.add(p2);
		
		Mockito.when(pr.findAll()).thenReturn(pList);
		
		List<Publishers> pub = ps.viewPublishersList();
		
		assertEquals(2, pub.size());
	}

	@Test
	void testUpdatePublishers() {
		Publishers p = new Publishers(1005, "XY Publications", "8888888777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		
		Mockito.when(pr.findById(1005)).thenReturn(Optional.of(p));
		Mockito.when(pr.save(p)).thenReturn(p);
		
		Publishers pp = ps.updatePublisherDetails(p);
		
		assertEquals(1005, pp.getPublisherId());
		assertEquals("XY Publications",pp.getPublisherName());
		assertEquals("8888888777", pp.getContactno());
	}
	
	@Test
	void testDeletePublisher() {
		Publishers p = new Publishers(1005, "XY Publications", "8888888777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		
		Mockito.when(pr.findById(1005)).thenReturn(Optional.of(p));
		
		pr.deleteById(1005);
		Publishers persistedP = ps.removePublisher(1005);
		
		assertEquals(1005, persistedP.getPublisherId());	
	}

}
