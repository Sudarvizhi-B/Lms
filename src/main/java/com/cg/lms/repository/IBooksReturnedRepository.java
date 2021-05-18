package com.cg.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.BooksReturned;

@Repository
public interface IBooksReturnedRepository extends JpaRepository<BooksReturned, Integer> {

	List<BooksReturned> findByDelayedDaysGreaterThanEqual(int delayedDays);

}
