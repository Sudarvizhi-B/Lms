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

	//Test case to add damaged book in the table
	@Test
	@Disabled
	public void testAddDamagedBooks() {
		DamagedBooks damagedbook = new DamagedBooks();
		Books book = new Books(109, "Ephipany", "Wings", "Jin", 2016, "965-7-153018-8",
				14, 160, "Shelf B");
		
		damagedbook.setId(2);
		damagedbook.setQuantity(1);
		damagedbook.setDescription("Pages Missing");
		damagedbook.setBooks(book);
		
		DamagedBooks damaged = damagedBooksService.addDamagedBooks(damagedbook);
		System.out.println(damaged);
		
		assertEquals(2, damaged.getQuantity());
	}
	
	//Test case to update damaged book in the table
	@Test
	@Disabled
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
	
	//Test case to delete damaged book from the table
	@Test
	public void testdeleteDamagedBook() {
		DamagedBooks deleteBook = damagedBooksService.deleteDamagedBook(3);
		
		if(deleteBook==null) {
			throw new BookNotFoundException("Book Not Found with the given Id");
		}
		System.out.println(deleteBook);
		
		assertEquals(3,deleteBook.getQuantity());
	}
	
	//Test case to get list of damaged books from the table
	@Test
	@Disabled
	public void testViewDamagedBookList() {
		List<DamagedBooks> booksList = damagedBooksService.viewDamagedBooksList();
		System.out.println(booksList);
		
		assertEquals(2,booksList.size());
	}
	
	//Test case to get damaged book by in the table
	@Test
	@Disabled
	public void testViewDamagedBookById() {
		DamagedBooks getDamagedBookById = damagedBooksService.viewDamagedBookById(2);
		
		if(getDamagedBookById==null) {
			throw new BookNotFoundException("Book Not Found with the given Id");
		}
		System.out.println(getDamagedBookById);
		
		assertEquals(2,getDamagedBookById.getQuantity());
	}

}
