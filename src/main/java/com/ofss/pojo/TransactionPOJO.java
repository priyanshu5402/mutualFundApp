package com.ofss.pojo;

public class TransactionPOJO {

	private int transactionAmount;
	
	private int mutualFundId;
	
	private int investorId;

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getMutualFundId() {
		return mutualFundId;
	}

	public void setMutualFundId(int mutualFundId) {
		this.mutualFundId = mutualFundId;
	}

	public int getInvestorId() {
		return investorId;
	}

	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}

	public TransactionPOJO(int transactionAmount, int mutualFundId, int investorId) {
		super();
		this.transactionAmount = transactionAmount;
		this.mutualFundId = mutualFundId;
		this.investorId = investorId;
	}
	
	public TransactionPOJO() {
		// TODO Auto-generated constructor stub
	}
	
}
