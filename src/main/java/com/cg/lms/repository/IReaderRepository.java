package com.cg.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.Reader;

@Repository
public interface IReaderRepository extends JpaRepository<Reader, Integer>{
	
	public Optional<List<Reader>> findByfirstNameEquals(String firstName);

}


