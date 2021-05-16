package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.repository.IReaderRepository;
import com.cg.lms.entity.Reader;


@Service
public class ReaderServiceImpl implements IReaderService {

	@Autowired
	IReaderRepository readerRepo;
	
	@Override
	public Reader register(Reader reader) {
		return readerRepo.save(reader);
	}

	@Override
	public Reader updateReaderDetails(Reader reader) {
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

	@Override
	public Reader deleteReader(int id) {
		Optional<Reader> reader=readerRepo.findById(id);
		if(!reader.isPresent()){
			return null;
		}
		
		readerRepo.deleteById(id);
		return reader.get();
	}

	@Override
	public List<Reader> viewReadersList() {
		return readerRepo.findAll();
	}

	@Override
	public Reader viewReaderById(int id) {
		Optional<Reader> reader=readerRepo.findById(id);
		if(!reader.isPresent()){
			return null;
		}
		
		return reader.get();
	}

}
