package com.cg.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.BooksIssued;
import com.cg.lms.service.IBooksIssuedService;

@CrossOrigin
@RestController
@RequestMapping()
public class BooksIssuedController {

	Logger logger = LogManager.getLogger(BooksIssued.class);

	@Autowired
	IBooksIssuedService issueService;

	/*
	 * This below function is used to get the user using issueId and redirects to
	 * issueService
	 */
	@GetMapping("/issued/{id}")
	public ResponseEntity<BooksIssued> findUserById(@PathVariable("id") int issueId) {
		BooksIssued order = issueService.findById(issueId);
		logger.info("Getting by id");
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	/*
	 * This below function is used to list all the issueBooks and redirects to
	 * issueService
	 */
	@GetMapping("/issued")
	public ResponseEntity<List<BooksIssued>> findAll() {
		List<BooksIssued> issued = issueService.findAll();
		logger.info("Fetching all Details");
		return new ResponseEntity<>(issued, HttpStatus.OK);
	}

	/*
	 * This below function is used to add the issueBooks and redirects to
	 * issueService
	 */
	@PostMapping("/issued")
	public ResponseEntity<BooksIssued> addBooks(@RequestBody BooksIssued issued) {
		BooksIssued set = issueService.addBook(issued);
		logger.info("Adding issuedBooks");
		return new ResponseEntity<>(set, HttpStatus.OK);
	}

	/*
	 * This below function is used to update the issueBooks using issueId and
	 * redirects to issueService
	 */
	@PatchMapping("/issued/{id}")
	public ResponseEntity<BooksIssued> updateBook(@PathVariable("id") int issueId, @RequestBody BooksIssued issued) {
		BooksIssued update = issueService.update(issued);
		logger.info("Updating the issuedBooks");
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	/*
	 * This below function is used to delete issueBook using issueId and redirects
	 * to issueService
	 */
	@DeleteMapping("/issued/{id}")
	public ResponseEntity<BooksIssued> deleteBookById(@PathVariable("id") int issueId) {
		BooksIssued delete = issueService.deleteById(issueId);
		logger.info("Deleting Book by id");
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

}
