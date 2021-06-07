package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.BooksIssued;

public interface IBooksIssuedService {
    
	//Method to be override by the implementing class
    BooksIssued findById(int id);
    
	//Method to be override by the implementing class
    List<BooksIssued>findAll();
    
	//Method to be override by the implementing class
    BooksIssued deleteById(int id);
    
	//Method to be override by the implementing class
    BooksIssued update(BooksIssued issued);
    
	//Method to be override by the implementing class
    BooksIssued save(BooksIssued issued);
    
	//Method to be override by the implementing class
    BooksIssued addBook(BooksIssued issued);
	
}
