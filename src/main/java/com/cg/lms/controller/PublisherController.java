package com.cg.lms.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
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

	//READ
	@GetMapping("/publisher/id/{id}")
	public Publishers viewPublisherById(@PathVariable("id") int publisherId)  {
		if (pService.viewPublisherById(publisherId)==null) {
			throw new PublisherNotFoundException("Publisher Not Found with id: " + publisherId);
		}
		return pService.viewPublisherById(publisherId);
	}
	
	@GetMapping("/publisher")
	public List<Publishers> viewPublishersList() {
		return pService.viewPublishersList();
	}

	//WRITE
	@PostMapping("/publisher")
	public Publishers addPublishers(@RequestBody Publishers p) {
		return pService.addPublisher(p);
	}

	//UPDATE
	@PutMapping("/publisher")
	public Publishers updatePublisherDetails(@RequestBody Publishers publisher) {
		if (pService.updatePublisherDetails(publisher) == null) {
			throw new PublisherNotFoundException("Publisher Not Found: " + publisher);
		}
		return pService.updatePublisherDetails(publisher);
	}
	
	//DELETE
	@DeleteMapping("/publisher/{id}")
	public Publishers removePublisher(@PathVariable("id") int publisherId) {
		if (pService.removePublisher(publisherId)==null) {
			throw new PublisherNotFoundException("Publisher Not Found with id: " + publisherId);
		}
		return pService.removePublisher(publisherId);

	}

}
