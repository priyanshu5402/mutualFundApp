package com.ofss.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
//@IdClass(StockID.class)
public class Stocks {
	
	
//	@Column(name="stock_id",nullable=false,length=20)
	@EmbeddedId
	private StockID stock_id;
	
	@Column(name = "stock_name",nullable = false, length=20)
	private String stockName;
	
	@Column(name="opening_price", nullable = false, length=20)
	private int openingPrice;
	
	@Column(name="closing_price", nullable = false, length=20)
	private int closingPrice;

//	public int getStockId() {
//		return stockId;
//	}
//
//	public void setStockId(int stockId) {
//		this.stockId = stockId;
//	}
//
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}

	public int getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(int openingPrice) {
		this.openingPrice = openingPrice;
	}

	public int getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(int closingPrice) {
		this.closingPrice = closingPrice;
	}

	public StockID getStock_id() {
		return stock_id;
	}

	public void setStock_id(StockID stock_id) {
		this.stock_id = stock_id;
	}

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int stockPriceId;
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int stockId;
//	

//	@Column(name="current_date", nullable = false, length=20)
//	private String date;
//	@ManyToOne
//	@JoinColumn(name="stock_id")
//	private StockDetail stockDetail;
	
	
}
