package com.ofss.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.model.Investor;

public interface InvestorRepository extends CrudRepository<Investor, Integer>{
	
	@Query(value = "SELECT * FROM Investor WHERE username =:username AND password =:password ", nativeQuery = true)
	Investor findByInvestorNamePass(@Param("username")String username, @Param("password")String password);	
	
	
	
	
}
