package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.repository.IReaderRepository;
import com.cg.lms.controller.ReaderController;
import com.cg.lms.entity.Reader;


@Service
public class ReaderServiceImpl implements IReaderService {
	org.apache.logging.log4j.Logger logger= LogManager.getLogger(ReaderServiceImpl.class);

	@Autowired
	IReaderRepository readerRepo;
	
	// Register reader
	@Override
	public Reader register(Reader reader) {
		logger.info("register reader");
		return readerRepo.save(reader);
	}

	// Update reader details
	@Override
	public Reader updateReaderDetails(Reader reader) {
		logger.info("update reader details");
		Optional<Reader> rd1=readerRepo.findById(reader.getId());
		if(!rd1.isPresent()){
			return null;
		}
		
		Reader readerUpdate=rd1.get();
		readerUpdate.setId(reader.getId());
		readerUpdate.setFirstName(reader.getFirstName());
		readerUpdate.setLastName(reader.getLastName());
		readerUpdate.setMobileNo(reader.getMobileNo());
		readerUpdate.setEmail(reader.getEmail());
		readerUpdate.setPassword(reader.getPassword());
		return readerRepo.save(readerUpdate);
		
	}

	// Delete reader by id
	@Override
	public Reader deleteReader(int id) {
		logger.info("get reader by Id");
		Optional<Reader> reader=readerRepo.findById(id);
		if(!reader.isPresent()){
			return null;
		}
		logger.info("Delete reader by Id");
		readerRepo.deleteById(id);
		logger.info("return reader");
		logger.info(reader.get());
		return reader.get();
	}

	// View reader list
	@Override
	public List<Reader> viewReadersList() {
		logger.info("view reader list");
		return readerRepo.findAll();
	}

	// View reader by id
	@Override
	public Reader viewReaderById(int id) {
		logger.info("view reader by Id");
		Optional<Reader> reader=readerRepo.findById(id);
		if(!reader.isPresent()){
			return null;
		}
		
		return reader.get();
	}

	@Override
	public List<Reader> viewReaderByFirstName(String firstName) {
		Optional<List<Reader>> readerList=readerRepo.findByfirstNameEquals(firstName);
		if(!readerList.isPresent()) {
			return null;
		}
		return readerList.get();
	}

}
