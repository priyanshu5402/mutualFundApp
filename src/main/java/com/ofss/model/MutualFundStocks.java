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
@Table(name="mutual_fund_stocks")
public class MutualFundStocks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mfStockId;
	
	@ManyToOne
	@JoinColumn(name="mutual_fund_id")
	private MutualFund mutual_fund;
	
	@ManyToOne
	@JoinColumn(name="stock_id")
	private StockDetail stockDetail;
	
	@Column(name="weightage", nullable = false, length=20)
	private int weightage;

	public int getMfStockId() {
		return mfStockId;
	}

	public void setMfStockId(int mfStockId) {
		this.mfStockId = mfStockId;
	}

	public MutualFund getMutual_fund() {
		return mutual_fund;
	}

	public void setMutual_fund(MutualFund mutual_fund) {
		this.mutual_fund = mutual_fund;
	}

	public StockDetail getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}

	public int getWeightage() {
		return weightage;
	}

	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}

	public MutualFundStocks(int mfStockId, MutualFund mutual_fund, StockDetail stockDetail, int weightage) {
		super();
		this.mfStockId = mfStockId;
		this.mutual_fund = mutual_fund;
		this.stockDetail = stockDetail;
		this.weightage = weightage;
	}
	
	public MutualFundStocks() {
		// TODO Auto-generated constructor stub
	}
}
