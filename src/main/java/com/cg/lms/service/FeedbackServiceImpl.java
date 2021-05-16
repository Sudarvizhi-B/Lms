package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.repository.IFeedbackRepository;
import com.cg.lms.repository.IUsersRepository;
import com.cg.lms.entity.Feedback;
import com.cg.lms.entity.Users;


@Service
public class FeedbackServiceImpl implements IFeedbackService{
	
	@Autowired
	IFeedbackRepository feedbackRepo;
	@Autowired
	IUsersRepository usersRepo;

	@Override
	public Feedback writeFeedback(int userId,Feedback feedback) {
		Optional<Users> users=usersRepo.findById(userId);
		if(!users.isPresent())
		{
			return null;
		}
		Users user=users.get();
		feedback.setUsers(user);
		return feedbackRepo.save(feedback);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
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

	@Override
	public List<Feedback> viewFeedbackList() {
		return feedbackRepo.findAll();
	}

	@Override
	public Feedback viewFeedBackByUser(int userId) {
		Feedback feedback=feedbackRepo.viewFeedBackByUser(userId);
		if(feedback==null){
			return null;
		}
		
		return feedbackRepo.viewFeedBackByUser(userId);
	}

	@Override
	public Feedback viewFeedbackById(int id) {
		Optional<Feedback> feedback=feedbackRepo.findById(id);
		if(!feedback.isPresent()){
			return null;
		}
		
		return feedback.get();
	}

}
