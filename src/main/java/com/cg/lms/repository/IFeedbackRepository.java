package com.cg.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer>{
	
	@Query(value="select * from feedback  where user_id=:us", nativeQuery=true)
	public Feedback viewFeedBackByUser(@Param("us") int userId);
	
	public Optional<List<Feedback>> findByRating(String rating);
	
}
