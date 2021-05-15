package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	//READ
	@GetMapping("/books/{id}")
	public Books viewBookById(@PathVariable("id") int bookid) {
		if( booksService.viewBookById(bookid)==null) {
			throw new BookNotFoundException("Book not found with Book id "+bookid);
		}
		return booksService.viewBookById(bookid);
	}
	
	@GetMapping("/books")
	public List<Books> viewAllBooks(){
		return booksService.viewAllBooks();
	}
	
	@GetMapping("/books/title/{title}")
	public List<Books> viewBooksByTitle(@PathVariable("title") String title){
		if( booksService.findAllByTitle(title).isEmpty()) {
			throw new BookNotFoundException("Book not found with Title "+title);
		}
		return booksService.findAllByTitle(title);
	}
	
	@GetMapping("/books/subject/{subject}")
	public List<Books> viewBooksBySubject(@PathVariable("subject") String subject){
		if( booksService.findAllBySubject(subject).isEmpty()) {
			throw new BookNotFoundException("Book not found with Subject "+subject);
		}
		return booksService.findAllBySubject(subject);
	}
	
	//WRITE
	@PostMapping("/books")
	public Books addBook(@RequestBody Books books) {
		return booksService.addBook(books);
	}
	
	// DELETE
	@DeleteMapping("/books/{id}")
	public Books deleteBook(@PathVariable("id") int bookid) {
		if( booksService.viewBookById(bookid)==null) {
			throw new BookNotFoundException("Book not found with Book id "+bookid);
		}
		return booksService.removeBook(bookid);
	}
	
	//UPDATE
	@PatchMapping("/books/{id}")
	public Books updateBook(@PathVariable("id") int bookid, @RequestBody Books book) {
		if( booksService.viewBookById(bookid)==null) {
			throw new BookNotFoundException("Book not found with Book id "+bookid);
		}
		return booksService.updateBookDetails(book);
	}
	
	@PutMapping("/books/{id}")
	public Books updateBookDetails(@PathVariable("id") int bookid, @RequestBody Books book) {
		if( booksService.viewBookById(bookid)==null) {
			throw new BookNotFoundException("Book not found with Book id "+bookid);
		}
		return booksService.updateBookDetails(book);
	}
	
}
