package com.mars.returnship;

import java.util.*;

public class ElectricBillCalculator {

	public static void main(String[] args) {
		String input = "";
		System.out.println("\n" + " ".repeat(37) + "WELCOME TO THE ELECTRIC BILL CALCULATOR\n");	
		System.out.println("-".repeat(114) + "\n");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of bills to prepare: ");
		input = sc.nextLine();
		int numBills = Integer.parseInt(input);
		ElectricBill[] billArr = new ElectricBill[numBills];
		System.out.println("\nEnter the Account ID, Customer Name and Total Usage as a list of comma-separated values - i.e. 653,Steve Jones,754");
		for (int i = 0; i < numBills; i++) {
			System.out.print("Entry " + (i + 1) + ": ");
			input = sc.nextLine();	
			String[] inputArr = input.split(",");
			ElectricBill bill = new ElectricBill(Integer.parseInt(inputArr[0].trim()), inputArr[1].trim(), Integer.parseInt(inputArr[2].trim()));
			billArr[i] = bill;
		}
		sc.close();
		System.out.println();
		System.out.println("-".repeat(114) + "\n");
		printBillingReport(billArr);
	}
	
	public static void printBillingReport(ElectricBill[] billArr) {
		System.out.println("COMPLETE BILLING REPORT - " + billArr.length + " Consumer(s)");
		int count = 1;
		for (ElectricBill bill : billArr) {
			System.out.println("\nCONSUMER " + count);
			System.out.println(bill.getBillingInfo());
			count++;
		}
	}
	
}
