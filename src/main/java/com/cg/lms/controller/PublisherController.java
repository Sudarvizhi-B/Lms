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
import com.cg.lms.entity.Publishers;
import com.cg.lms.exception.PublisherNotFoundException;
import com.cg.lms.service.IPublisherService;

@CrossOrigin
@RestController
public class PublisherController {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PublisherController.class);

	@Autowired
	IPublisherService pService;

	private static final String EXCEPTION = "Publisher not found with Book id ";

	// READ
	@GetMapping("/publisher/id/{id}")
	public ResponseEntity<Publishers> viewPublisherById(@PathVariable("id") int publisherId) {
		logger.info("Viewing Publisher By Id");
		// Throw an exception if publisher id is not present
		if (pService.viewPublisherById(publisherId) == null) {
			throw new PublisherNotFoundException(EXCEPTION + publisherId);
		}
		return new ResponseEntity<>(pService.viewPublisherById(publisherId), HttpStatus.OK);
	}

	@GetMapping("/publisher")
	public ResponseEntity<List<Publishers>> viewPublishersList() {
		logger.info("Viewing All Publishers");
		return new ResponseEntity<>(pService.viewPublishersList(), HttpStatus.OK);
	}

	// WRITE
	@PostMapping("/publisher")
	public ResponseEntity<Publishers> addPublishers(@RequestBody Publishers p) {
		logger.info("Adding Publisher Details");
		return new ResponseEntity<>(pService.addPublisher(p), HttpStatus.CREATED);
	}

	// UPDATE
	@PutMapping("/publisher")
	public ResponseEntity<Publishers> updatePublisherDetails(@RequestBody Publishers publisher) {
		logger.info("Updating Publisher Details");
		// Throw an exception if publisher id is not present
		if (pService.updatePublisherDetails(publisher) == null) {
			throw new PublisherNotFoundException(EXCEPTION + publisher);
		}
		return new ResponseEntity<>(pService.updatePublisherDetails(publisher), HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/publisher/{id}")
	public ResponseEntity<Publishers> removePublisher(@PathVariable("id") int publisherId) {
		logger.info("Deleting Publisher Details");
		// Throw an exception if publisher id is not present
		if (pService.removePublisher(publisherId) == null) {
			throw new PublisherNotFoundException(EXCEPTION + publisherId);
		}
		return new ResponseEntity<>(pService.removePublisher(publisherId), HttpStatus.OK);

	}

}
