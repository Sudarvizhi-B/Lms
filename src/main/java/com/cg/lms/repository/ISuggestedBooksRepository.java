package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.lms.entity.SuggestedBooks;

@Repository
public interface ISuggestedBooksRepository extends JpaRepository<SuggestedBooks, Integer >{

}
