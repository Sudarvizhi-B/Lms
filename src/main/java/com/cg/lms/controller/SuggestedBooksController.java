package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
public class SuggestedBooksController {

	@Autowired
	ISuggestedBooksService sbService;

	// READ
	@GetMapping("/viewbook/id/{id}")
	public ResponseEntity<SuggestedBooks> viewSuggestedBookDetails(@PathVariable("id") int id){
		if (sbService.viewSuggestedBookDetails(id) == null) {
			throw new BookNotFoundException("Book Not Found with id:" + id);
		}
		return new ResponseEntity<>(sbService.viewSuggestedBookDetails(id), HttpStatus.OK);
	}

	@GetMapping("/suggestedbooks")
	public ResponseEntity<List<SuggestedBooks>> viewSuggestedBooksList() {
		return new ResponseEntity<>(sbService.viewSuggestedBooksList(), HttpStatus.OK);
	}

	// WRITE
	@PostMapping("/suggestedbooks")
	public ResponseEntity<SuggestedBooks> suggestBooks(@RequestBody SuggestedBooks book) {
		return new ResponseEntity<>(sbService.suggestBooks(book), HttpStatus.CREATED);
	}

	// UPDATE
	@PutMapping("/updatebooks")
	public ResponseEntity<SuggestedBooks> updateSuggestedBookStatus(@RequestBody SuggestedBooks book) {
		return new ResponseEntity<>(sbService.updateSuggestedBookStatus(book), HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/delbook/{id}")
	public ResponseEntity<SuggestedBooks> deleteSuggestedBooks(@PathVariable("id") int id) {
		if (sbService.deleteSuggestedBooks(id) == null) {
			throw new BookNotFoundException("Book Not Found with id:" + id);
		}
		return new ResponseEntity<>(sbService.deleteSuggestedBooks(id), HttpStatus.OK);
	}

}
