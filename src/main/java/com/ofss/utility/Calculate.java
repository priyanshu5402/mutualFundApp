package com.ofss.utility;

import java.util.List;

import com.ofss.model.MutualFund;

import oracle.net.aso.m;

public class Calculate {
	
	public static void CalculatetotalInvestment(MutualFund mutualfund,List<Integer> weightages,double amountEntered,List<Float> stockPrices) {
		
		double totalInvestment=0;
		double totalOutstandingUnits= mutualfund.getTotalOutstandingUnits();
	
			for(int index=0 ;index < weightages.size();index++) {
				double stockCost = amountEntered * weightages.get(index)/100;
				System.out.println(weightages.get(index));
				totalInvestment += stockCost;
				double investedUnits = stockCost / stockPrices.get(index);
				totalOutstandingUnits += investedUnits;				
			}
		
		mutualfund.setCashBalance(amountEntered -totalInvestment);
		mutualfund.setTotalInvestment(totalInvestment);
		System.out.println("total investment: "+ totalInvestment);
	}
	
	
		
	public static void nav(MutualFund mutualfund) {
		double expenseRatio = mutualfund.getExpenseRatio();
		double totalInvestment = mutualfund.getTotalInvestment();
		double totalOutstandingUnits = mutualfund.getTotalOutstandingUnits();
		double nav = ( totalInvestment - (expenseRatio*totalInvestment/100))/totalOutstandingUnits;
		System.out.println(nav);
		mutualfund.setNav(nav);
	
	}
	
	public static double UnitsToBuys(int transactionAmount,double currentNav,double entry_load) {
		
		//calculating number of units after subtracting entry load from the investor's purchase amount
		double numberOfUnits = (transactionAmount - (transactionAmount*entry_load/100))/currentNav;
		
		return numberOfUnits;
	}
	 public static double UnitsToSell(int transactionAmount, double currentNav, double exitLoad) {
	       
	        
	        double unitsToSell = (transactionAmount - (transactionAmount*exitLoad/100))/currentNav;
	        return unitsToSell;
	    }
}
