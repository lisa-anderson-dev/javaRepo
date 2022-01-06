package com.mars.returnship;

import java.util.*;

public class BankingApplication {
	public static void main(String[] args) {
		long lastAcctNo = 0;
		System.out.println("Welcome to Online Banking");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = sc.nextLine();
		System.out.print("What type of account do you want to open (s=savings, c=checking)? ");
		String type = sc.next().toLowerCase();
		if (!(type.equals("s") || type.equals("c"))) {
			System.out.println("\nInvalid command. Exiting program.");
		}
		else {
			lastAcctNo++;
			long acctNo = lastAcctNo;
			System.out.print("Enter the starting balance for your new account: ");
			double balance = sc.nextDouble();
			String accountName = "";
			Account account = null;
			if (type.equals("s")) {
				accountName = "savings";
				account = new SavingsAccount(name, acctNo, balance);
			}
			else {
				accountName = "checking";
				account = new CheckingAccount(name, acctNo, balance);
				
			}
			System.out.println("\nCongratulations on opening your " + accountName + " account!");
			System.out.println("\n" + account.accountInfo() + "\n");
			while (true) {
				System.out.print("What would you like to do with this account (d=make a deposit, w=make a withdrawal, q=exit program)? ");
				String action = sc.next().toLowerCase();
				if (action.equals("q")) {
					System.out.println("\nExiting program. Goodbye!");
					break;
				}
				else if (!(action.equals("d") || action.equals("w"))) {
					System.out.println("Invalid command. Please try again.\n");
				}
				else {
					if (action.equals("w")) {
						System.out.println();
						System.out.print("Enter the amount to withdraw: ");
						double amount = sc.nextDouble();
						if (amount > account.getBalance()) {
							System.out.println("Withdrawal amount cannot exceed account balance. Please try again.\n");
						}
						else {
							System.out.println();
							account.withdraw(amount);
							System.out.println("An amount of $" + String.format("%.02f", amount) + " has been withdrawn from your account.");
							System.out.println("\n" + account.accountInfo() + "\n");
						}
					}
					else {
						System.out.print("Enter the amount to deposit: ");
						double amount = sc.nextDouble();
						System.out.println();
						account.deposit(amount);
						System.out.println("An amount of $" + String.format("%.02f", amount) + " has been deposited into your account.");
						System.out.println("\n" + account.accountInfo() + "\n");
					}
				}
			}
		}
		sc.close();
	}
}
