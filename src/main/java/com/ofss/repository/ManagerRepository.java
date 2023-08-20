package com.ofss.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.model.Investor;
import com.ofss.model.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {
	@Query(value = "SELECT * FROM Manager WHERE username =:username AND password =:password ", nativeQuery = true)
	Manager findByManagerNamePass(@Param("username")String username, @Param("password")String password);	
}
