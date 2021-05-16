package com.cg.lms.service;

import java.util.List;
import com.cg.lms.entity.BooksReturned;

public interface BooksReturnedService {
	public BooksReturned returnBooks(BooksReturned returned);
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned);
	public List<BooksReturned> viewReturnedBooksList();
	//public List<BooksReturned> viewDelayedBooksList();
	public List<BooksReturned> findByDelayedDaysGreaterThanEqual(int delayedDays);
}
