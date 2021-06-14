package com.cg.lms.service;

import java.util.List;
import com.cg.lms.entity.Author;

public interface IAuthorService {
	
	public Author addAuthorDetails(Author author);
	public Author updateAuthorDetails(Author author, int authorId);
	public Author deleteAuthorDetails(int authorId);
	public List<Author> viewAuthorsList();
	public Author viewAuthorById(int id);
	public List<Author> findByFirstName(String firstName);
	
}
