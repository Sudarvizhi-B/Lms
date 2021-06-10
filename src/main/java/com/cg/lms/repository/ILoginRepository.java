package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.Address;
import com.cg.lms.entity.Login;
import com.cg.lms.entity.Users;

@Repository
public interface ILoginRepository extends JpaRepository<Login, String> {
	
	@Query(value = "select user_id from users where user_id=:userId", nativeQuery = true)
	Login findByUserId(@Param("userId") int userId);
	
	

}
