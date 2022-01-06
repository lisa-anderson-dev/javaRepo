package com.mars.returnship;

public class CheckingAccount extends Account {
	CheckingAccount(String name, long acctNo, double balance) {
		super(name, acctNo, balance);
	}
	
	@Override
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	}
	
	@Override
	public void withdraw(double amount) {
		setBalance(getBalance() - amount);
	}

	@Override
	public String accountInfo() {
		return 
			"Account Details" + 
			"\n   Account No:      " + getAcctNo() + 
			"\n   Account Type:    checking" + 
			"\n   Customer Name:   " + getName() + 
			"\n   Balance:         $" + String.format("%.02f", getBalance());
	}

	
}
