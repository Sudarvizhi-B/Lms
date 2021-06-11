package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.DamagedBooks;
import com.cg.lms.repository.IDamagedBooksDao;

@Service
public class DamagedBooksServiceImpl implements IDamagedBooksService {
	
	@Autowired
	IDamagedBooksDao damagedBooksDao;
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DamagedBooksServiceImpl.class);

	//Method to add damaged book
	@Override
	public DamagedBooks addDamagedBooks(DamagedBooks book) {
		logger.info(book);
		return damagedBooksDao.save(book);
	}

	//Method to update values of damaged book
	@Override
	public DamagedBooks updateDamagedBookDetails(DamagedBooks damagedBooks) {
		//Getting book by id
		Optional<DamagedBooks> opt = damagedBooksDao.findById(damagedBooks.getId());
		if(!opt.isPresent()) {
			return null;
		}
		
		//Updating values
		DamagedBooks booksDamaged = opt.get();
		booksDamaged.setQuantity(damagedBooks.getQuantity());
		booksDamaged.setDescription(damagedBooks.getDescription());
		booksDamaged.setBooks(damagedBooks.getBooks());
		
		damagedBooksDao.save(booksDamaged);
		logger.info(booksDamaged);
		return booksDamaged;
	}

	//Method to get list of damaged books from the table
	@Override
	public List<DamagedBooks> viewDamagedBooksList() {
		return damagedBooksDao.findAll();
	}

	//method to get damaged book by id
	@Override
	public DamagedBooks viewDamagedBookById(int id) {
		//Getting book by id
		Optional<DamagedBooks> booksDamaged = damagedBooksDao.findById(id);
		if(!booksDamaged.isPresent()) {
			return null;
		}
		
		logger.info(booksDamaged);
		return booksDamaged.get();
	}

	//Method to delete damaged book 
	@Override
	public DamagedBooks deleteDamagedBook(int id) {
		//Getting book by id
		Optional<DamagedBooks> booksDamaged = damagedBooksDao.findById(id);
		if(!booksDamaged.isPresent()) {
			return null;
		}
		
		damagedBooksDao.deleteById(id);
		logger.info(booksDamaged);
		return booksDamaged.get();
	}

}
