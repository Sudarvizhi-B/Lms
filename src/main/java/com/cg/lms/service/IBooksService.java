package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Books;

public interface IBooksService {
	
	public Books addBook(Books book);
	public Books updateBookDetails(Books book);
	public Books removeBook(int bookid);
	public Books save(Books book);
	public Books viewBookById(int bookid);
	public List<Books> viewAllBooks();
	public List<Books> findAllByTitle(String title);
	public List<Books> findAllBySubject(String subject);
	
}
