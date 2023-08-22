package com.ofss.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ofss.model.MutualFund;
import com.ofss.model.Transactions;

public interface TransactionRepository extends CrudRepository<Transactions, Integer>{

	@Modifying
	@Query(value="INSERT into TRANSACTIONS(transaction_id,transaction_price,units_purchased,units_sold,investor_id,mutual_fund_id) VALUES(DEFAULT,?,?,0,?,?)",nativeQuery=true)
	void buyTransaction(int transactionAmount,double units_purchased,int investor_id,int mutual_fund_id);
	
	@Modifying
	@Query(value="INSERT into TRANSACTIONS(transaction_id,transaction_price,units_purchased,units_sold,investor_id,mutual_fund_id) VALUES(DEFAULT,?,0,?,?,?)",nativeQuery=true)
	void sellTransaction(int transactionAmount,double units_sold,int investor_id,int mutual_fund_id);
}
