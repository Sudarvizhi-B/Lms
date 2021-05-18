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

	private static final String EXCEPTION = "Author not found with id ";

	// WRITE
	@PostMapping("/author")
	public ResponseEntity<Author> addAuthorDetails(@RequestBody Author author) {
		return new ResponseEntity<>(ar.addAuthorDetails(author), HttpStatus.CREATED);
	}

	// READ
	@GetMapping("/author")
	public ResponseEntity<List<Author>> viewAuthorList() {
		return new ResponseEntity<>(ar.viewAuthorsList(), HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/author/{id}")
	public ResponseEntity<Author> deleteAuthorDetails(@PathVariable("id") int authorId) {
		if (ar.deleteAuthorDetails(authorId) == null) {
			throw new AuthorNotFoundException(EXCEPTION + authorId);
		}
		return new ResponseEntity<>(ar.deleteAuthorDetails(authorId), HttpStatus.OK);
	}

	// READ
	@GetMapping("/author/id/{id}")
	public ResponseEntity<Author> viewauthorById(@PathVariable("id") int id) {
		if (ar.viewAuthorById(id) == null) {
			throw new AuthorNotFoundException(EXCEPTION + id);
		}
		return new ResponseEntity<>(ar.viewAuthorById(id), HttpStatus.OK);
	}

	// UPDATE
	@PutMapping("/author")
	public ResponseEntity<Author> updateAuthorDetails(@RequestBody Author author) {
		if (ar.updateAuthorDetails(author) == null) {
			throw new AuthorNotFoundException(EXCEPTION + author);
		}
		return new ResponseEntity<>(ar.updateAuthorDetails(author), HttpStatus.OK);
	}
}
