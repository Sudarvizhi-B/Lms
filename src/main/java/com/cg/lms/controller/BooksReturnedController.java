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

import com.cg.lms.entity.BooksReturned;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.service.IBooksReturnedService;

@CrossOrigin
@RestController
public class BooksReturnedController {

	@Autowired
	IBooksReturnedService brs;
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BooksReturnedController.class);

	private static final String EXCEPTION = "Book not found with Book id ";

	// WRITE
	@PostMapping("/booksReturned")
	public ResponseEntity<BooksReturned> returnBooks(@RequestBody BooksReturned returned) {
		logger.info("Added returnedBooks details");
		return new ResponseEntity<>(brs.returnBooks(returned), HttpStatus.CREATED);
	}

	// UPDATE
	@PutMapping("/booksReturned/update/{id}")
	public ResponseEntity<BooksReturned> updateReturnedBookDetails(@PathVariable("id")int id, @RequestBody BooksReturned returned) {
		logger.info("updated the ReturnedBook");
		// Throw an exception if id is not present
		if (brs.updateReturnedBookDetails(returned) == null) {
			throw new BookNotFoundException(EXCEPTION + returned);
		}
		return new ResponseEntity<>(brs.updateReturnedBookDetails(returned), HttpStatus.OK);
	}

	// READ
	@GetMapping("/booksReturned")
	public ResponseEntity<List<BooksReturned>> viewReturnedBooksList() {
		logger.info("viewing ReturnedBooks list");
		return new ResponseEntity<>(brs.viewReturnedBooksList(), HttpStatus.OK);
	}

	// READ
	@GetMapping("/booksDelayed/{delayedDays}")
	public ResponseEntity<List<BooksReturned>> findByDelayedDaysGreaterThanEqual(@PathVariable int delayedDays) {
		logger.info("Viewing ReturnedBooks list with delayed days greater than the parameter passed");
		List<BooksReturned> returned = (List<BooksReturned>) brs.findByDelayedDaysGreaterThanEqual(delayedDays);
		return new ResponseEntity<>(returned, HttpStatus.OK);
	}
	
	// DELETE
	@DeleteMapping("/returned/{id}")
	public ResponseEntity<BooksReturned> deleteReturnedBooks(@PathVariable("id") int id) {
		logger.info("deleting Author details");
		// Throw an exception if id is not present
		if (brs.deleteReturnedBooks(id) == null) {
			throw new BookNotFoundException(EXCEPTION + id);
		}
		return new ResponseEntity<>(brs.deleteReturnedBooks(id), HttpStatus.OK);
	}
}
