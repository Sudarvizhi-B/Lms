package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.lms.repository.IBooksReturnedRepository;
import com.cg.lms.entity.Author;
import com.cg.lms.entity.BooksReturned;

@Service
public class BooksReturnedServiceImpl implements IBooksReturnedService {

	@Autowired
	IBooksReturnedRepository booksReturnedRepo;
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BooksReturnedServiceImpl.class);

	// Add Returned Books
	@Override
	public BooksReturned returnBooks(BooksReturned returned) {
		//logger information to be displayed in console
		logger.info(returned);
		return booksReturnedRepo.save(returned);
	}

	// Update Details of ReturnedBooks
	@Override
	public BooksReturned updateReturnedBookDetails(int id,BooksReturned booksReturned ) {
		Optional<BooksReturned> b1 = booksReturnedRepo.findById(booksReturned.getId());
		if (!b1.isPresent()) {
			return null;
		}
		BooksReturned br = b1.get(); 
		br.setReturnedDate(booksReturned.getReturnedDate());
		br.setDelayedDays(booksReturned.getDelayedDays());
		br.setPenalty(booksReturned.getPenalty());
		br.setPenalty_Status(booksReturned.getPenalty_Status());
		//logger information to be displayed in console
		logger.info(b1);

		return booksReturnedRepo.save(b1.get());
	}

	// View ReturnedBooks List
	@Override
	public List<BooksReturned> viewReturnedBooksList() {
		//logger information to be displayed in console
		logger.info("viewing ReturnedBooks list");
		return booksReturnedRepo.findAll();
	}

	// Find by Delayed Days
	@Transactional
	public List<BooksReturned> findByDelayedDaysGreaterThanEqual(int delayedDays) {
		//logger information to be displayed in console
		logger.info("viewing ReturnedBooks list with delayed days greater than or equal to the parameter passed");
		List<BooksReturned> returned = (List<BooksReturned>) booksReturnedRepo
				.findByDelayedDaysGreaterThanEqual(delayedDays);
		return returned;
	}

	@Override
	public BooksReturned deleteReturnedBooks(int id) {
			//method to delete ReturnedBook details
			Optional<BooksReturned> b2 = booksReturnedRepo.findById(id);
			if (!b2.isPresent()) {
				return null;
			}
			booksReturnedRepo.deleteById(id);
			//logger information to be displayed in console
			logger.info(b2);
			return b2.get();
		}

	// View ReturnedBook By Id
	@Override
	public BooksReturned viewById(int id) {
			//method to get ReturnedBook ById
			Optional<BooksReturned> b3 = booksReturnedRepo.findById(id);
			if (!b3.isPresent()) {
				return null;
			}
			//logger information to be displayed in console
			logger.info(b3);
			return b3.get();

		}



	}
	

