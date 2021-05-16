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

import com.cg.lms.entity.Author;
import com.cg.lms.exception.AuthorNotFoundException;
import com.cg.lms.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorService ar;
	
	
	
	@PostMapping("/author")
	public Author addAuthorDetails(@RequestBody Author author) {
		return ar.addAuthorDetails(author);
	}
	@GetMapping("/author")
	public List<Author> viewAuthorList() {
		return ar.viewAuthorsList();
	}
	
	@DeleteMapping("/author/{id}")
	public Author deleteAuthorDetails(@PathVariable("id") int authorId) {
		if (ar.deleteAuthorDetails(authorId)==null) {
			throw new AuthorNotFoundException("Author Not Found with id : " + authorId);
		}
		return ar.deleteAuthorDetails(authorId);
	}
	
	@GetMapping("/author/id/{id}")
	public Author viewauthorById(@PathVariable("id") int id) {
		if (ar.viewAuthorById(id)==null) {
			throw new AuthorNotFoundException("Author Not Found with id : " + id);
		}
		return ar.viewAuthorById(id);
	}
	
	@PutMapping("/author")
	public Author updateAuthorDetails( @RequestBody Author author) {
		if (ar.updateAuthorDetails(author)==null) {
			throw new AuthorNotFoundException("Author Not Found : " + author);
		}
		return ar.updateAuthorDetails(author);
	}
}
