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
@Table(name="investment")
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int investmentId;
	
	@ManyToOne
	@JoinColumn(name="investorid")
	private Investor investor;
	
	@ManyToOne
	@JoinColumn(name="mutual_fund_id")
	private MutualFund mutualFund;
	
	@Column(name="total_units", nullable = false,precision = 12, scale = 3)
	private double  totalUnits;

	public int getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}


	public double getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(double totalUnits) {
		this.totalUnits = totalUnits;
	}


	@Override
	public String toString() {
		return "Investment [investmentId=" + investmentId + ", investor=" + investor + ", mutualFund=" + mutualFund
				+ ", totalUnits=" + totalUnits + "]";
	}

	public MutualFund getMutualFund() {
		return mutualFund;
	}

	public void setMutualFund(MutualFund mutualFund) {
		this.mutualFund = mutualFund;
	}

	public Investment(int investmentId, Investor investor, MutualFund mutualFund, double totalUnits) {
		super();
		this.investmentId = investmentId;
		this.investor = investor;
		this.mutualFund = mutualFund;
		this.totalUnits = totalUnits;
	}
public Investment() {
	// TODO Auto-generated constructor stub
}


}
