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

import com.cg.lms.entity.Author;
import com.cg.lms.exception.AuthorNotFoundException;
import com.cg.lms.service.IAuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	IAuthorService ar;
	
	@PostMapping("/author")
	public ResponseEntity<Author> addAuthorDetails(@RequestBody Author author) {
		return new ResponseEntity <> (ar.addAuthorDetails(author), HttpStatus.CREATED);
	}
	@GetMapping("/author")
	public ResponseEntity <List <Author>> viewAuthorList() {
		return new ResponseEntity <>(ar.viewAuthorsList(), HttpStatus.OK);
	}
	
	@DeleteMapping("/author/{id}")
	public ResponseEntity<Author> deleteAuthorDetails(@PathVariable("id") int authorId){
		if (ar.deleteAuthorDetails(authorId)==null) {
			throw new AuthorNotFoundException("Author Not Found with id : " + authorId);
		}
		return new ResponseEntity <>(ar.deleteAuthorDetails(authorId), HttpStatus.OK);
	}
	
	@GetMapping("/author/id/{id}")
	public ResponseEntity<Author> viewauthorById(@PathVariable("id") int id){
		if (ar.viewAuthorById(id)==null) {
			throw new AuthorNotFoundException("Author Not Found with id : " + id);
		}
		return new ResponseEntity<>(ar.viewAuthorById(id), HttpStatus.OK);
	}
	
	@PutMapping("/author")
	public ResponseEntity<Author> updateAuthorDetails( @RequestBody Author author){
		if (ar.updateAuthorDetails(author)==null) {
			throw new AuthorNotFoundException("Author Not Found : " + author);
		}
		return new ResponseEntity<>(ar.updateAuthorDetails(author), HttpStatus.OK);
	}
}


