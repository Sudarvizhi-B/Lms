package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Author;

public interface AuthorService {

	public Author addAuthorDetails(Author author);
	public Author updateAuthorDetails(Author author);
	public Author deleteAuthorDetails(int authorId);
	public List<Author> viewAuthorsList();
	public Author viewAuthorById(int id);

}
