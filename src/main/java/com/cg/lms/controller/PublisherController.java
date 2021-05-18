package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
public class PublisherController {

	@Autowired
	IPublisherService pService;

	// READ
	@GetMapping("/publisher/id/{id}")
	public ResponseEntity<Publishers> viewPublisherById(@PathVariable("id") int publisherId){
		if (pService.viewPublisherById(publisherId) == null) {
			throw new PublisherNotFoundException("Publisher Not Found with id: " + publisherId);
		}
		return new ResponseEntity<>(pService.viewPublisherById(publisherId), HttpStatus.OK);
	}

	@GetMapping("/publisher")
	public ResponseEntity<List<Publishers>> viewPublishersList() {
		return new ResponseEntity<>(pService.viewPublishersList(), HttpStatus.OK);
	}

	// WRITE
	@PostMapping("/publisher")
	public ResponseEntity<Publishers> addPublishers(@RequestBody Publishers p) {
		return new ResponseEntity<>(pService.addPublisher(p), HttpStatus.CREATED);
	}

	// UPDATE
	@PutMapping("/publisher")
	public ResponseEntity<Publishers> updatePublisherDetails(@RequestBody Publishers publisher){
		if (pService.updatePublisherDetails(publisher) == null) {
			throw new PublisherNotFoundException("Publisher Not Found: " + publisher);
		}
		return new ResponseEntity<>(pService.updatePublisherDetails(publisher), HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/publisher/{id}")
	public ResponseEntity<Publishers> removePublisher(@PathVariable("id") int publisherId){
		if (pService.removePublisher(publisherId) == null) {
			throw new PublisherNotFoundException("Publisher Not Found with id: " + publisherId);
		}
		return new ResponseEntity<>(pService.removePublisher(publisherId), HttpStatus.OK);

	}

}
