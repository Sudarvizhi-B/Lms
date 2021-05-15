package com.cg.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.Books;

@Repository
public interface IBooksDao extends JpaRepository<Books, Integer>{
	
	List<Books> findAllByTitle(String title);
	
	List<Books> findAllBySubject(String subject);
}
