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
	PublisherServiceImpl publisherService;

	@MockBean
	IPublisherRepository publisherRepository;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	// to view publisher by id
	@Test
	void testPublisherById() {
		Publishers publisher= new Publishers(1005, "Kamala Publications", "9999958585", "Kamala@gmail.com", "1 st Street", "Lal Road",
				"Chennai", "Tamilnadu",  641011);

		Mockito.when(publisherRepository.findById(1005)).thenReturn(Optional.of(publisher));

		Publishers publisher1 = publisherService.viewPublisherById(1005);

		assertEquals(1005, publisher1.getPublisherId());
		assertEquals("Kamala Publications", publisher1.getPublisherName());
		assertEquals("9999958585", publisher1.getContactno());
		assertEquals("Kamala@gmail.com", publisher1.getEmail());
	}

	// to add publishers
	@Test
	void testAddPublishers() {
		Publishers publisher1 = new Publishers(1006, "ABC Publications", "7777788888", "abc@gmail.com", "2nd street", "a layout",
				"Coimbatore", "Tamilnadu", 641004);

		Mockito.when(publisherRepository.save(publisher1)).thenReturn(publisher1);

		Publishers publisher2 = publisherService.addPublisher(publisher1);

		assertEquals(1006,  publisher2.getPublisherId());
		assertEquals("ABC Publications",  publisher2.getPublisherName());
	}

	// To view all publisher
	@Test
	void testAllPublishers() {
		Publishers publisher1= new Publishers(1005, "Kamala Publications", "9999958585", "Kamala@gmail.com", "1 st Street", "Lal Road",
				"Chennai", "Tamilnadu",  641011);
		Publishers  publisher2 = new Publishers(1006, "ABC Publications", "7777788888", "abc@gmail.com", "2nd street",
				"a layout", "Coimbatore", "Tamilnadu", 641004);

		List<Publishers> pList = new ArrayList<>();
		pList.add(publisher1);
		pList.add( publisher2);

		Mockito.when(publisherRepository.findAll()).thenReturn(pList);

		List<Publishers> publisherList =publisherService.viewPublishersList();

		assertEquals(2, publisherList.size());
	}

	// To update publisher
	@Test
	void testUpdatePublishers() {
		Publishers publisher1 = new Publishers(1005, "XY Publications", "8888888777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);

		Mockito.when(publisherRepository.findById(1005)).thenReturn(Optional.of(publisher1));
		Mockito.when(publisherRepository.save(publisher1)).thenReturn(publisher1);

		Publishers publisher2 = publisherService.updatePublisherDetails(publisher1);

		assertEquals(1005, publisher2.getPublisherId());
		assertEquals("XY Publications", publisher2.getPublisherName());
		assertEquals("8888888777", publisher2.getContactno());
	}

	// To delete publishers
	@Test
	void testDeletePublisher() {
		Publishers publisher1= new Publishers(1005, "Kamala Publications", "9999958585", "Kamala@gmail.com", "1 st Street", "Lal Road",
				"Chennai", "Tamilnadu",  641011);

		Mockito.when(publisherRepository.findById(1005)).thenReturn(Optional.of( publisher1));

		publisherRepository.deleteById(1005);
		Publishers persistedP = publisherService.removePublisher(1005);

		assertEquals(1005, persistedP.getPublisherId());
	}

}
