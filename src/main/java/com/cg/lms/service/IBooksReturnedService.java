package com.cg.lms.service;

import java.util.List;
import com.cg.lms.entity.BooksReturned;

public interface IBooksReturnedService {
	
	public BooksReturned returnBooks(BooksReturned returned);
	public BooksReturned updateReturnedBookDetails( int id,BooksReturned booksReturned );
	public List<BooksReturned> viewReturnedBooksList();
	public List<BooksReturned> findByDelayedDaysGreaterThanEqual(int delayedDays);
	public BooksReturned deleteReturnedBooks(int id);
	public BooksReturned viewById(int id);

	
}
