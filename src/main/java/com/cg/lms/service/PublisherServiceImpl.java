package com.cg.lms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.lms.entity.Publishers;
import com.cg.lms.repository.IPublisherRepository;

@Service
public class PublisherServiceImpl implements IPublisherService {

	@Autowired
	IPublisherRepository pRepo;

	// Add Publisher Details
	@Override
	public Publishers addPublisher(Publishers publisher) {
		return pRepo.save(publisher);
	}

	// Update Publisher Details
	@Override
	public Publishers updatePublisherDetails(Publishers publisher) {
		Optional<Publishers> p1 = pRepo.findById(publisher.getPublisherId());
		if (!p1.isPresent()) {
			return null;
		}
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
		Optional<Publishers> p = pRepo.findById(publisherId);
		if (!p.isPresent()) {
			return null;
		}

		pRepo.deleteById(publisherId);
		return p.get();
	}

	// List All Publishers
	@Override
	public List<Publishers> viewPublishersList() {
		return pRepo.findAll();
	}

	// View Publisher By Id
	@Override
	public Publishers viewPublisherById(int id) {
		Optional<Publishers> p3 = pRepo.findById(id);
		if (!p3.isPresent()) {
			return null;
		}

		return p3.get();
	}

}
