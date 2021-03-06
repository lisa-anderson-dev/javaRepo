package com.mars.returnship;

import java.util.*;

public class DigitSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Enter a 4-digit number: ");
			String input = sc.next();
			if (input.length() == 4) {
				int sum = 0;
				char[] charArr = input.toCharArray();
				for (char digitChar : charArr) {
				//for (int i = 0; i < charArr.length; i++) {
					//int digit = Character.getNumericValue(charArr[i]);
					//int digit = Integer.parseInt(String.valueOf(charArr[i]));
					int digit = Character.getNumericValue(digitChar);
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
		sc.close();
	}
}