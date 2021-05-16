
package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.BooksIssued;

@Repository
public interface IBooksIssuedRepository extends JpaRepository<BooksIssued, Integer> {

}
