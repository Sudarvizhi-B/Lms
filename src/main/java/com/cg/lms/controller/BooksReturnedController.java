package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.BooksReturned;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.service.BooksReturnedService;

@RestController
public class BooksReturnedController {
	
	@Autowired
	BooksReturnedService brs;
	
	@PostMapping("/booksReturned")
	public BooksReturned returnBooks(@RequestBody BooksReturned returned){
		return brs.returnBooks(returned);
	}
	
	@PutMapping("/booksReturned")
	public BooksReturned updateReturnedBookDetails( @RequestBody BooksReturned returned) {
		if (brs.updateReturnedBookDetails(returned)==null) {
			throw new BookNotFoundException("Book Not Found : " +  returned);
		}
		return brs.updateReturnedBookDetails(returned);
	}
	
	@GetMapping("/booksReturned")
	public List<BooksReturned> viewReturnedBooksList(){
		return brs.viewReturnedBooksList();
	}
	
	@GetMapping("/booksDelayed/{delayedDays}")
	public List<BooksReturned> findByDelayedDaysGreaterThanEqual(@PathVariable int delayedDays){
		List <BooksReturned> returned = (List<BooksReturned>)brs.findByDelayedDaysGreaterThanEqual(delayedDays);
		return returned;
	}
	
	
}
