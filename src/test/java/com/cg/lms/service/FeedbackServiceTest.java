package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.lms.entity.Feedback;
import com.cg.lms.entity.Users;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class FeedbackServiceTest {
	org.apache.logging.log4j.Logger logger= LogManager.getLogger(FeedbackServiceTest.class);
	

	@Autowired
	IFeedbackService feedbackService;
	
	
	@Test
	void writeFeedbackByUser() {
		Date date = Date.valueOf("2021-02-24");
		Feedback feedback = new Feedback(date, "Fiction", "9", "good", "100");
		Feedback fb=feedbackService.writeFeedbackByUser(feedback);
		logger.info(fb);
		
		assertEquals("good", fb.getComments());
		assertEquals("9", fb.getRating());
	}
	
	// update feedback
	@Test
	void testUpdateFeedback(){
		Feedback feedback = new Feedback();
		
		feedback.setId(101);
		feedback.setComments("interesting");
		feedback.setDescription("serviving the death");
		Date date = Date.valueOf("2021-02-24");
		feedback.setFeedbackDate(date);
		feedback.setRating("4");
		
		Feedback fb=feedbackService.updateFeedback(feedback);
		logger.info(fb);
		
		
		assertEquals("10",fb.getRating());
		assertEquals("interesting", fb.getComments());
	}
	
	// To view all the feedbacks
	@Test
	void testViewFeedbackList(){
		List<Feedback> feedback=feedbackService.viewFeedbackList();
		logger.info(feedback);
		
		assertEquals(2,feedback.size());
	}
	
	// To view feedback by userId
	@Test
	void testViewFeedbackByUser(){
		Feedback feedback=feedbackService.viewFeedBackByUser(100);
		logger.info(feedback);
		
		assertEquals("good",feedback.getComments());
		assertEquals("9",feedback.getRating());
	}
	
	// To view feedback by id
	@Test
	void testViewFeedbackById(){
		Feedback feedback=feedbackService.viewFeedbackById(101);
		logger.info(feedback);
		
		assertEquals(101, feedback.getId());
	}
	/*//test to write feedback
	@Test
	void testWriteFeedback() {
		Date date = Date.valueOf("2021-02-24");
		Date dob=Date.valueOf("1998-12-17");
		Date subscription=Date.valueOf("2020-08-13");
		Date subscriptionExpire=Date.valueOf("2021-08-13");
		Feedback feedback = new Feedback(102, date, "Fiction", "9", "good");
		Users users=new Users(100,dob,subscription,subscriptionExpire,"Active");
	
		feedback.setUsers(users);
		
		Feedback fb = feedbackService.writeFeedback(100, feedback);
		logger.info(fb);
		
		assertEquals("good", fb.getComments());
		assertEquals("9", fb.getRating());

	}*/
	
}
