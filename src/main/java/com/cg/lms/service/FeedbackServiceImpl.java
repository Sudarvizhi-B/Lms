package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.repository.IFeedbackRepository;
import com.cg.lms.repository.IUsersRepository;
import com.cg.lms.controller.ReaderController;
import com.cg.lms.entity.Feedback;
import com.cg.lms.entity.Reader;
import com.cg.lms.entity.Users;


@Service
public class FeedbackServiceImpl implements IFeedbackService{
	org.apache.logging.log4j.Logger logger= LogManager.getLogger(FeedbackServiceImpl.class);
	
	@Autowired
	IFeedbackRepository feedbackRepo;
	@Autowired
	IUsersRepository usersRepo;

	// Write Feedback
	@Override
	public Feedback writeFeedback(int userId,Feedback feedback) {
		logger.info("Write feedback");
		Optional<Users> users=usersRepo.findById(userId);
		if(!users.isPresent())
		{
			return null;
		}
		Users user=users.get();
		feedback.setUsers(user);
		return feedbackRepo.save(feedback);
	}

	// Update Feedback
	@Override
	public Feedback updateFeedback(Feedback feedback) {
		logger.info("Update feedback");
		Optional<Feedback> fb1=feedbackRepo.findById(feedback.getId());
			if(!fb1.isPresent()){
				return null;
			}
				
		Feedback feedbackUpdate=fb1.get();
		feedbackUpdate.setComments(feedback.getComments());
		feedbackUpdate.setDescription(feedback.getDescription());
		feedbackUpdate.setFeedbackDate(feedback.getFeedbackDate());
		feedbackUpdate.setRating(feedback.getRating());
		
		return feedbackRepo.save(feedbackUpdate);
	}

	// View Feedback list
	@Override
	public List<Feedback> viewFeedbackList() {
		logger.info("view feedback List");
		return feedbackRepo.findAll();
	}

	// View Feedback by userId
	@Override
	public Feedback viewFeedBackByUser(int userId) {
		logger.info("view feedback by userId");
		Feedback feedback=feedbackRepo.viewFeedBackByUser(userId);
		if(feedback==null){
			return null;
		}
		
		return feedbackRepo.viewFeedBackByUser(userId);
	}

	// View feedback by Id
	@Override
	public Feedback viewFeedbackById(int id) {
		logger.info("view feedback by Id");
		Optional<Feedback> feedback=feedbackRepo.findById(id);
		if(!feedback.isPresent()){
			return null;
		}
		
		return  feedback.get();
	}

	@Override
	public Feedback deleteFeedbackById(int id) {
		logger.info("get feedback by Id");
		Optional<Feedback> feedback=feedbackRepo.findById(id);
		if(!feedback.isPresent()){
			return null;
		}
		logger.info("Delete feedback by Id");
		feedbackRepo.deleteById(id);
		logger.info("return feedback");
		logger.info(feedback.get());
		return feedback.get();
	}

	@Override
	public List<Feedback> viewFeedbackByRating(String rating) {
		Optional<List<Feedback>> feedback=feedbackRepo.findByRating(rating);
		if(!feedback.isPresent()) {
			return null;
		}
		return feedback.get();
	}

}
