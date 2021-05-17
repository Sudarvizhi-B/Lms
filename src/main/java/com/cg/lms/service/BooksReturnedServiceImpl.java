package com.cg.lms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.lms.repository.IBooksReturnedRepository;
import com.cg.lms.entity.BooksReturned;

@Service
public class BooksReturnedServiceImpl implements IBooksReturnedService{

	@Autowired
	IBooksReturnedRepository brd;
	
	@Override
	public BooksReturned returnBooks(BooksReturned returned) {
		return brd.save(returned);
	} 

	@Override
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) {
		Optional <BooksReturned> b1 = brd.findById(booksReturned.getId());
		if(!b1.isPresent()) {
			return null;
		}
	
		b1.get().setReturnedDate(booksReturned.getReturnedDate());
		b1.get().setDelayedDays(booksReturned.getDelayedDays());
		b1.get().setPenalty(booksReturned.getPenalty());
		b1.get().setPenalty_Status(booksReturned.getPenalty_Status());
		
		return brd.save(b1.get());
	}

	@Override
	public List<BooksReturned> viewReturnedBooksList() {
		
		return brd.findAll();
	}
	
	@Transactional
	public List<BooksReturned> findByDelayedDaysGreaterThanEqual(int delayedDays) {
		List <BooksReturned> returned = (List <BooksReturned>)brd.findByDelayedDaysGreaterThanEqual(delayedDays);
		return returned;
	}
}
