package com.ofss.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.model.MutualFund;
import com.ofss.pojo.MutualFundPOJO;

public interface FundRepository extends CrudRepository<MutualFund, Integer> {
		
		@Modifying
		@Query(value="INSERT INTO MUTUAL_FUND(mutual_fund_id,cash_balance,entry_load,exit_load,expense_ratio,mutual_fund_name,nav,remaining_units) Values(DEFAULT,?,?,?,?,?,0,0)",nativeQuery=true)
		void insertIntoMutualFund( float cashBalance,float entryLoad,float exitLoad,float expenseRatio,String mutualFundName);
		
		@Modifying
		@Query(value="INSERT INTO MUTUAL_FUND_STOCKS(mf_stock_id,weightage,mutual_fund_id,present_date,stock_id) Values(DEFAULT,?,?,TRUNC(SYSDATE),?)",nativeQuery=true)
		void insertIntoMutualFundStocks(int weightage,int mutualFundId,int stockid);
		
		@Query(value="SELECT closing_price FROM Stocks WHERE (EXTRACT(DAY FROM present_date) = (EXTRACT(DAY FROM TRUNC(SYSDATE))-1)) AND STOCK_ID = ?", nativeQuery=true)
		float findClosingPriceOfPReviousDay(int stockId);
}
