package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Books;
import com.cg.lms.repository.IBooksDao;

@Service
public class BooksServiceImpl implements IBooksService {
	
	@Autowired
	IBooksDao booksDao;
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BooksServiceImpl.class);

	//Method to add book in the table
	@Override
	public Books addBook(Books book) {
		logger.info(book);
		return booksDao.save(book);
	}

	//Method to update book
	@Override
	public Books updateBookDetails(Books book) {
		//Getting Book by id
		Optional<Books> opt = booksDao.findById(book.getBookId());
		if(!opt.isPresent()) {
			return null;
		}
		
		//Updating Book values
		Books books = opt.get();
		books.setAuthor(books.getAuthor());
		books.setBookCost(book.getBookCost());
		books.setIsbnCode(book.getIsbnCode());
		books.setPublishedYear(book.getPublishedYear());
		books.setQuantity(book.getQuantity());
		books.setShelfDetails(book.getShelfDetails());
		books.setSubject(book.getSubject());
		books.setTitle(book.getTitle());
		
		logger.info(books);
		return booksDao.save(books);
	}

	//Method to delete book from the table
	@Override
	public Books removeBook(int bookId) {
		//Getting book by id
		Optional<Books> book = booksDao.findById(bookId);
		if(!book.isPresent()) {
			return null;
		}
		
		//Deleting book
		booksDao.deleteById(bookId);
		logger.info(book);
		return book.get();
	}
	
	//Method to save values
	@Override
	public Books save(Books book) {
		return booksDao.save(book);
	}

	//Method to get book by id
	@Override
	public Books viewBookById(int bookId) {
		//Getting book by id
		Optional<Books> book = booksDao.findById(bookId);
		if(!book.isPresent()) {
			return null;
		}
		
		//returning book
		logger.info(book);
		return book.get();
	}
	
	//Method to get all book from the table
	@Override
	public List<Books> viewAllBooks() {
		return booksDao.findAll();
	}

	//Method to get books by title
	@Override
	public List<Books> findAllByTitle(String title) {
		//Getting list of books from the table by title
		List<Books> books = booksDao.findAllByTitleContainingIgnoreCase(title);
		if(books.isEmpty()) {
			return null;
		}
		
		logger.info(books);
		return booksDao.findAllByTitleContainingIgnoreCase(title);
	}

	//Method to get books by subject
	@Override
	public List<Books> findAllBySubject(String subject) {
		//getting list of books from the table by subject
		List<Books> books = booksDao.findAllBySubjectContainingIgnoreCase(subject);
		if(books.isEmpty()) {
			return null;
		}
		
		logger.info(books);
		return booksDao.findAllBySubjectContainingIgnoreCase(subject);
	}

}
