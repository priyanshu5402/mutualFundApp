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
	
	
	
}
