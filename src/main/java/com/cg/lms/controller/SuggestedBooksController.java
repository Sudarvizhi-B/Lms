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

import com.cg.lms.entity.SuggestedBooks;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.service.ISuggestedBooksService;

@CrossOrigin
@RestController
public class SuggestedBooksController {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(SuggestedBooksController.class);

	@Autowired
	ISuggestedBooksService sbService;

	private static final String EXCEPTION = "Book not found with Book id ";

	// READ
	@GetMapping("/suggestedbooks/viewbook/{id}")
	public ResponseEntity<SuggestedBooks> viewSuggestedBookDetails(@PathVariable("id") int id) {
		logger.info("View Suggested Books By Id");
		// Throw an exception if Book id is not present
		if (sbService.viewSuggestedBookDetails(id) == null) {
			throw new BookNotFoundException(EXCEPTION + id);
		}
		return new ResponseEntity<>(sbService.viewSuggestedBookDetails(id), HttpStatus.OK);
	}

	@GetMapping("/suggestedbooks")
	public ResponseEntity<List<SuggestedBooks>> viewSuggestedBooksList() {
		logger.info("View All Suggested Books ");
		return new ResponseEntity<>(sbService.viewSuggestedBooksList(), HttpStatus.OK);
	}

	// WRITE
	@PostMapping("/suggestedbooks")
	public ResponseEntity<SuggestedBooks> suggestBooks(@RequestBody SuggestedBooks book) {
		logger.info("Adding Suggested Books Details");
		return new ResponseEntity<>(sbService.suggestBooks(book), HttpStatus.CREATED);
	}

	// UPDATE
	@PutMapping("/suggestedbooks/update/{id}")
	public ResponseEntity<SuggestedBooks> updateSuggestedBookStatus(@PathVariable("id") int id, @RequestBody SuggestedBooks book) {
		logger.info("Updating Suggested Books Details");
		return new ResponseEntity<>(sbService.updateSuggestedBookStatus(id,book), HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/suggestedbooks/deletebook/{id}")
	public ResponseEntity<SuggestedBooks> deleteSuggestedBooks(@PathVariable("id") int id) {
		logger.info("Deleting Suggested Books By Id");
		// Throw an exception if Book id is not present
		if (sbService.deleteSuggestedBooks(id) == null) {
			throw new BookNotFoundException(EXCEPTION + id);
		}
		return new ResponseEntity<>(sbService.deleteSuggestedBooks(id), HttpStatus.OK);
	}
	
	@GetMapping("/suggestedbooks/title/{title}")
	public ResponseEntity<List<SuggestedBooks>> findAllByTitle(@PathVariable("title") String title){
		logger.info("Search  Book By Title");
		return new ResponseEntity<>(sbService.findAllByTitle(title), HttpStatus.OK);
	}
 
}