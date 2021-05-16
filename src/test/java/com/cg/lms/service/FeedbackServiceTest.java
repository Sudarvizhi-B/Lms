package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.lms.entity.Feedback;
import com.cg.lms.entity.Users;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class FeedbackServiceTest {

	@Autowired
	IFeedbackService feedbackService;

	@Test
	void testWriteFeedback() {
		Date date = Date.valueOf("2021-02-23");
		Date dob=Date.valueOf("1998-12-17");
		Date subscription=Date.valueOf("2020-08-13");
		Date subscriptionExpire=Date.valueOf("2021-08-13");
		Feedback feedback = new Feedback(101, date, "serviving the death", "9", "good");
		Users users=new Users(100,dob,subscription,subscriptionExpire,"Active");
	
		feedback.setUsers(users);
		
		Feedback fb = feedbackService.writeFeedback(100, feedback);
		System.out.println(fb);

		assertEquals("good", fb.getComments());
		assertEquals("9", fb.getRating());

	}
	@Test
	void testUpdateFeedback(){
		Feedback feedback = new Feedback();
		
		feedback.setId(101);
		feedback.setComments("interesting");
		feedback.setDescription("serviving the death");
		Date date = Date.valueOf("2021-02-24");
		feedback.setFeedbackDate(date);
		feedback.setRating("10");
		
		Feedback fb=feedbackService.updateFeedback(feedback);
		System.out.println(fb);
		
		assertEquals("10",fb.getRating());
		assertEquals("interesting", fb.getComments());
	}
	
	@Test
	void testViewFeedbackList(){
		List<Feedback> feedback=feedbackService.viewFeedbackList();
		
		assertEquals(1,feedback.size());
	}
	
	@Test
	void testViewFeedbackByUser(){
		Feedback feedback=feedbackService.viewFeedBackByUser(100);
		System.out.println(feedback);
		
		assertEquals("good",feedback.getComments());
		assertEquals("9",feedback.getRating());
	}
	
	@Test
	void testViewFeedbackById(){
		Feedback feedback=feedbackService.viewFeedbackById(101);
		System.out.println(feedback);
		
		assertEquals(101, feedback.getId());
	}
}
