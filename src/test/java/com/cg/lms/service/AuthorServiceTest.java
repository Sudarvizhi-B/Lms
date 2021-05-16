package com.cg.lms.service;
	import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
	import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import com.cg.lms.entity.Author;
import com.cg.lms.entity.Books;
import com.cg.lms.exception.AuthorNotFoundException;

	@SpringBootTest
	public class AuthorServiceTest {

		@BeforeAll
		static void setUpBeforeClass() throws Exception {
			System.out.println("setUpBeforeClass");
		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
			System.out.println("tearDownAfterClass");
		}
		
		@Autowired
		AuthorService ias;

		
		@Test
		@Disabled
		void testShouldViewAuthorsList() {
			List<Author> ar = ias.viewAuthorsList();             //passing
			System.out.println(ar);
			assertEquals(2,ar.size());                  //enter total no. of rows
		}
			
		@Test
		@Disabled
		void testShoudlUpdateAuthorDetails() throws AuthorNotFoundException{
			Author ar = ias.viewAuthorById(1);                     //passing
			ar.setFirstName("Samuel");
			ar.setLastName("k");
			ar.setEmail("samk@gmail.com");
			ar.setContactno("777777777");
			
			Author updatedAr = ias.updateAuthorDetails(ar);
			//System.out.println(updatedAr);
			
			assertEquals("Samuel", updatedAr.getFirstName());
			assertEquals("k", updatedAr.getLastName());
			assertEquals("samk@gmail.com", updatedAr.getEmail());
			assertEquals("777777777", updatedAr.getContactno());
		}
		
		
		
		@Test
		@Disabled
		void testShouldDeleteAuthorDetails() throws AuthorNotFoundException{
			Author ar = ias.deleteAuthorDetails(6);                   //passing
			assertEquals(6, ar.getAuthorId());
		}
		
		@Test
		@Disabled
		void testShouldViewAuthorById() throws AuthorNotFoundException{
			Author ar = ias.viewAuthorById(1);                                   //passing
			//System.out.println(ar);
			assertEquals("Samuel",ar.getFirstName());
		}
		
		
		@Test
		void testShouldAddAuthorDetail() {
		
			Author a = new Author(9,"sudha","kumar","srk@gmail.com","555555555");
			Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",25, 170, "Shelf A");
			List <Books> books = new ArrayList<>();
			books.add(book);
			a.setBooks(books);
			
			Author persistedAr = ias.addAuthorDetails(a);
			assertEquals("srk@gmail.com",persistedAr.getEmail());
			//System.out.println(persistedAr);	
		}
		
		
	}

	
	

