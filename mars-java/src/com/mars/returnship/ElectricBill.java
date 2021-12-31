package com.mars.returnship;

public class ElectricBill {
	
	private int accountId;
	private String customerName;
	private int totalUsage;
	private float amountDue;
	
	public ElectricBill(int accountId, String customerName, int totalUsage) {
		this.accountId = accountId;
		this.customerName = customerName;
		this.totalUsage = totalUsage;
		this.amountDue = getAmountDue(totalUsage);
	}
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getTotalUsage() {
		return totalUsage;
	}

	public void setTotalUsage(int totalUsage) {
		this.totalUsage = totalUsage;
	}
	
	public float getAmountDue(int totalUsage) {
		if (totalUsage < 201) {
			return 50f;
		}
		else if (totalUsage < 501) {
			return 1.25f * totalUsage;
		}
		else if (totalUsage < 1001) {
			return 1.00f * totalUsage;
		}
		else {
			return .75f * totalUsage;
		}
	}
	
	public String getBillingInfo() {
		return 
				"Account ID:         " + accountId + 
				"\nCustomer Name:      " + customerName + 
				"\nTotal Usage:        " + totalUsage + 
				"\nAmount Due:         " + String.format("%.02f", amountDue);
	}
}
