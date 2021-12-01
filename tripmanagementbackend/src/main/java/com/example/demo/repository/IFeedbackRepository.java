package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.model.FeedBack;

@Repository
public interface IFeedbackRepository extends JpaRepository<FeedBack, Long>{
	
//	List<FeedBack> findByCustomerId(long customerId);
	

	@Query("From FeedBack where customer.customerId = :customerId")
	List<FeedBack> getByCustomerId(@Param("customerId") long customerId);
	
	@Modifying
	@Transactional
	@Query("Delete from FeedBack where customer = :customer")
	Integer DeleteByCustomer(Customer customer);
	
}
