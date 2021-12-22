package com.mars.returnship;

import java.util.*;

public class IsAnagram {

	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter two strings or 'q' to exit");
			System.out.print("String 1: ");
			String input1 = sc.nextLine();
			if (input1.equalsIgnoreCase("q")) {
				System.out.println("\nExiting program. Thanks for playing!");
				break;
			}
			System.out.print("String 2: ");
			String input2 = sc.nextLine();
			if (input2.equalsIgnoreCase("q")) {
				System.out.println("\nExiting program. Thanks for playing!");
				break;
			}
			else {
				if (checkAnagram(input1, input2)) {
					System.out.println("The two strings are anagrams.\n");
				}
				else {
					System.out.println("The two strings are NOT anagrams.\n");
				}
			}
		}
	}
	public static boolean checkAnagram(String string1, String string2) {
		String[] string1Arr = string1.toLowerCase().split("");
		String[] string2Arr = string2.toLowerCase().split("");
		Arrays.sort(string1Arr);
		Arrays.sort(string2Arr);
		string1 = String.join("", string1Arr).replaceAll("[^a-z]", "");
		string2 = String.join("", string2Arr).replaceAll("[^a-z]", "");
		return string1.equals(string2);
	}
}
