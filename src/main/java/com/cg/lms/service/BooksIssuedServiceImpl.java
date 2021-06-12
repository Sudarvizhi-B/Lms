
package com.cg.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.BooksIssued;
import com.cg.lms.repository.IBooksIssuedRepository;

@Service
public class BooksIssuedServiceImpl implements IBooksIssuedService {

	@Autowired
	IBooksIssuedRepository issuedRepo;
   
	//Used to find booksIsuued bu id
	@Override
	public BooksIssued findById(int id) {
		BooksIssued issued = issuedRepo.findById(id).get();
		return issued;
	}
    
	//used to get all the list from the database
	@Override
	public List<BooksIssued> findAll() {
		return issuedRepo.findAll();
	}
    
	//Used to delete booksIssuued by id
	@Override
	public BooksIssued deleteById(int id) {
		BooksIssued issued = issuedRepo.findById(id).get();
		
		issuedRepo.deleteById(id);
		return issued;
	}
    
	//Used to update the booksIssued
	@Override
	public BooksIssued update(BooksIssued issued) {
		BooksIssued issued1 = issuedRepo.findById(issued.getIssueId()).get();
		issued1.setIssueId(issued.getIssueId());
		issued1.setQuantity(issued.getQuantity());
		issued1.setDueDate(issued.getDueDate());
		issued1.setIssueDate(issued.getIssueDate());
		
		issuedRepo.save(issued1);
		return issued1;
	}
    
	//Used to add booksIssued into database
	@Override
	public BooksIssued addBook(BooksIssued issued) {
		return issuedRepo.save(issued);
	}
    
	//Used to add 
	@Override
	public BooksIssued save(BooksIssued issued) {
		return issuedRepo.save(issued);
	}

}
