package com.cg.lms.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cg.lms.repository.IReaderRepository;
import com.cg.lms.entity.Reader;

@ExtendWith(SpringExtension.class)
public class ReaderServiceMockitoTest {
	
	//Inject dependencies
	@InjectMocks
	ReaderServiceImpl readerService;
	
	@MockBean
	IReaderRepository readerRepo;
	
	//Initialization of mock objects
	@BeforeEach
	void init(){
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testRegisterReader(){
		Reader reader= new Reader(101,"abc","Sandhyana","N","9739450654","san@gmail.com");
		
		Mockito.when(readerRepo.save(reader)).thenReturn(reader);
		
		Reader registeredReader=readerService.register(reader);
		System.out.println(registeredReader);
		
		assertEquals("Sandhyana", registeredReader.getFirstName());
	}
	
	@Test
	void testUpdateReaderDetails(){
		Reader reader= new Reader(101,"xyz","Sandhya","N","9739450567","sandy@gmail.com");
		
		Mockito.when(readerRepo.findById(101)).thenReturn(Optional.of(reader));
		Mockito.when(readerRepo.save(reader)).thenReturn(reader);
		
		Reader updatedReader=readerService.updateReaderDetails(reader);
		System.out.println(updatedReader);
		
		assertEquals("Sandhya", updatedReader.getFirstName());
		assertEquals("N",updatedReader.getLastName());
	}
	
	@Test
	void testDeleteReader(){
		Reader reader= new Reader(101,"xyz","Sandhya","N","9739450567","sandy@gmail.com");
		
		Mockito.when(readerRepo.findById(101)).thenReturn(Optional.of(reader));
		
		readerRepo.deleteById(101);
		
		Reader read=readerService.deleteReader(101);
		
		assertEquals("Sandhya", read.getFirstName());
		assertEquals("N",read.getLastName());
		assertEquals("9739450567", read.getMobileNo());
	}
	
	@Test
	void testViewReaderList(){
		Reader reader1= new Reader(101,"xyz","Sandhya","N","9739450567","sandy@gmail.com");
		Reader reader2= new Reader(102,"abc","Sandhyana","N","9739450654","san@gmail.com");
		
		List<Reader> readerList=new ArrayList<>();
		readerList.add(reader1);
		readerList.add(reader2);
		
		Mockito.when(readerRepo.findAll()).thenReturn(readerList);
		
		List<Reader> reader= readerService.viewReadersList();
		
		assertEquals(2,reader.size());
	}
	
	@Test
	void testViewReaderById(){
		Reader reader= new Reader(101,"xyz","Sandhya","N","9739450567","sandy@gmail.com");
		
		Mockito.when(readerRepo.findById(101)).thenReturn(Optional.of(reader));
		
		Reader readerById=readerService.viewReaderById(101);
		System.out.println(readerById);
		
		assertEquals("Sandhya", readerById.getFirstName());
	}
}
