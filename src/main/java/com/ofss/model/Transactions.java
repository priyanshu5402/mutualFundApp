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
@Table(name="transactions")
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Investor investorId;
	
	@ManyToOne
	@JoinColumn(name="mutual_fund_id")
	private MutualFund mutual_fund;
	
	@Column(name="units_sold", nullable = false, length=20)
	private int unitsSold;
	
	@Column(name="units_purchased", nullable = false, length=20)
	private int unitsPurchased;
	
	@Column(name="transaction_price", nullable = false, length=20, precision = 8, scale=3)
	private float transactionPrice;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}



	public MutualFund getMutual_fund() {
		return mutual_fund;
	}

	public void setMutual_fund(MutualFund mutual_fund) {
		this.mutual_fund = mutual_fund;
	}

	public int getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

	public int getUnitsPurchased() {
		return unitsPurchased;
	}

	public void setUnitsPurchased(int unitsPurchased) {
		this.unitsPurchased = unitsPurchased;
	}

	public float getTransactionPrice() {
		return transactionPrice;
	}

	public void setTransactionPrice(float transactionPrice) {
		this.transactionPrice = transactionPrice;
	}
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public Transactions(int transactionId, Investor investorId, MutualFund mutual_fund, int unitsSold,
			int unitsPurchased, float transactionPrice) {
		super();
		this.transactionId = transactionId;
		this.investorId = investorId;
		this.mutual_fund = mutual_fund;
		this.unitsSold = unitsSold;
		this.unitsPurchased = unitsPurchased;
		this.transactionPrice = transactionPrice;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", investorId=" + investorId + ", mutual_fund="
				+ mutual_fund + ", unitsSold=" + unitsSold + ", unitsPurchased=" + unitsPurchased
				+ ", transactionPrice=" + transactionPrice + "]";
	}

	public Investor getInvestorId() {
		return investorId;
	}

	public void setInvestorId(Investor investorId) {
		this.investorId = investorId;
	}
	
}
