package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.DamagedBooks;
import com.cg.lms.repository.IDamagedBooksDao;

@Service
public class DamagedBooksServiceImpl implements IDamagedBooksService {
	
	@Autowired
	IDamagedBooksDao damagedBooksDao;

	@Override
	public DamagedBooks addDamagedBooks(DamagedBooks book) {
		return damagedBooksDao.save(book);
	}

	@Override
	public DamagedBooks updateDamagedBookDetails(DamagedBooks damagedbooks) {
		Optional<DamagedBooks> opt = damagedBooksDao.findById(damagedbooks.getId());
		if(!opt.isPresent()) {
			return null;
		}
		
		DamagedBooks booksDamaged = opt.get();
		booksDamaged.setId(damagedbooks.getId());
		booksDamaged.setQuantity(damagedbooks.getQuantity());
		booksDamaged.setDescription(damagedbooks.getDescription());
		booksDamaged.setBooks(damagedbooks.getBooks());
		
		return booksDamaged;
	}

	@Override
	public List<DamagedBooks> viewDamagedBooksList() {
		return damagedBooksDao.findAll();
	}

	@Override
	public DamagedBooks viewDamagedBookById(int id) {
		Optional<DamagedBooks> booksDamaged = damagedBooksDao.findById(id);
		if(!booksDamaged.isPresent()) {
			return null;
		}
		
		return booksDamaged.get();
	}

}
