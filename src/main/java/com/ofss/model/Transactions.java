package com.ofss.model;

import java.math.BigDecimal;

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
@Table(name="transactions")
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	@ManyToOne
	@JoinColumn(name="investor_id")
	private Investor investorId;
	
	@ManyToOne
	@JoinColumn(name="mutual_fund_id")
	private MutualFund mutual_fund;
	
	@Column(name="units_sold", nullable = false,precision = 12, scale = 3)
	private double  unitsSold;
	
	@Column(name="units_purchased", nullable = false,columnDefinition = "NUMBER(15,3)")
	private double  unitsPurchased;
	
	@Column(name="transaction_price", nullable = false,columnDefinition = "NUMBER(15,3)")
	private double  transactionPrice;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Investor getInvestorId() {
		return investorId;
	}

	public void setInvestorId(Investor investorId) {
		this.investorId = investorId;
	}

	public MutualFund getMutual_fund() {
		return mutual_fund;
	}

	public void setMutual_fund(MutualFund mutual_fund) {
		this.mutual_fund = mutual_fund;
	}

	public double getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(double unitsSold) {
		this.unitsSold = unitsSold;
	}

	public double getUnitsPurchased() {
		return unitsPurchased;
	}

	public void setUnitsPurchased(double unitsPurchased) {
		this.unitsPurchased = unitsPurchased;
	}

	public double getTransactionPrice() {
		return transactionPrice;
	}

	public void setTransactionPrice(double transactionPrice) {
		this.transactionPrice = transactionPrice;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", investorId=" + investorId + ", mutual_fund="
				+ mutual_fund + ", unitsSold=" + unitsSold + ", unitsPurchased=" + unitsPurchased
				+ ", transactionPrice=" + transactionPrice + "]";
	}

	public Transactions(int transactionId, Investor investorId, MutualFund mutual_fund, double unitsSold,
			double unitsPurchased, double transactionPrice) {
		super();
		this.transactionId = transactionId;
		this.investorId = investorId;
		this.mutual_fund = mutual_fund;
		this.unitsSold = unitsSold;
		this.unitsPurchased = unitsPurchased;
		this.transactionPrice = transactionPrice;
	}

	
	
}
