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
@Table(name="stock_price")
public class StockPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockPriceId;
	
	@ManyToOne
	@JoinColumn(name="stock_id")
	private StockDetail stockDetail;
	
	@Column(name="date", nullable = false, length=20)
	private String date;
	
	@Column(name="opening_price", nullable = false, length=20)
	private int openingPrice;
	
	@Column(name="closing_price", nullable = false, length=20)
	private int closingPrice;

	public int getStockPriceId() {
		return stockPriceId;
	}

	public void setStockPriceId(int stockPriceId) {
		this.stockPriceId = stockPriceId;
	}

	public StockDetail getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

	public StockPrice(int stockPriceId, StockDetail stockDetail, String date, int openingPrice, int closingPrice) {
		super();
		this.stockPriceId = stockPriceId;
		this.stockDetail = stockDetail;
		this.date = date;
		this.openingPrice = openingPrice;
		this.closingPrice = closingPrice;
	}
	
	public StockPrice() {
		// TODO Auto-generated constructor stub
	}
}
