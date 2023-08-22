package com.ofss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.model.Investment;
import com.ofss.model.Investor;
import com.ofss.model.MutualFund;


public interface InvestorRepository extends CrudRepository<Investor, Integer>{
	
	@Query(value = "SELECT * FROM Investor WHERE username =:username AND password =:password ", nativeQuery = true)
	Investor findByInvestorNamePass(@Param("username")String username, @Param("password")String password);	
	
	@Modifying
	@Query(value="INSERT INTO Investment(investment_id,total_units,investorid,mutual_fund_id) values(DEFAULT,?,?,?)",nativeQuery =true)
	void setInvestment(double total_units,int investorid,int mutual_fund_id);
	
	@Modifying
	@Query(value="Update Investment SET total_units = ? where investorid = ? AND mutual_fund_id=?")
	void updateInvestment(double total_units,int investorid,int mutual_fund_id);

}
