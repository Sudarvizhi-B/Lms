package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.Feedback;
import com.cg.lms.exception.FeedbackNotFoundException;
import com.cg.lms.exception.UserNotFoundException;
import com.cg.lms.service.IFeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	IFeedbackService feedbackService;
	
	//READ
	@GetMapping("/feedback")
	public List<Feedback> viewAllFeedback(Feedback feedback){
		return feedbackService.viewFeedbackList();
	}
	
	@GetMapping("/feedback/user/{userId}")
	public Feedback viewFeedbackByUser(@PathVariable("userId") int userId){
		if(feedbackService.viewFeedBackByUser(userId)==null){
			throw new UserNotFoundException("user not found with id: "+userId);
		}
		return feedbackService.viewFeedBackByUser(userId);
	}
	
	@GetMapping("/feedback/{id}")
	public Feedback viewFeedbackById(@PathVariable("id") int id)
	{
		if(feedbackService.viewFeedbackById(id)==null){
			throw new FeedbackNotFoundException("feedback not found with id: "+id);
		}
		return feedbackService.viewFeedbackById(id);
	}
	
	//WRITE
	@PostMapping("/feedback/{userId}")
	public ResponseEntity<Feedback> writeFeedback(@PathVariable("userId")int userId,@RequestBody Feedback feedback){
		if(feedbackService.writeFeedback(userId, feedback)==null)
		{
			throw new UserNotFoundException("user not found with the id: "+userId);
		}
		Feedback feed= feedbackService.writeFeedback(userId, feedback);
		return new ResponseEntity<>(feed, HttpStatus.OK);
	}
	
	//UPDATE
	@PutMapping("/feedback/{id}")
	public Feedback updateFeedback(@PathVariable("id")int id, @RequestBody Feedback feedback){
		if( feedbackService.updateFeedback(feedback)==null){
			throw new FeedbackNotFoundException("feedback not found with id: "+id);
		}
		return feedbackService.updateFeedback(feedback);
	}
		
}
