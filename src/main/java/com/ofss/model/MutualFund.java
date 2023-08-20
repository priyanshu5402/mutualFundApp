package com.ofss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
@Entity
@Table(name="mutual_fund")	
public class MutualFund {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mutualFundId;
	
	@Column(name="mutual_fund_name", nullable = false, length=100)
	private String mutualFundName;
	
	@Column(name="entry_load", nullable = true, length=20, precision = 8, scale=3)
	private double entryLoad;
	
	@Column(name="exit_load", nullable = true, length=20, precision = 8, scale=3)
	private double exit_load;
	
	@Column(name="expense_ratio", nullable = true, length=20, precision = 8, scale=3)
	private double expenseRatio;
	
	@Column(name="cash_balance", nullable = true, length=20, precision = 8, scale=3)
	private double cashBalance;
	
	@Column(name="total_Outstanding_units", nullable = true, length=20)
	private int totalOutstandingUnits;
	
	@Column(name="remaining_units", nullable = true, length=20)
	private int remainingUnits;
	
	@Column(name="nav", nullable = true, length=20, precision = 8, scale=3)
	private double nav;
	
	@Column(name="total_Investment", nullable = true, length=20)
	private double totalInvestment;



	public int getTotalOutstandingUnits() {
		return totalOutstandingUnits;
	}

	public void setTotalOutstandingUnits(int totalOutstandingUnits) {
		this.totalOutstandingUnits = totalOutstandingUnits;
	}

	public double getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(double totalInvestment2) {
		this.totalInvestment = totalInvestment2;
	}

	public int getMutualFundId() {
		return mutualFundId;
	}

	public void setMutualFundId(int mutualFundId) {
		this.mutualFundId = mutualFundId;
	}

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

	public double getExit_load() {
		return exit_load;
	}

	public void setExit_load(double exit_load) {
		this.exit_load = exit_load;
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

	public int getRemainingUnits() {
		return remainingUnits;
	}

	public void setRemainingUnits(int remainingUnits) {
		this.remainingUnits = remainingUnits;
	}

	public double getNav() {
		return nav;
	}

	public void setNav(double nav) {
		this.nav = nav;
	}

public MutualFund() {
	// TODO Auto-generated constructor stub
}
	
}
