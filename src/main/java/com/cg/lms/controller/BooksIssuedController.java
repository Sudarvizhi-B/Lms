package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public BooksIssued findUserById(@PathVariable("id") int issueId) {
		return issueService.findById(issueId);
	}

	@GetMapping("/issued")
	public List<BooksIssued> findAll() {
		return issueService.findAll();
	}

	//WRITE
	@PostMapping("/issued")
	public BooksIssued addBooks(@RequestBody BooksIssued issued) {
		return issueService.save(issued);
	}
	
	//UPDATE
	@PatchMapping("/issued/{id}")
	public BooksIssued updateBook(@PathVariable("id") int issueId, @RequestBody BooksIssued issued) {
		return issueService.update(issued);
	}
	
	//DELETE
	@DeleteMapping("/issued/{id}")
	public BooksIssued deleteBookById(@PathVariable("id") int issueId) {
		return issueService.deleteById(issueId);
	}
	
}
