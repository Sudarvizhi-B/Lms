package com.cg.lms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Reader;
import com.cg.lms.exception.ReaderNotFoundException;
import com.cg.lms.service.IReaderService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ReaderController {
	org.apache.logging.log4j.Logger logger= LogManager.getLogger(ReaderController.class);
	
	@Autowired
	IReaderService readerService;
	
	private static final String EXCEPTION="Reader not found with the id ";
	// Register reader
	@PostMapping("/reader")
	public ResponseEntity<Reader> registerReader(@RequestBody Reader reader) {
		logger.info("Register reader");
		Reader registeredReader=readerService.register(reader);
		return new ResponseEntity<>(registeredReader, HttpStatus.OK);
	}

	// Update reader details
	@PutMapping("/reader/{id}")
	public ResponseEntity<Reader> updateReaderdetail(@PathVariable("id") int id, @RequestBody Reader reader) {
		logger.info("Update reader details");
		if (readerService.updateReaderDetails(reader) == null) {
			throw new ReaderNotFoundException(EXCEPTION + id);
		}
		 Reader updatedReader=readerService.updateReaderDetails(reader);
		return new ResponseEntity<>(updatedReader, HttpStatus.OK);
	}

	// View all the readers
	@GetMapping("/reader")
	public ResponseEntity<List<Reader>> viewReaderList(Reader reader) {
		logger.info("view all readers");
		List<Reader> readerList=readerService.viewReadersList();
		return new ResponseEntity<>(readerList, HttpStatus.OK);
	}
	
	// View reader by id
	@GetMapping("/reader/get/{id}")
	public ResponseEntity<Reader> viewReaderById(@PathVariable("id") int id) {
		logger.info("view reader by Id");
		if (readerService.viewReaderById(id) == null) {
			throw new ReaderNotFoundException(EXCEPTION + id);
		}
		 Reader reader=readerService.viewReaderById(id);
		return new ResponseEntity<>(reader, HttpStatus.OK);
	}

	// Delete reader by id
	@DeleteMapping("/reader/{id}")
	public ResponseEntity<Reader> deleteReader(@PathVariable("id") int id) {
		logger.info("delete reader by Id");
		if (readerService.deleteReader(id) == null) {
			throw new ReaderNotFoundException(EXCEPTION + id);
		}
		Reader reader=readerService.deleteReader(id);
		return new ResponseEntity<>(reader, HttpStatus.OK);
	}

}
