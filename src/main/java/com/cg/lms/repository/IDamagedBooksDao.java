package com.cg.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.DamagedBooks;

@Repository
public interface IDamagedBooksDao extends JpaRepository<DamagedBooks, Integer> {
	
	List<DamagedBooks> findAllDamagedBooksByQuantityGreaterThan(int quantity);
}
