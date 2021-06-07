package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.repository.IAuthorRepository;
import com.cg.lms.entity.Author;

@Service
public class AuthorServiceImpl implements IAuthorService {

	@Autowired
	IAuthorRepository authorRepo;
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(AuthorServiceImpl.class);

	
	// Add Author
	@Override
	public Author addAuthorDetails(Author author) {
		
		//logger information to be displayed in console
		logger.info(author);
		return authorRepo.save(author);
		
	}

	// Update Author
	/*
	@Override
	public Author updateAuthorDetails(Author author) {
		Optional<Author> a1 = authorRepo.findById(author.getAuthorId());
		if (!a1.isPresent()) {
			return null;
		}
		a1.get().setFirstName(author.getFirstName());
		a1.get().setLastName(author.getLastName());
		a1.get().setEmail(author.getEmail());
		a1.get().setContactno(author.getContactno());
		return authorRepo.save(a1.get());
	}
	*/

	// Delete Author
	@Override
	public Author deleteAuthorDetails(int authorId) {
		//method to delete author details
		Optional<Author> a2 = authorRepo.findById(authorId);
		if (!a2.isPresent()) {
			return null;
		}
		authorRepo.deleteById(authorId);
		//logger information to be displayed in console
		logger.info(a2);
		return a2.get();
	}

	// View Author List
	@Override
	public List<Author> viewAuthorsList() {
		//logger information to be displayed in console
		logger.info("viewing Author list");
		return authorRepo.findAll();
	}

	// View An Author By Id
	@Override
	public Author viewAuthorById(int id) {
		//method to get authorById
		Optional<Author> a3 = authorRepo.findById(id);
		if (!a3.isPresent()) {
			return null;
		}
		//logger information to be displayed in console
		logger.info(a3);
		return a3.get();

	}

	//Update Author
	@Override
	public Author updateAuthorDetails(Author author, int authorId) {
		//method to update authorDetails
		Optional<Author> a1 = authorRepo.findById(authorId);
		if (!a1.isPresent()) {
			return null;
		}
		a1.get().setFirstName(author.getFirstName());
		a1.get().setLastName(author.getLastName());
		a1.get().setEmail(author.getEmail());
		a1.get().setContactno(author.getContactno());
		logger.info(a1);   //logger information to be displayed in console
		return authorRepo.save(a1.get());
		
	}
}
