package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	//READ
	@GetMapping("/damagedbooks/{id}")
	public  DamagedBooks viewDamagedBooksById(@PathVariable ("id") int id) {
		if( damagedBooksService.viewDamagedBookById(id)==null) {
			throw new BookNotFoundException("Damaged Book not found with Id "+id);
		}
		return damagedBooksService.viewDamagedBookById(id);	
	}
	
	@GetMapping("/damagedbooks")
	public List<DamagedBooks> viewDamagedBooksList(){
		return damagedBooksService.viewDamagedBooksList();
	}
	
	// WRITE
	@PostMapping("/damagedbooks")
	public DamagedBooks addDamagedBooks(@RequestBody DamagedBooks damagedbooks) {
		return damagedBooksService.addDamagedBooks(damagedbooks);
	}
	
	//UPDATE
	@PatchMapping("/damagedbooks/{id}")
	public DamagedBooks updateDamagedBooks(@PathVariable ("id") int id, @RequestBody DamagedBooks damagedbooks) {
		if( damagedBooksService.viewDamagedBookById(id)==null) {
			throw new BookNotFoundException("Damaged Book not found with Id "+id);
		}
		return damagedBooksService.updateDamagedBookDetails(damagedbooks);
	}

}
