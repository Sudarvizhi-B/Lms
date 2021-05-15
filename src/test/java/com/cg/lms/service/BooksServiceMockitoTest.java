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
import com.cg.lms.repository.IBooksDao;

@ExtendWith(SpringExtension.class)
class BooksServiceMockitoTest {
	
	@InjectMocks
	BooksServiceImpl booksService;
	
	@MockBean
	IBooksDao booksDao;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testAddBook() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		
		Mockito.when(booksDao.save(book)).thenReturn(book);
		Books persistBook = booksService.addBook(book);
		
		assertEquals(105, persistBook.getBookid());
		assertEquals("Wings of Fire", persistBook.getTitle());
		assertEquals("India's journey to self-reliance in technology", persistBook.getSubject());
		assertEquals("A.P.J.Abdul Kalam", persistBook.getAuthor());
		assertEquals(1999, persistBook.getPublishedYear());
		assertEquals(25, persistBook.getQuantity());
		assertEquals(150, persistBook.getBookCost());
		assertEquals("Shelf C", persistBook.getShelfDetails());
	}
	
	@Test
	public void testUpdateBook() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 250, "Shelf C");
		
		Mockito.when(booksDao.findById(105)).thenReturn(Optional.of(book));
		Mockito.when(booksDao.save(book)).thenReturn(book);
		
		Books updateBook = booksService.updateBookDetails(book);
		
		assertEquals(250,updateBook.getBookCost());
	}
	
	@Test
	public void testRemoveBook() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 250, "Shelf C");
		
		Mockito.when(booksDao.findById(105)).thenReturn(Optional.of(book));
		booksDao.deleteById(105);
		
		Books deleteBook = booksService.removeBook(105);
		
		assertEquals(105, deleteBook.getBookid());
		assertEquals("Wings of Fire", deleteBook.getTitle());
		assertEquals("India's journey to self-reliance in technology", deleteBook.getSubject());
		assertEquals("A.P.J.Abdul Kalam", deleteBook.getAuthor());
		assertEquals(1999, deleteBook.getPublishedYear());
		assertEquals(25, deleteBook.getQuantity());
		assertEquals(250, deleteBook.getBookCost());
		assertEquals("Shelf C", deleteBook.getShelfDetails());
	}
	
	@Test
	public void testViewById() {
		Books book = new Books(104, "Harry Potter", "Novel", "J.K.Rowling", 2000, "986-8-151802-2",
				25, 150, "Shelf A");
		
		Mockito.when(booksDao.findById(104)).thenReturn(Optional.of(book));
		
		Books bookById = booksService.viewBookById(104);
		
		assertEquals("Harry Potter", bookById.getTitle());
	}
	
	@Test
	public void testViewAllBooks() {
		Books book1 = new Books(104, "Harry Potter", "Novel", "J.K.Rowling", 2000, "986-8-151802-2",
				25, 150, "Shelf A");
		Books book2 = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 250, "Shelf C");
		
		List<Books> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		
		Mockito.when(booksDao.findAll()).thenReturn(books);
		
		List<Books> booksList = booksService.viewAllBooks();
		
		assertEquals(2,booksList.size());
	}
	
	@Test
	public void testViewBooksByTitle() {
		Books book1 = new Books(103, "Harry Potter", "Novel", "J.K.Rowling", 1999, "987-8-150218-8",
				20, 150, "Shelf A");
		Books book2 = new Books(104, "Harry Potter", "Novel", "J.K.Rowling", 2000, "986-8-151802-2",
				25, 120, "Shelf A");
		
		List<Books> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		
		Mockito.when(booksDao.findAllByTitle("Harry Potter")).thenReturn(books);
		
		List<Books> booksListByTitle = booksService.findAllByTitle("Harry Potter");
		
		assertEquals(2, booksListByTitle.size());
	}
	
	@Test
	public void testViewBooksBySubject() {
		Books book1 = new Books(103, "Harry Potter", "Novel", "J.K.Rowling", 1999, "987-8-150218-8",
				20, 150, "Shelf A");
		Books book2 = new Books(104, "Harry Potter", "Novel", "J.K.Rowling", 2000, "986-8-151802-2",
				25, 120, "Shelf A");
		
		List<Books> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		
		Mockito.when(booksDao.findAllBySubject("Novel")).thenReturn(books);
		
		List<Books> booksListBySubject = booksService.findAllBySubject("Novel");
		
		assertEquals(2, booksListBySubject.size());
	}

}
