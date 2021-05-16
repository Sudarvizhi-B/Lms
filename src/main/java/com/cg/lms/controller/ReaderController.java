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

import com.cg.lms.entity.Reader;
import com.cg.lms.exception.ReaderNotFoundException;
import com.cg.lms.service.IReaderService;

@RestController
public class ReaderController {
	
	@Autowired
	IReaderService readerService;
	
	//READ
	@GetMapping("/reader")
	public List<Reader> viewReaderList(Reader reader){
		return readerService.viewReadersList();
	}
	
	@GetMapping("/reader/{id}")
	public Reader viewReaderById(@PathVariable("id") int id){
		if( readerService.viewReaderById(id)==null) {
			throw new ReaderNotFoundException("reader not found with id: "+id);
		}
		return readerService.viewReaderById(id);
	}
	
	//WRITE
	@PostMapping("/reader")
	public Reader registerReader(@RequestBody Reader reader){
		return readerService.register(reader);
	}
	
	//UPDATE
	@PutMapping("/reader/{id}")
	public Reader updateReaderdetail(@PathVariable("id")int id, @RequestBody Reader reader){
		if(readerService.updateReaderDetails(reader)==null){
			throw new ReaderNotFoundException("reader not found with id: "+id);
		}
		return readerService.updateReaderDetails(reader);
	}
	
	//DELETE
	@DeleteMapping("/reader/{id}")
	public Reader deleteReader(@PathVariable("id") int id){
		if(readerService.deleteReader(id)==null){
			throw new ReaderNotFoundException("reader not found with id: "+id);
		}
		return readerService.deleteReader(id);
	}
	
}
