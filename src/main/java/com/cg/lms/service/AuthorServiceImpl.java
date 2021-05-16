package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.repository.IAuthorRepository;
import com.cg.lms.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	IAuthorRepository ar;

	@Override
	public Author addAuthorDetails(Author author) {
		return ar.save(author);
	}

	@Override
	public Author updateAuthorDetails(Author author) {
		Optional <Author> a2 = ar.findById(author.getAuthorId());
		if(!a2.isPresent()) {
			return null;
		}
		a2.get().setFirstName(author.getFirstName());
		a2.get().setLastName(author.getLastName());
		a2.get().setEmail(author.getEmail());
		a2.get().setContactno(author.getContactno());
		return ar.save(a2.get());
	}
	
	@Override
	public Author deleteAuthorDetails(int authorId) {
		Optional<Author> a = ar.findById(authorId);
		if(!a.isPresent()) {
			return null;
		}
		ar.deleteById(authorId);
		return a.get();
	}

	@Override
	public List<Author> viewAuthorsList() {
		return ar.findAll();
	}

	@Override
	public Author viewAuthorById(int id) {
		Optional<Author> a1 = ar.findById(id);
		if(!a1.isPresent()) {
			return null;
		}
		return a1.get();
		
	}
	


}
