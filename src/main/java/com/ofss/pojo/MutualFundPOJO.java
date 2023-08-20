package com.ofss.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.ofss.model.MutualFund;
import com.ofss.model.Stocks;

public class MutualFundPOJO {
	
	//private int mutualFundId;
	
	private String mutualFundName;
	
	private double entryLoad;
	
	private double exitLoad;
	
	private double expenseRatio;
	
	private double cashBalance;
	
	private int numberOfOutstandinUnits;
	
	private int totalInvestment;
		
    private Stocks stockId; 
	
    private List<Integer> stockIds;
	private List<Integer> weightage;
	public String getMutualFundName() {
		return mutualFundName;
	}
	public void setMutualFundName(String mutualFundName) {
		this.mutualFundName = mutualFundName;
	}
	public double getEntryLoad() {
		return entryLoad;
	}
	public void setEntryLoad(double entryLoad) {
		this.entryLoad = entryLoad;
	}
	public double getExitLoad() {
		return exitLoad;
	}
	public void setExitLoad(double exitLoad) {
		this.exitLoad = exitLoad;
	}
	public double getExpenseRatio() {
		return expenseRatio;
	}
	public void setExpenseRatio(double expenseRatio) {
		this.expenseRatio = expenseRatio;
	}
	public double getCashBalance() {
		return cashBalance;
	}
	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}
	public int getNumberOfOutstandinUnits() {
		return numberOfOutstandinUnits;
	}
	public void setNumberOfOutstandinUnits(int numberOfOutstandinUnits) {
		this.numberOfOutstandinUnits = numberOfOutstandinUnits;
	}
	public int getTotalInvestment() {
		return totalInvestment;
	}
	public void setTotalInvestment(int totalInvestment) {
		this.totalInvestment = totalInvestment;
	}
	public Stocks getStockId() {
		return stockId;
	}
	public void setStockId(Stocks stockId) {
		this.stockId = stockId;
	}
	public List<Integer> getStockIds() {
		return stockIds;
	}
	public void setStockIds(List<Integer> stockIds) {
		this.stockIds = stockIds;
	}
	public List<Integer> getWeightage() {
		return weightage;
	}
	public void setWeightage(List<Integer> weightage) {
		this.weightage = weightage;
	}
	public MutualFundPOJO(String mutualFundName, double entryLoad, double exitLoad, double expenseRatio,
			double cashBalance, int numberOfOutstandinUnits, int totalInvestment, Stocks stockId,
			List<Integer> stockIds, List<Integer> weightage) {
		super();
		this.mutualFundName = mutualFundName;
		this.entryLoad = entryLoad;
		this.exitLoad = exitLoad;
		this.expenseRatio = expenseRatio;
		this.cashBalance = cashBalance;
		this.numberOfOutstandinUnits = numberOfOutstandinUnits;
		this.totalInvestment = totalInvestment;
		this.stockId = stockId;
		this.stockIds = stockIds;
		this.weightage = weightage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cashBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(entryLoad);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(exitLoad);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(expenseRatio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((mutualFundName == null) ? 0 : mutualFundName.hashCode());
		result = prime * result + numberOfOutstandinUnits;
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
		result = prime * result + ((stockIds == null) ? 0 : stockIds.hashCode());
		result = prime * result + totalInvestment;
		result = prime * result + ((weightage == null) ? 0 : weightage.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MutualFundPOJO other = (MutualFundPOJO) obj;
		if (Double.doubleToLongBits(cashBalance) != Double.doubleToLongBits(other.cashBalance))
			return false;
		if (Double.doubleToLongBits(entryLoad) != Double.doubleToLongBits(other.entryLoad))
			return false;
		if (Double.doubleToLongBits(exitLoad) != Double.doubleToLongBits(other.exitLoad))
			return false;
		if (Double.doubleToLongBits(expenseRatio) != Double.doubleToLongBits(other.expenseRatio))
			return false;
		if (mutualFundName == null) {
			if (other.mutualFundName != null)
				return false;
		} else if (!mutualFundName.equals(other.mutualFundName))
			return false;
		if (numberOfOutstandinUnits != other.numberOfOutstandinUnits)
			return false;
		if (stockId == null) {
			if (other.stockId != null)
				return false;
		} else if (!stockId.equals(other.stockId))
			return false;
		if (stockIds == null) {
			if (other.stockIds != null)
				return false;
		} else if (!stockIds.equals(other.stockIds))
			return false;
		if (totalInvestment != other.totalInvestment)
			return false;
		if (weightage == null) {
			if (other.weightage != null)
				return false;
		} else if (!weightage.equals(other.weightage))
			return false;
		return true;
	}
	
	public MutualFundPOJO() {
		// TODO Auto-generated constructor stub
	}
	
}
