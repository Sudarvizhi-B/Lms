package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.DamagedBooks;

@Repository
public interface IDamagedBooksDao extends JpaRepository<DamagedBooks, Integer> {

}
