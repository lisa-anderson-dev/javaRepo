package com.mars.returnship;

import java.util.*;

public class DigitSum {

	public static void main(String[] args) {
		while (true) {
			System.out.print("Enter a 4-digit number: ");
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			if (input.length() == 4) {
				int sum = 0;
				char[] charArr = input.toCharArray();
				for (int i = 0; i < charArr.length; i++) {
					int digit = Character.getNumericValue(charArr[i]);
					//int digit = Integer.parseInt(String.valueOf(charArr[i]));
					sum += digit;
				}
				System.out.println("The sum of the digits is " + sum);
				break;
			}
			else {
				System.out.println("Invalid input - only 4-digit numbers are allowed.");
				System.out.println("Please try again.\n");
			}
		}
	}
}