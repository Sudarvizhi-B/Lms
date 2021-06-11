package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.Reader;

public interface IReaderService {
	
	public Reader register(Reader reader);
	public Reader updateReaderDetails(Reader reader);
	public Reader deleteReader(int id) ;
	public List<Reader> viewReadersList();
	public Reader viewReaderById(int id);
	public List<Reader> viewReaderByFirstName(String firstName);
	
}
