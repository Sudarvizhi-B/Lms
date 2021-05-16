package com.cg.lms.service;

import java.util.List;


import com.cg.lms.entity.Publishers;

public interface IPublisherService {
	
	public Publishers addPublisher(Publishers publisher);
	public Publishers updatePublisherDetails(Publishers publisher);
	public Publishers removePublisher(int publisherId);
	public List<Publishers> viewPublishersList();
	public Publishers viewPublisherById(int id);

}
