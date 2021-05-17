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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.BooksIssued;
import com.cg.lms.service.IBooksIssuedService;

@RestController
public class BooksIssuedController {

	@Autowired
	IBooksIssuedService issueService;

	//READ
	@GetMapping("/issued/{id}")
	public ResponseEntity<BooksIssued> findUserById(@PathVariable("id") int issueId) {
		BooksIssued order = issueService.findById(issueId);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}

	@GetMapping("/issued")
	public ResponseEntity<List<BooksIssued>> findAll() {
		List<BooksIssued> issued = issueService.findAll();
		return new ResponseEntity<>(issued,HttpStatus.OK);
	}

	//WRITE
	@PostMapping("/issued")
	public ResponseEntity<BooksIssued> addBooks(@RequestBody BooksIssued issued) {
		BooksIssued set = issueService.addBook(issued);
		return new ResponseEntity<>(set,HttpStatus.OK);
	}
	
	//UPDATE
	@PatchMapping("/issued/{id}")
	public ResponseEntity<BooksIssued> updateBook(@PathVariable("id") int issueId, @RequestBody BooksIssued issued) {
		BooksIssued update = issueService.update(issued);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}
	
	//DELETE
	@DeleteMapping("/issued/{id}")
	public ResponseEntity<BooksIssued> deleteBookById(@PathVariable("id") int issueId) {
		BooksIssued delete = issueService.deleteById(issueId);
		return new ResponseEntity<>(delete,HttpStatus.OK);
	}
	
}
