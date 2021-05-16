
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

	@Override
	public BooksIssued findById(int id) {
		BooksIssued issued = issuedRepo.findById(id).get();
		return issued;
	}

	@Override
	public List<BooksIssued> findAll() {
		return issuedRepo.findAll();
	}

	@Override
	public BooksIssued deleteById(int id) {
		BooksIssued issued = issuedRepo.findById(id).get();
		
		issuedRepo.deleteById(id);
		return issued;
	}

	@Override
	public BooksIssued update(BooksIssued issued) {
		BooksIssued issued1 = issuedRepo.findById(issued.getIssueId()).get();
		issued1.setQuantity(issued.getQuantity());
		issued1.setDueDate(issued.getDueDate());
		issued1.setIssueDate(issued.getIssueDate());
		
		issuedRepo.save(issued1);
		return issued1;
	}

	@Override
	public BooksIssued addBook(BooksIssued issued) {
		return issuedRepo.save(issued);
	}

	@Override
	public BooksIssued save(BooksIssued issued) {
		return issuedRepo.save(issued);
	}

}
