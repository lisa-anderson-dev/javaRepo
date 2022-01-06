package com.mars.returnship;

public abstract class Account {
	private String name;
	private long acctNo;
	private double balance;
	
	Account(String name, long acctNo, double balance) {
		this.name = name;
		this.acctNo = acctNo;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(long acctNo) {
		this.acctNo = acctNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);
	public abstract String accountInfo();
}
