package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.repository.IAuthorRepository;
import com.cg.lms.entity.Author;

@Service
public class AuthorServiceImpl implements IAuthorService {

	@Autowired
	IAuthorRepository authorRepo;

	// Add Author
	@Override
	public Author addAuthorDetails(Author author) {
		return authorRepo.save(author);
	}

	// Update Author
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

	// Delete Author
	@Override
	public Author deleteAuthorDetails(int authorId) {
		Optional<Author> a2 = authorRepo.findById(authorId);
		if (!a2.isPresent()) {
			return null;
		}
		authorRepo.deleteById(authorId);
		return a2.get();
	}

	// View Author List
	@Override
	public List<Author> viewAuthorsList() {
		return authorRepo.findAll();
	}

	// View An Author By Id
	@Override
	public Author viewAuthorById(int id) {
		Optional<Author> a3 = authorRepo.findById(id);
		if (!a3.isPresent()) {
			return null;
		}
		return a3.get();

	}
}
