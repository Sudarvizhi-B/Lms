package com.cg.lms.service;

import java.util.List;
import com.cg.lms.entity.Feedback;


public interface IFeedbackService {
	
	//public Feedback writeFeedback(int userId, Feedback feedback);
	public Feedback viewFeedbackById(int id);
	public Feedback updateFeedback(Feedback feedback);
	public List<Feedback> viewFeedbackList();
	public Feedback viewFeedBackByUser(int userId);
	public Feedback deleteFeedbackById(int id);
	public List<Feedback> viewFeedbackByRating(String rating);
	public Feedback writeFeedbackByUser(Feedback feedback);
	
}
