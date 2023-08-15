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
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Users user;
	
	@Column(name="entry_load", nullable = false, length=20, precision = 8, scale=3)
	private float entryLoad;
	
	@Column(name="exit_load", nullable = false, length=20, precision = 8, scale=3)
	private float exit_load;
	
	@Column(name="expense_ratio", nullable = false, length=20, precision = 8, scale=3)
	private float expenseRatio;
	
	@Column(name="cash_balance", nullable = false, length=20, precision = 8, scale=3)
	private float cashBalance;
	
	@Column(name="remaining_units", nullable = false, length=20)
	private int remainingUnits;
	
	@Column(name="nav", nullable = false, length=20, precision = 8, scale=3)
	private float nav;

	public int getMutualFundId() {
		return mutualFundId;
	}

	public void setMutualFundId(int mutualFundId) {
		this.mutualFundId = mutualFundId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public float getEntryLoad() {
		return entryLoad;
	}

	public void setEntryLoad(float entryLoad) {
		this.entryLoad = entryLoad;
	}

	public float getExit_load() {
		return exit_load;
	}

	public void setExit_load(float exit_load) {
		this.exit_load = exit_load;
	}

	public float getExpenseRatio() {
		return expenseRatio;
	}

	public void setExpenseRatio(float expenseRatio) {
		this.expenseRatio = expenseRatio;
	}

	public float getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(float cashBalance) {
		this.cashBalance = cashBalance;
	}

	public int getRemainingUnits() {
		return remainingUnits;
	}

	public void setRemainingUnits(int remainingUnits) {
		this.remainingUnits = remainingUnits;
	}

	public float getNav() {
		return nav;
	}

	public void setNav(float nav) {
		this.nav = nav;
	}
	
	public MutualFund() {
		// TODO Auto-generated constructor stub
	}

	public MutualFund(int mutualFundId, Users user, float entryLoad, float exit_load, float expenseRatio,
			float cashBalance, int remainingUnits, float nav) {
		super();
		this.mutualFundId = mutualFundId;
		this.user = user;
		this.entryLoad = entryLoad;
		this.exit_load = exit_load;
		this.expenseRatio = expenseRatio;
		this.cashBalance = cashBalance;
		this.remainingUnits = remainingUnits;
		this.nav = nav;
	}
	
}
