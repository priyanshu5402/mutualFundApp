package com.ofss.model;

import java.io.Serializable;
import java.sql.Date;
public class StockID  implements Serializable{
	
	
	private int stockId;
	private Date present_date;
	
	
	public int getStockPriceId() {
		return stockId;
	}
	public void setStockPriceId(int stockPriceId) {
		this.stockId = stockPriceId;
	}

	public Date getPresent_date() {
		return present_date;
	}
	public void setPresent_date(Date present_date) {
		this.present_date = present_date;
	}
	@Override
	public String toString() {
		return "StockID [stockPriceId=" + stockId + ", date=" + present_date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((present_date == null) ? 0 : present_date.hashCode());
		result = prime * result + stockId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockID other = (StockID) obj;
		if (present_date == null) {
			if (other.present_date != null)
				return false;
		} else if (!present_date.equals(other.present_date))
			return false;
		if (stockId != other.stockId)
			return false;
		return true;
	}

	
}
