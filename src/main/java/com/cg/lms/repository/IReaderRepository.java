package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.Reader;

@Repository
public interface IReaderRepository extends JpaRepository<Reader, Integer>{
	
	public Reader findByfirstNameEquals(String firstName);

}


