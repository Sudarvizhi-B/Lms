package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Books;
import com.cg.lms.entity.DamagedBooks;
import com.cg.lms.exception.BookNotFoundException;

@SpringBootTest
class DamagedBooksServiceTest {
	
	@Autowired
	IDamagedBooksService damagedBooksService;

	@Test
	public void testAddDamagedBooks() {
		DamagedBooks damagedbook = new DamagedBooks();
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",
				25, 170, "Shelf A");
		
		damagedbook.setId(3);
		damagedbook.setQuantity(2);
		damagedbook.setDescription("Pages Missing");
		damagedbook.setBooks(book);
		
		DamagedBooks damaged = damagedBooksService.addDamagedBooks(damagedbook);
		System.out.println(damaged);
		
		assertEquals(2, damaged.getQuantity());
	}
	
	@Test
	public void testUpdateDamagedBookDetail() {
		DamagedBooks damagedbook = new DamagedBooks();
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",
				25, 170, "Shelf A");
		
		damagedbook.setId(2);
		damagedbook.setQuantity(4);
		damagedbook.setDescription("Pages Missing");
		damagedbook.setBooks(book);
		
		DamagedBooks damaged = damagedBooksService.updateDamagedBookDetails(damagedbook);
		System.out.println(damaged);
		
		assertEquals(4, damaged.getQuantity());
	}
	
	@Test
	public void testViewDamagedBookList() {
		List<DamagedBooks> booksList = damagedBooksService.viewDamagedBooksList();
		System.out.println(booksList);
		
		assertEquals(2,booksList.size());
	}
	
	@Test
	public void testViewDamagedBookById() {
		DamagedBooks getDamagedBookById = damagedBooksService.viewDamagedBookById(2);
		
		if(getDamagedBookById==null) {
			throw new BookNotFoundException("Book Not Found with the given Id");
		}
		System.out.println(getDamagedBookById);
		
		assertEquals(2,getDamagedBookById.getQuantity());
	}

}
