package com.cg.lms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Books;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.service.IBooksService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BooksController {
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BooksController.class);

	@Autowired
	IBooksService booksService;
	
	private static final String EXCEPTION = "Book not found with Book id ";
	
	//Get Book by Id
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> viewBookById(@PathVariable("id") int bookId) {
		//Throw exception if id is not present
		if (booksService.viewBookById(bookId) == null) {
			throw new BookNotFoundException(EXCEPTION + bookId);
		}
		Books bookById = booksService.viewBookById(bookId);
		logger.info(bookById);
		return new ResponseEntity<>(bookById, HttpStatus.OK);
	}

	//Get Books List
	@GetMapping("/books")
	public ResponseEntity<List<Books>> viewAllBooks() {
		List<Books> booksList = booksService.viewAllBooks();
		logger.info(booksList);
		return new ResponseEntity<>(booksList, HttpStatus.OK);
	}

	//Get Book by Title
	@GetMapping("/books/title/{title}")
	public ResponseEntity<List<Books>> viewBooksByTitle(@PathVariable("title") String title) {
		//Throw an exception if title is not present
		if (booksService.findAllByTitle(title).isEmpty()) {
			throw new BookNotFoundException("Book not found with Title " + title);
		}
		List<Books> bookByTitle = booksService.findAllByTitle(title);
		logger.info(bookByTitle);
		return new ResponseEntity<>(bookByTitle, HttpStatus.OK);
	}

	//Get Book by Subject
	@GetMapping("/books/subject/{subject}")
	public ResponseEntity<List<Books>> viewBooksBySubject(@PathVariable("subject") String subject) {
		//Throw an exception if subject is not present
		if (booksService.findAllBySubject(subject).isEmpty()) {
			throw new BookNotFoundException("Book not found with Subject " + subject);
		}
		List<Books> booksBySubject = booksService.findAllBySubject(subject);
		logger.info(booksBySubject);
		return new ResponseEntity<>(booksBySubject, HttpStatus.OK);
	}

	// Add new book in the table
	@PostMapping("/books")
	public ResponseEntity<Books> addBook(@RequestBody Books books) {
		Books add = booksService.addBook(books);
		logger.info(books);
		return new ResponseEntity<>(add, HttpStatus.OK);
	}

	// Delete a book from the table
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Books> deleteBook(@PathVariable("id") int bookId) {
		if (booksService.viewBookById(bookId) == null) {
			throw new BookNotFoundException(EXCEPTION + bookId);
		}
		Books delete = booksService.removeBook(bookId);
		logger.info(delete);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

	// Update values of an existing book
	@PutMapping("/books/{id}")
	public ResponseEntity<Books> updateBookDetails(@PathVariable("id") int bookId, @RequestBody Books book) {
		//Throw an exception if book id is not present
		if (booksService.viewBookById(bookId) == null) {
			throw new BookNotFoundException(EXCEPTION + bookId);
		}
		Books updateBook = booksService.updateBookDetails(book);
		logger.info(updateBook);
		return new ResponseEntity<>(updateBook, HttpStatus.OK);
	}

}
