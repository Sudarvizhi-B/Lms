package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.DamagedBooks;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.service.IDamagedBooksService;

@RestController
public class DamagedBooksController {

	@Autowired
	IDamagedBooksService damagedBooksService;
	
	private static final String EXCEPTION = "Damaged Book not found with Book id ";

	// READ
	@GetMapping("/damagedbooks/{id}")
	public ResponseEntity<DamagedBooks> viewDamagedBooksById(@PathVariable("id") int id) {
		if (damagedBooksService.viewDamagedBookById(id) == null) {
			throw new BookNotFoundException(EXCEPTION + id);
		}
		DamagedBooks viewById = damagedBooksService.viewDamagedBookById(id);
		return new ResponseEntity<>(viewById, HttpStatus.OK);
	}

	@GetMapping("/damagedbooks")
	public ResponseEntity<List<DamagedBooks>> viewDamagedBooksList() {
		List<DamagedBooks> viewList = damagedBooksService.viewDamagedBooksList();
		return new ResponseEntity<>(viewList, HttpStatus.OK);
	}

	// WRITE
	@PostMapping("/damagedbooks")
	public ResponseEntity<DamagedBooks> addDamagedBooks(@RequestBody DamagedBooks damagedbooks) {
		DamagedBooks add = damagedBooksService.addDamagedBooks(damagedbooks);
		return new ResponseEntity<>(add, HttpStatus.OK);
	}

	// UPDATE
	@PatchMapping("/damagedbooks/{id}")
	public ResponseEntity<DamagedBooks> updateDamagedBooks(@PathVariable("id") int id,
			@RequestBody DamagedBooks damagedbooks) {
		if (damagedBooksService.viewDamagedBookById(id) == null) {
			throw new BookNotFoundException(EXCEPTION + id);
		}
		DamagedBooks update = damagedBooksService.updateDamagedBookDetails(damagedbooks);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

}
