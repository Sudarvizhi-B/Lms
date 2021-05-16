package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.BooksIssued;

public interface IBooksIssuedService {

	BooksIssued findById(int id);
	List<BooksIssued>findAll();
	BooksIssued deleteById(int id);
	BooksIssued update(BooksIssued issued);
	BooksIssued save(BooksIssued issued);
	BooksIssued addBook(BooksIssued issued);
	
}
