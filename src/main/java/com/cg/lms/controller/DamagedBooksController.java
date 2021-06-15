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

import com.cg.lms.entity.BooksOrder;
import com.cg.lms.entity.DamagedBooks;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.service.IDamagedBooksService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DamagedBooksController {

	@Autowired
	IDamagedBooksService damagedBooksService;
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DamagedBooksController.class);

	private static final String EXCEPTION = "Damaged Book not found with id ";

	// Get damaged book by id
	@GetMapping("/damagedbooks/{id}")
	public ResponseEntity<DamagedBooks> viewDamagedBooksById(@PathVariable("id") int id) {
		// Throw an exception if id is not present
		if (damagedBooksService.viewDamagedBookById(id) == null) {
			throw new BookNotFoundException(EXCEPTION + id);
		}
		DamagedBooks viewById = damagedBooksService.viewDamagedBookById(id);
		logger.info(viewById);
		return new ResponseEntity<>(viewById, HttpStatus.OK);
	}

	// Get list of damaged books
	@GetMapping("/damagedbooks")
	public ResponseEntity<List<DamagedBooks>> viewDamagedBooksList() {
		List<DamagedBooks> viewList = damagedBooksService.viewDamagedBooksList();
		logger.info(viewList);
		return new ResponseEntity<>(viewList, HttpStatus.OK);
	}

	@GetMapping("/damagedbooks/quantity/{quantity}")
	public List<DamagedBooks> getBookByQuantity(@PathVariable("quantity") int quantity) {
		return damagedBooksService.viewDamagedBookByQuantity(quantity);
	}
	
	// Add a new damaged book in the table
	@PostMapping("/damagedbooks")
	public ResponseEntity<DamagedBooks> addDamagedBooks(@RequestBody DamagedBooks damagedBooks) {
		DamagedBooks add = damagedBooksService.addDamagedBooks(damagedBooks);
		logger.info(add);
		return new ResponseEntity<>(add, HttpStatus.OK);
	}

	// Update values of an existing book
	@PutMapping("/damagedbooks/{id}")
	public ResponseEntity<DamagedBooks> updateDamagedBooks(@PathVariable("id") int id,
			@RequestBody DamagedBooks damagedBooks) {
		// Throw an exception if id is not present
		if (damagedBooksService.viewDamagedBookById(id) == null) {
			throw new BookNotFoundException(EXCEPTION + id);
		}
		DamagedBooks update = damagedBooksService.updateDamagedBookDetails(damagedBooks);
		logger.info(update);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	//Delete damaged book from the table
	@DeleteMapping("/damagedbooks/{id}")
	public ResponseEntity<DamagedBooks> deletedamagedBook(@PathVariable("id") int id) {
		// Throw an exception if id is not present
		if (damagedBooksService.viewDamagedBookById(id) == null) {
			throw new BookNotFoundException(EXCEPTION + id);
		}
		DamagedBooks delete = damagedBooksService.deleteDamagedBook(id);
		logger.info(delete);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

}
