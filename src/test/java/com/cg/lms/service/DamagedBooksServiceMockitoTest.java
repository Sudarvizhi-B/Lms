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

import com.cg.lms.entity.Books;
import com.cg.lms.entity.DamagedBooks;
import com.cg.lms.repository.IDamagedBooksDao;

@ExtendWith(SpringExtension.class)
class DamagedBooksServiceMockitoTest {
	
	@InjectMocks
	DamagedBooksServiceImpl damagedBooksService;
	
	@MockBean
	IDamagedBooksDao damagedBooksDao;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testAddDamagedBooks() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		DamagedBooks damagedBooks = new DamagedBooks(1, 2, "Pages Missing", book);
		
		Mockito.when(damagedBooksDao.save(damagedBooks)).thenReturn(damagedBooks);
		
		DamagedBooks damagedBook = damagedBooksService.addDamagedBooks(damagedBooks);
		
		assertEquals(2,damagedBook.getQuantity());
		assertEquals("Pages Missing",damagedBook.getDescription());
	}
	
	@Test
	public void testUpdateDamagedBooks() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		DamagedBooks damagedBooks = new DamagedBooks(1, 4, "Pages Missing", book);
		
		Mockito.when(damagedBooksDao.findById(1)).thenReturn(Optional.of(damagedBooks));
		Mockito.when(damagedBooksDao.save(damagedBooks)).thenReturn(damagedBooks);
		
		DamagedBooks updateBook = damagedBooksService.updateDamagedBookDetails(damagedBooks);
		
		assertEquals(4, updateBook.getQuantity());
	}
	
	@Test
	public void testViewDamagedBooksById() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		DamagedBooks damagedBooks = new DamagedBooks(1, 4, "Pages Missing", book);
		
		Mockito.when(damagedBooksDao.findById(1)).thenReturn(Optional.of(damagedBooks));
		
		DamagedBooks viewDamagedBookById = damagedBooksService.viewDamagedBookById(1);
		
		assertEquals(4, viewDamagedBookById.getQuantity());
	}
	
	@Test
	public void testViewDamagedBooksList() {
		Books book1 = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		DamagedBooks damagedBooks1 = new DamagedBooks(1, 4, "Pages Missing", book1);
		Books book2 = new Books(104, "Harry Potter", "Novel", "J.K.Rowling", 2000, "986-8-151802-2",
				25, 150, "Shelf A");
		DamagedBooks damagedBooks2 = new DamagedBooks(2, 3, "Pages Missing", book2);
		
		List<DamagedBooks> damagedBooksList = new ArrayList<>();
		damagedBooksList.add(damagedBooks1);
		damagedBooksList.add(damagedBooks2);
		
		Mockito.when(damagedBooksDao.findAll()).thenReturn(damagedBooksList);
		
		List<DamagedBooks> viewDamagedBooksList = damagedBooksService.viewDamagedBooksList();
		
		assertEquals(2, viewDamagedBooksList.size());
	}
}
