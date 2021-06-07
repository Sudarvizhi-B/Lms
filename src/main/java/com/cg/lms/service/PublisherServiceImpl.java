package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.lms.entity.Publishers;
import com.cg.lms.repository.IPublisherRepository;

@Service
public class PublisherServiceImpl implements IPublisherService {

	@Autowired
	IPublisherRepository pRepo;
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PublisherServiceImpl.class);

	// Add Publisher Details
	@Override
	public Publishers addPublisher(Publishers publisher) {
		logger.info("Adding Publisher Details");
		return pRepo.save(publisher);
	}

	// Update Publisher Details
	@Override
	public Publishers updatePublisherDetails(Publishers publisher) {
		// Getting Publisher By Id
		Optional<Publishers> p1 = pRepo.findById(publisher.getPublisherId());
		if (!p1.isPresent()) {
			return null;
		}
		logger.info("Updating publisher Details");
		p1.get().setPublisherName(publisher.getPublisherName());
		p1.get().setContactno(publisher.getContactno());
		p1.get().setEmail(publisher.getEmail());
		p1.get().setAddress1(publisher.getAddress1());
		p1.get().setAddress2(publisher.getAddress2());
		p1.get().setCity(publisher.getCity());
		p1.get().setState(publisher.getState());
		p1.get().setPincode(publisher.getPincode());
		return pRepo.save(p1.get());
	}

	// Delete Publisher Details
	@Override
	public Publishers removePublisher(int publisherId) {
		// Getting Publisher By Id
		Optional<Publishers> p = pRepo.findById(publisherId);
		if (!p.isPresent()) {
			return null;
		}
		logger.info("Deleting Publisher Details");
		pRepo.deleteById(publisherId);
		return p.get();
	}

	// List All Publishers
	@Override
	public List<Publishers> viewPublishersList() {
		logger.info("Viewing Publisher Details");
		return pRepo.findAll();
	}

	// View Publisher By Id
	@Override
	public Publishers viewPublisherById(int id) {
		Optional<Publishers> p3 = pRepo.findById(id);
		if (!p3.isPresent()) {
			return null;
		}
		logger.info("Viewing Publisher Details By Id");
		return p3.get();
	}

}
