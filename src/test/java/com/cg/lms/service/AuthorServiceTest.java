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
		IAuthorService ias;

		
		@Test
		@Disabled
		void testShouldViewAuthorsList() {
			List<Author> ar = ias.viewAuthorsList();             //passing
			System.out.println(ar);
			assertEquals(3,ar.size());                  //enter total no. of rows
		}
			
		@Test
		@Disabled
		void testShoudlUpdateAuthorDetails() throws AuthorNotFoundException{
			Author ar = ias.viewAuthorById(9);                     //passing
			ar.setFirstName("Samuel");
			ar.setLastName("k");
			ar.setEmail("samk@gmail.com");
			ar.setContactno("777777777");
			Books book = new Books(102, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",25, 170, "Shelf A");
			List <Books> books = new ArrayList<>();
			books.add(book);
			ar.setBooks(books);
			
			Author updatedAr = ias.updateAuthorDetails(ar);
			//System.out.println(updatedAr);
			
			assertEquals("Samuel", updatedAr.getFirstName());
			assertEquals("k", updatedAr.getLastName());
			assertEquals("samk@gmail.com", updatedAr.getEmail());
			assertEquals("777777777", updatedAr.getContactno());
		}
		
		
		
		@Test
		//@Disabled
		void testShouldDeleteAuthorDetails() throws AuthorNotFoundException{
			Author ar = ias.deleteAuthorDetails(12);                   //passing
			assertEquals(11, ar.getAuthorId());
		}
		
		@Test
		@Disabled
		void testShouldViewAuthorById() throws AuthorNotFoundException{
			Author ar = ias.viewAuthorById(10);                                   //passing
			//System.out.println(ar);
			assertEquals("Sudaaaar",ar.getFirstName());
		}
		
		
		@Test
		@Disabled
		void testShouldAddAuthorDetail() {
		
			Author a = new Author(12,"sudha","kumar","srk@gmail.com","555555556");
			Books book = new Books(102, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",25, 170, "Shelf A");
			List <Books> books = new ArrayList<>();
			books.add(book);
			a.setBooks(books);
			
			Author persistedAr = ias.addAuthorDetails(a);
			assertEquals("srk@gmail.com",persistedAr.getEmail());
			//System.out.println(persistedAr);	
		}
		
		
	}

	
	

