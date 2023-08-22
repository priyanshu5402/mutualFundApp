package com.ofss.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofss.model.MutualFund;
import com.ofss.model.Stocks;
import com.ofss.pojo.MutualFundPOJO;
import com.ofss.repository.FundRepository;
import com.ofss.utility.Calculate;

import oracle.net.aso.f;


@Service
public class FundService {
	
	@Autowired
	FundRepository fundRepository;
	
	LocalDate currentDate = LocalDate.now();
    Date localDate = Date.valueOf(currentDate);
	
	@Transactional
	public String addMutualFund(MutualFund mutualfund,List<Integer> stockIds,List<Integer> weightages) {
		System.out.println("Service addMutualFund function called");
		System.out.println(localDate);
		List<Float> stockPrices =new ArrayList<Float>();
		//MutualFund mf=new MutualFund();
		//MutualFund mf = fundRepo.insertIntoMutualFund(mutualfundpojo.getCashBalance(), mutualfundpojo.getEntryLoad(), mutualfundpojo.getExitLoad(),mutualfundpojo.getExpenseRatio(),mutualfundpojo.getMutualFundName());
		
		for(int index=0; index <stockIds.size();index++ ) {
			float closingprice = fundRepository.findClosingPriceOfPReviousDay(stockIds.get(index));
			stockPrices.add(closingprice);
		}
		
		Calculate.CalculatetotalInvestment(mutualfund, weightages, 1000000000,stockPrices);
		Calculate.nav(mutualfund);
		
		
		fundRepository.save(mutualfund);

		addMutualFundStocks(mutualfund,stockIds,weightages);

		return "added to mutual fund table";

	}
		public String addMutualFundStocks(MutualFund mutualfund,List<Integer> stockIds,List<Integer> weightage) {
		//	try{
			System.out.println("Service addMutualFundStocks function called");
			
			for(int index=0; index <stockIds.size();index++ ) {
				
				fundRepository.insertIntoMutualFundStocks(weightage.get(index), mutualfund.getMutualFundId(),stockIds.get(index) );

				
			}
			return "added to mutual fund Stocks to the table";
//			catch( e){
//				
//			}
		}
		
		public ArrayList<MutualFund> getAllMutualFunds() {
			ArrayList<MutualFund> mutualfunds = fundRepository.getAllMutualFunds();
			
			return mutualfunds;

		}
		public String updateMutualFundDetailsForBuy(MutualFund mutualFund,double purchased_units,int transactionAmount) {
			mutualFund.setRemainingUnits(mutualFund.getRemainingUnits()-purchased_units);
			mutualFund.setTotalInvestment(mutualFund.getTotalInvestment()+(transactionAmount - transactionAmount*mutualFund.getEntryLoad()/100));
			
			Calculate.nav(mutualFund);
			
			fundRepository.save(mutualFund);
			
			return "nav and totalinvestment updated after buy";
		}
		public String updateMutualFundDetailsForSell(MutualFund mutualFund,double sold_units,int transactionAmount) {
			mutualFund.setRemainingUnits(mutualFund.getRemainingUnits()+sold_units);
			mutualFund.setTotalInvestment(mutualFund.getTotalInvestment()-(transactionAmount - transactionAmount*mutualFund.getExit_load()/100));
			
			Calculate.nav(mutualFund);
			
			fundRepository.save(mutualFund);
			
			return "nav and totalinvestment updated after sell";
		}

}
