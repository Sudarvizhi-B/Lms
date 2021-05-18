package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.BooksReturned;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.service.IBooksReturnedService;

@RestController
public class BooksReturnedController {

	@Autowired
	IBooksReturnedService brs;

	private static final String EXCEPTION = "Book not found with Book id ";

	// WRITE
	@PostMapping("/booksReturned")
	public ResponseEntity<BooksReturned> returnBooks(@RequestBody BooksReturned returned) {
		return new ResponseEntity<>(brs.returnBooks(returned), HttpStatus.CREATED);
	}

	// UPDATE
	@PutMapping("/booksReturned")
	public ResponseEntity<BooksReturned> updateReturnedBookDetails(@RequestBody BooksReturned returned) {
		if (brs.updateReturnedBookDetails(returned) == null) {
			throw new BookNotFoundException(EXCEPTION + returned);
		}
		return new ResponseEntity<>(brs.updateReturnedBookDetails(returned), HttpStatus.OK);
	}

	// READ
	@GetMapping("/booksReturned")
	public ResponseEntity<List<BooksReturned>> viewReturnedBooksList() {
		return new ResponseEntity<>(brs.viewReturnedBooksList(), HttpStatus.OK);
	}

	// READ
	@GetMapping("/booksDelayed/{delayedDays}")
	public ResponseEntity<List<BooksReturned>> findByDelayedDaysGreaterThanEqual(@PathVariable int delayedDays) {
		List<BooksReturned> returned = (List<BooksReturned>) brs.findByDelayedDaysGreaterThanEqual(delayedDays);
		return new ResponseEntity<>(returned, HttpStatus.OK);
	}
}
