package com.cg.lms.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		System.out.println(writtenFeedback);
		
		assertEquals("9",writtenFeedback.getRating());
		assertEquals("good",writtenFeedback.getComments());
	}
	@Test
	void testUpdateFeedback(){
		Date date=Date.valueOf("2021-02-24");
		Feedback feedback= new Feedback(101,date,"Serviving the death", "10", "Interesting");
		
		Mockito.when(feedbackRepo.findById(101)).thenReturn(Optional.of(feedback));
		Mockito.when(feedbackRepo.save(feedback)).thenReturn(feedback);
		
		Feedback updatedFeedback=feedbackService.updateFeedback(feedback);
		System.out.println(updatedFeedback);
		
		assertEquals("Interesting",updatedFeedback.getComments());
	}
	
	@Test
	void testViewFeedbackById(){
		Date date=Date.valueOf("2021-02-24");
		Feedback feedback= new Feedback(101,date,"Serviving the death", "10", "Interesting");
		Mockito.when(feedbackRepo.findById(101)).thenReturn(Optional.of(feedback));
		
		Feedback feedbackById=feedbackService.viewFeedbackById(101);
		System.out.println(feedbackById);
		
		assertEquals("10", feedbackById.getRating());
	}
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
		
		assertEquals(2,feedback.size());
	}
	@Test
	void testViewFeedbackByUser(){
		Date date=Date.valueOf("2021-02-24");
		Feedback feedback= new Feedback(101,date,"Serviving the death", "10", "Interesting");
		Users users=new Users();
		
		users.setUserId(100);
		feedback.setUsers(users);
		
		Mockito.when(feedbackRepo.viewFeedBackByUser(100)).thenReturn(feedback);
		
		Feedback feedbackByUser=feedbackService.viewFeedBackByUser(100);
		
		assertEquals("10",feedbackByUser.getRating());
	}
	
}
