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
@Table(name="investment")
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int investmentId;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="mutual_fund_id")
	private MutualFund mutual_fund;
	
	@Column(name="total_units", nullable = false, length=20)
	private int totalUnits;

	public int getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public MutualFund getMutual_fund() {
		return mutual_fund;
	}

	public void setMutual_fund(MutualFund mutual_fund) {
		this.mutual_fund = mutual_fund;
	}

	public int getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

	public Investment(int investmentId, Users user, MutualFund mutual_fund, int totalUnits) {
		super();
		this.investmentId = investmentId;
		this.user = user;
		this.mutual_fund = mutual_fund;
		this.totalUnits = totalUnits;
	}
	
	public Investment() {
		// TODO Auto-generated constructor stub
	}
}
