package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.lms.entity.Publishers;

@Repository
public interface IPublisherRepository extends JpaRepository<Publishers, Integer> {

}
