package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Books;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.service.IBooksService;

@RestController
public class BooksController {

	@Autowired
	IBooksService booksService;

	// READ
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> viewBookById(@PathVariable("id") int bookid) {
		if (booksService.viewBookById(bookid) == null) {
			throw new BookNotFoundException("Book not found with Book id " + bookid);
		}
		Books bookById = booksService.viewBookById(bookid);
		return new ResponseEntity<>(bookById, HttpStatus.OK);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Books>> viewAllBooks() {
		List<Books> booksList = booksService.viewAllBooks();
		return new ResponseEntity<>(booksList, HttpStatus.OK);
	}

	@GetMapping("/books/title/{title}")
	public ResponseEntity<List<Books>> viewBooksByTitle(@PathVariable("title") String title) {
		if (booksService.findAllByTitle(title).isEmpty()) {
			throw new BookNotFoundException("Book not found with Title " + title);
		}
		List<Books> bookByTitle = booksService.findAllByTitle(title);
		return new ResponseEntity<>(bookByTitle, HttpStatus.OK);
	}

	@GetMapping("/books/subject/{subject}")
	public ResponseEntity<List<Books>> viewBooksBySubject(@PathVariable("subject") String subject) {
		if (booksService.findAllBySubject(subject).isEmpty()) {
			throw new BookNotFoundException("Book not found with Subject " + subject);
		}
		List<Books> booksBySubject = booksService.findAllBySubject(subject);
		return new ResponseEntity<>(booksBySubject, HttpStatus.OK);
	}

	// WRITE
	@PostMapping("/books")
	public ResponseEntity<Books> addBook(@RequestBody Books books) {
		Books add = booksService.addBook(books);
		return new ResponseEntity<>(add, HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Books> deleteBook(@PathVariable("id") int bookid) {
		if (booksService.viewBookById(bookid) == null) {
			throw new BookNotFoundException("Book not found with Book id " + bookid);
		}
		Books delete = booksService.removeBook(bookid);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

	// UPDATE
	@PatchMapping("/books/{id}")
	public ResponseEntity<Books> updateBook(@PathVariable("id") int bookid, @RequestBody Books book) {
		if (booksService.viewBookById(bookid) == null) {
			throw new BookNotFoundException("Book not found with Book id " + bookid);
		}
		Books update = booksService.updateBookDetails(book);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Books> updateBookDetails(@PathVariable("id") int bookid, @RequestBody Books book) {
		if (booksService.viewBookById(bookid) == null) {
			throw new BookNotFoundException("Book not found with Book id " + bookid);
		}
		Books delete = booksService.updateBookDetails(book);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

}
