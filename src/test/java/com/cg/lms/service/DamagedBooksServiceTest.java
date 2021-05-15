package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
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
		Books book = new Books(103, "The Kite Runner", "Novel", "Khaled Hosseini", 2005, "986-8-181502-8",
				15, 200, "Shelf A");
		
		damagedbook.setId(2);
		damagedbook.setQuantity(2);
		damagedbook.setDescription("Pages Missing");
		damagedbook.setBooks(book);
		
		DamagedBooks damaged = damagedBooksService.addDamagedBooks(damagedbook);
		System.out.println(damaged);
		
		assertEquals(2, damaged.getQuantity());
	}
	
	@Test
	@Disabled
	public void testUpdateDamagedBookDetail() {
		DamagedBooks damagedbook = new DamagedBooks();
		Books book = new Books(103, "The Kite Runner", "Novel", "Khaled Hosseini", 2005, "986-8-181502-8",
				15, 200, "Shelf A");
		
		damagedbook.setId(2);
		damagedbook.setQuantity(4);
		damagedbook.setDescription("Pages Missing");
		damagedbook.setBooks(book);
		
		DamagedBooks damaged = damagedBooksService.updateDamagedBookDetails(damagedbook);
		System.out.println(damaged);
		
		assertEquals(4, damaged.getQuantity());
	}
	
	@Test
	@Disabled
	public void testViewDamagedBookList() {
		List<DamagedBooks> booksList = damagedBooksService.viewDamagedBooksList();
		System.out.println(booksList);
		
		assertEquals(2,booksList.size());
	}
	
	@Test
	@Disabled
	public void testViewDamagedBookById() {
		DamagedBooks getDamagedBookById = damagedBooksService.viewDamagedBookById(1);
		
		if(getDamagedBookById==null) {
			throw new BookNotFoundException("Book Not Found with the given Id");
		}
		System.out.println(getDamagedBookById);
		
		assertEquals(3,getDamagedBookById.getQuantity());
	}

}
