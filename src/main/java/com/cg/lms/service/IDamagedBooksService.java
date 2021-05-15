package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.DamagedBooks;

public interface IDamagedBooksService {
	
	public DamagedBooks addDamagedBooks(DamagedBooks bookid);
	public DamagedBooks updateDamagedBookDetails(DamagedBooks damagedbooks);
	public List<DamagedBooks> viewDamagedBooksList();
	public DamagedBooks viewDamagedBookById(int id);

}
