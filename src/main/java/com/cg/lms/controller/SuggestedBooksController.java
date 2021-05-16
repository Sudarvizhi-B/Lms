package com.cg.lms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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

	//READ
	@GetMapping("/viewbook/id/{id}")
	public SuggestedBooks viewSuggestedBookDetails(@PathVariable("id") int id) {
		if (sbService.viewSuggestedBookDetails(id) == null) {
			throw new BookNotFoundException("Book Not Found with id:" + id);
		}
		return sbService.viewSuggestedBookDetails(id);
	}

	@GetMapping("/suggestedbooks")
	public List<SuggestedBooks> viewSuggestedBooksList() {
		return sbService.viewSuggestedBooksList();
	}
	
	//WRITE
	@PostMapping("/suggestedbooks")
	public SuggestedBooks suggestBooks(@RequestBody SuggestedBooks book) {
		return sbService.suggestBooks(book);
	}
	
	//UPDATE
	@PutMapping("/updatebooks")
	public SuggestedBooks updateSuggestedBookStatus(@RequestBody SuggestedBooks book) {
		return sbService.updateSuggestedBookStatus(book);
	}

	//DELETE
	@DeleteMapping("/delbook/{id}")
	public SuggestedBooks deleteSuggestedBooks(@PathVariable("id") int id)  throws BookNotFoundException{
		if (sbService.deleteSuggestedBooks(id) == null) {
			throw new BookNotFoundException("Book Not Found with id:" + id);
		}
		return sbService.deleteSuggestedBooks(id);
	}

}
