package com.cg.lms.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.Users;

//Spring Data JPA
@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {

	@Modifying
	@Transactional
	@Query(value = "update users set subscription_status = 'Cancelled' where user_id = :userId", nativeQuery = true)
	void setSubscriptionStatus(@Param("userId") int userId);

	Users findUserByEmail(String email);

	Users findByUserId(int userId);

}
