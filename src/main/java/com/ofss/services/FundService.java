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
import com.ofss.utility.Calculations;


@Service
public class FundService {
	
	@Autowired
	FundRepository fundRepo;
	
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
			float closingprice = fundRepo.findClosingPriceOfPReviousDay(stockIds.get(index));
			stockPrices.add(closingprice);
		}
		
		Calculations.CalculatetotalInvestment(mutualfund, weightages, 1000000000,stockPrices);
		Calculations.nav(mutualfund);
		
		
		fundRepo.save(mutualfund);

		addMutualFundStocks(mutualfund,stockIds,weightages);

		return "added to mutual fund table";
//		catch( e){
//			
//		}
	}
		public String addMutualFundStocks(MutualFund mutualfund,List<Integer> stockIds,List<Integer> weightage) {
		//	try{
			System.out.println("Service addMutualFundStocks function called");
			
			for(int index=0; index <stockIds.size();index++ ) {
				
				fundRepo.insertIntoMutualFundStocks(weightage.get(index), mutualfund.getMutualFundId(),stockIds.get(index) );

				
			}
			return "added to mutual fund Stocks to the table";
//			catch( e){
//				
//			}
		}

}
