package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.Books;
import com.cg.lms.repository.IBooksDao;

@Service
public class BooksServiceImpl implements IBooksService {
	
	@Autowired
	IBooksDao booksDao;

	@Override
	public Books addBook(Books book) {
		return booksDao.save(book);
	}

	@Override
	public Books updateBookDetails(Books book) {
		Optional<Books> opt = booksDao.findById(book.getBookid());
		if(!opt.isPresent()) {
			return null;
		}
		
		Books books = booksDao.findById(book.getBookid()).get();
		books.setAuthor(books.getAuthor());
		books.setBookCost(book.getBookCost());
		books.setIsbnCode(book.getIsbnCode());
		books.setPublishedYear(book.getPublishedYear());
		books.setQuantity(book.getQuantity());
		books.setShelfDetails(book.getShelfDetails());
		books.setSubject(book.getSubject());
		books.setTitle(book.getTitle());
		
		return booksDao.save(books);
	}

	@Override
	public Books removeBook(int bookid) {
		Optional<Books> book = booksDao.findById(bookid);
		if(!book.isPresent()) {
			return null;
		}
		
		booksDao.deleteById(bookid);
		return book.get();
	}
	
	@Override
	public Books save(Books book) {
		return booksDao.save(book);
	}

	@Override
	public Books viewBookById(int bookid) {
		Optional<Books> book = booksDao.findById(bookid);
		if(!book.isPresent()) {
			return null;
		}
		
		return book.get();
	}
	
	@Override
	public List<Books> viewAllBooks() {
		return booksDao.findAll();
	}

	@Override
	public List<Books> findAllByTitle(String title) {
		List<Books> books = booksDao.findAllByTitle(title);
		if(books.isEmpty()) {
			return null;
		}
		
		return booksDao.findAllByTitle(title);
	}

	@Override
	public List<Books> findAllBySubject(String subject) {
		List<Books> books = booksDao.findAllBySubject(subject);
		if(books.isEmpty()) {
			return null;
		}
		
		return booksDao.findAllBySubject(subject);
	}

}
