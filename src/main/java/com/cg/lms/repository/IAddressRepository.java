
package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.Address;
import com.cg.lms.entity.Subscription;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

	@Query(value = "select * from address where user_id=:userId", nativeQuery = true)
	Address findAddressByUserId(@Param("userId") int userId);

}
