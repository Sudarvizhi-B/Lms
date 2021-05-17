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
	
	//Write Feedback by user
	@PostMapping("/feedback/{userId}")
	public ResponseEntity<Feedback> writeFeedback(@PathVariable("userId")int userId,@RequestBody Feedback feedback){
		if(feedbackService.writeFeedback(userId, feedback)==null)
		{
			throw new UserNotFoundException("user not found with the id: "+userId);
		}
		Feedback feed= feedbackService.writeFeedback(userId, feedback);
		return new ResponseEntity<>(feed, HttpStatus.OK);
	}
	
	// Update feedback
	@PutMapping("/feedback/{id}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable("id")int id, @RequestBody Feedback feedback){
		if( feedbackService.updateFeedback(feedback)==null){
			throw new FeedbackNotFoundException("feedback not found with id: "+id);
		}
		Feedback updatedFeedback=feedbackService.updateFeedback(feedback);
		return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
	}
	// view all feedback
	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> viewAllFeedback(Feedback feedback){
		List<Feedback> feedbackList=feedbackService.viewFeedbackList();
		return new ResponseEntity<>(feedbackList, HttpStatus.OK);
	}
	
	// View feedback by user
	@GetMapping("/feedback/user/{userId}")
	public ResponseEntity<Feedback> viewFeedbackByUser(@PathVariable("userId") int userId){
		if(feedbackService.viewFeedBackByUser(userId)==null){
			throw new UserNotFoundException("user not found with id: "+userId);
		}
		Feedback feedback=feedbackService.viewFeedBackByUser(userId);
		return new ResponseEntity<>(feedback, HttpStatus.OK);
	}
	
	// view Feedback by id
	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> viewFeedbackById(@PathVariable("id") int id)
	{
		if(feedbackService.viewFeedbackById(id)==null){
			throw new FeedbackNotFoundException("feedback not found with id: "+id);
		}
		Feedback feedback=feedbackService.viewFeedbackById(id);
		return new ResponseEntity<>(feedback,HttpStatus.OK);
	}
	

		
}
