package com.cg.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.Author;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Integer> {
	
	List <Author> findAllByFirstNameContainingIgnoreCase(String firstName);
}
