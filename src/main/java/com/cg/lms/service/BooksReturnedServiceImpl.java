package com.cg.lms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.lms.repository.IBooksReturnedRepository;
import com.cg.lms.entity.BooksReturned;

@Service
public class BooksReturnedServiceImpl implements IBooksReturnedService {

	@Autowired
	IBooksReturnedRepository booksReturnedRepo;

	// Add Returned Books
	@Override
	public BooksReturned returnBooks(BooksReturned returned) {
		return booksReturnedRepo.save(returned);
	}

	// Update Details of ReturnedBooks
	@Override
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) {
		Optional<BooksReturned> b1 = booksReturnedRepo.findById(booksReturned.getId());
		if (!b1.isPresent()) {
			return null;
		}

		b1.get().setReturnedDate(booksReturned.getReturnedDate());
		b1.get().setDelayedDays(booksReturned.getDelayedDays());
		b1.get().setPenalty(booksReturned.getPenalty());
		b1.get().setPenalty_Status(booksReturned.getPenalty_Status());

		return booksReturnedRepo.save(b1.get());
	}

	// View ReturnedBooks List
	@Override
	public List<BooksReturned> viewReturnedBooksList() {

		return booksReturnedRepo.findAll();
	}

	// Find by Delayed Days
	@Transactional
	public List<BooksReturned> findByDelayedDaysGreaterThanEqual(int delayedDays) {
		List<BooksReturned> returned = (List<BooksReturned>) booksReturnedRepo
				.findByDelayedDaysGreaterThanEqual(delayedDays);
		return returned;
	}
}
