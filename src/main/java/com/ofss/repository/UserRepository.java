package com.ofss.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.ofss.model.Users;

public interface UserRepository extends CrudRepository<Users, Integer>{
	@Query(value = "SELECT * FROM users WHERE username =:username AND password =:password ", nativeQuery = true)
	Users findByUserNamePass(@Param("username")String username, @Param("password")String password);	
}
