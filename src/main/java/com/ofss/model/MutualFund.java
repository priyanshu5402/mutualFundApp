package com.ofss.model;

import java.util.List;

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
	
	@Column(name="mutual_fund_name", nullable = false, length=40)
	private String mutualFundName;
	
	@Column(name="entry_load", nullable = true, precision = 8, scale=3)
	private float entryLoad;
	
	@Column(name="exit_load", nullable = true, precision = 8, scale=3)
	private float exit_load;
	
	@Column(name="expense_ratio", nullable = true, precision = 8, scale=3)
	private float expenseRatio;
	
	@Column(name="cash_balance", nullable = true, precision = 8, scale=3)
	private float cashBalance;
	
	@Column(name="total_corpus", nullable = false, precision = 8, scale=3)
	private float totalCorpus;
	
	@Column(name="nav", nullable = true, precision = 8, scale=3)
	private float nav;

	@ManyToOne
	@JoinColumn(name="stock_id")
	private List<StockDetail> stockDetail;
	
	@Column(name="weightage", nullable = false, length=20)
	private List<Integer> weightage;

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

	public float getTotalCorpus() {
		return totalCorpus;
	}

	public void setTotalCorpus(float totalCorpus) {
		this.totalCorpus = totalCorpus;
	}

	public float getNav() {
		return nav;
	}

	public void setNav(float nav) {
		this.nav = nav;
	}

	public List<StockDetail> getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(List<StockDetail> stockDetail) {
		this.stockDetail = stockDetail;
	}

	public List<Integer> getWeightage() {
		return weightage;
	}

	public void setWeightage(List<Integer> weightage) {
		this.weightage = weightage;
	}

	public MutualFund(int mutualFundId, String mutualFundName, float entryLoad, float exit_load, float expenseRatio,
			float cashBalance, float totalCorpus, float nav, List<StockDetail> stockDetail, List<Integer> weightage) {
		super();
		this.mutualFundId = mutualFundId;
		this.mutualFundName = mutualFundName;
		this.entryLoad = entryLoad;
		this.exit_load = exit_load;
		this.expenseRatio = expenseRatio;
		this.cashBalance = cashBalance;
		this.totalCorpus = totalCorpus;
		this.nav = nav;
		this.stockDetail = stockDetail;
		this.weightage = weightage;
	}
	
	public MutualFund() {
		// TODO Auto-generated constructor stub
	}
	
}
