package com.cg.lms.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.lms.repository.IFeedbackRepository;
import com.cg.lms.repository.IUsersRepository;
import com.cg.lms.entity.Feedback;
import com.cg.lms.entity.Users;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class FeedbackServiceMockitoTest {
	org.apache.logging.log4j.Logger logger= LogManager.getLogger(FeedbackServiceMockitoTest.class);
	
	@InjectMocks
	FeedbackServiceImpl feedbackService;
	
	@MockBean
	IFeedbackRepository feedbackRepo;
	
	@MockBean
	IUsersRepository usersRepo;
	
	@BeforeEach
	void init(){
		MockitoAnnotations.openMocks(this);
	}
	
	// To write Feedback
	@Test
	void testWriteFeedback(){
		Date date=Date.valueOf("2021-02-24");
		Date dob=Date.valueOf("1998-12-17");
		Date subscription=Date.valueOf("2020-08-13");
		Date subscriptionExpire=Date.valueOf("2021-08-13");
		Users users=new Users(101,dob,subscription,subscriptionExpire,"Active");
		Feedback feedback= new Feedback(101,date,"Serviving the death", "9", "good");
		
		feedback.setUsers(users);
		
		Mockito.when(usersRepo.findById(101)).thenReturn(Optional.of(users));
		Mockito.when(feedbackRepo.save(feedback)).thenReturn(feedback);
		
		Feedback writtenFeedback=feedbackService.writeFeedback(101, feedback);
		logger.info(writtenFeedback);
		
		assertEquals("9",writtenFeedback.getRating());
		assertEquals("good",writtenFeedback.getComments());
	}
	
	// To update Feedback
	@Test
	void testUpdateFeedback(){
		Date date=Date.valueOf("2021-02-24");
		Feedback feedback= new Feedback(101,date,"Serviving the death", "10", "Interesting");
		
		Mockito.when(feedbackRepo.findById(101)).thenReturn(Optional.of(feedback));
		Mockito.when(feedbackRepo.save(feedback)).thenReturn(feedback);
		
		Feedback updatedFeedback=feedbackService.updateFeedback(feedback);
		logger.info(updatedFeedback);
		
		assertEquals("Interesting",updatedFeedback.getComments());
	}
	
	// To view feedback by id
	@Test
	void testViewFeedbackById(){
		Date date=Date.valueOf("2021-02-24");
		Feedback feedback= new Feedback(101,date,"Serviving the death", "10", "Interesting");
		Mockito.when(feedbackRepo.findById(101)).thenReturn(Optional.of(feedback));
		
		Feedback feedbackById=feedbackService.viewFeedbackById(101);
		logger.info(feedbackById);
		
		assertEquals("10", feedbackById.getRating());
	}
	
	// To view all feedbacks
	@Test
	void testViewFeedbackList(){
		Date date=Date.valueOf("2021-02-24");
		Feedback feedback1= new Feedback(101,date,"Serviving the death", "10", "Interesting");
		Feedback feedback2= new Feedback(102,date,"FICTION", "10", "Good");
		
		List<Feedback> feedbackList=new ArrayList<>();
		feedbackList.add(feedback1);
		feedbackList.add(feedback2);
		
		Mockito.when(feedbackRepo.findAll()).thenReturn(feedbackList);
		
		List<Feedback> feedback=feedbackService.viewFeedbackList();
		logger.info(feedback);
		assertEquals(2,feedback.size());
	}
	
	// To view feedback by user
	@Test
	void testViewFeedbackByUser(){
		Date date=Date.valueOf("2021-02-24");
		Feedback feedback= new Feedback(101,date,"Serviving the death", "10", "Interesting");
		Users users=new Users();
		
		users.setUserId(100);
		feedback.setUsers(users);
		
		Mockito.when(feedbackRepo.viewFeedBackByUser(100)).thenReturn(feedback);
		
		Feedback feedbackByUser=feedbackService.viewFeedBackByUser(100);
		logger.info(feedbackByUser);
		assertEquals("10",feedbackByUser.getRating());
	}
	
}
