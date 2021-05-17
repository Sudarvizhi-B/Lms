package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Books;
import com.cg.lms.exception.BookNotFoundException;

@SpringBootTest
class BooksServiceTest {
	
	@Autowired
	IBooksService booksService;
	
	@Test
	public void testAddBook() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		Books books = booksService.addBook(book);
		System.out.println(books);
		
		assertEquals(105, book.getBookid());
		assertEquals("Wings of Fire", book.getTitle());
		assertEquals("India's journey to self-reliance in technology", book.getSubject());
		assertEquals("A.P.J.Abdul Kalam", book.getAuthor());
		assertEquals(1999, book.getPublishedYear());
		assertEquals(25, book.getQuantity());
		assertEquals(150, book.getBookCost());
		assertEquals("Shelf C", book.getShelfDetails());
	}
	
	@Test
	public void testUpdateBookDetails() {
		Books books = new Books();
		
		books.setBookid(105);
		books.setAuthor("A.P.J.Abdul Kalam");
		books.setBookCost(170);
		books.setIsbnCode("986-7-180715-7");
		books.setQuantity(12);
		books.setPublishedYear(1999);
		books.setShelfDetails("Shelf C");
		books.setSubject("India's journey to self-reliance in technology");
		books.setTitle("Wings of Fire");
		
		Books book = booksService.updateBookDetails(books);
		System.out.println(book);
		
		assertEquals(105, book.getBookid());
		assertEquals("Wings of Fire", book.getTitle());
		assertEquals("India's journey to self-reliance in technology", book.getSubject());
		assertEquals("A.P.J.Abdul Kalam", book.getAuthor());
		assertEquals(1999, book.getPublishedYear());
		assertEquals(12, book.getQuantity());
		assertEquals(170, book.getBookCost());
		assertEquals("Shelf C", book.getShelfDetails());
	}
	
	@Test
	public void testRemoveBook() throws BookNotFoundException{
		Books book = booksService.removeBook(105);
		
		if(book==null) {
			throw new BookNotFoundException("Book Not Found with the given Id");
		}
		System.out.println(book);
		
		assertEquals(25,book.getQuantity());
	}
	
	@Test
	public void testViewById() throws BookNotFoundException{
		Books book = booksService.viewBookById(105);
		
		if(book==null) {
			throw new BookNotFoundException("Book Not Found with the given Id");
		}
		System.out.println(book);
		
		assertEquals("Wings of Fire",book.getTitle());
	}
	
	@Test
	public void testViewAllBooks() {
		List<Books> books = booksService.viewAllBooks();
		System.out.println(books);
		
		assertEquals(4,books.size());
	}
	
	@Test
	public void testFindAllByTitle() throws BookNotFoundException{
		List<Books> books = booksService.findAllByTitle("Harry Potter");
		System.out.println(books);
		
		assertEquals(2,books.size());
	}
	
	@Test
	public void testFindAllBySubject() throws BookNotFoundException{
		List<Books> books = booksService.findAllBySubject("Novel");
		System.out.println(books);
		
		assertEquals(3,books.size());
	}
}
