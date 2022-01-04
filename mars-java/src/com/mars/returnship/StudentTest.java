package com.mars.returnship;

import java.util.HashSet;
import java.util.Set;

public class StudentTest {

	public static void main(String[] args) {
		Student stud1 = new Student("John", 01, 'A');
		Student stud2 = new Student("Maria", 02, 'B');
		Student stud3 = new Student("Kevin", 03, 'B');
		Student stud4 = new Student("Kevin", 03, 'B');
		
		/* 
		 * The add() method of Set only adds the specified element e to the set if the set contains no element e2 such that (e==null ? e2==null : e.equals(e2))
		 * The default implementation of equals() performs a shallow comparison and only checks if both object references point to the same memory location.  In this case, stud3 and stud4 reside in two different locations and hence are NOT equal.  
		 * To prevent duplicate elements from getting added to the set, we need equals() to perform to a deep comparison, or a comparison of the object contents
		 * Modifying equals() will necessitate changing hashCode() as well.
		 * */
		
		Set<Student> students = new HashSet<>();
		students.add(stud1);
		students.add(stud2);
		students.add(stud3);
		students.add(stud4);
		
		for (Student stud: students) {
			System.out.println(stud.getName());
		}
		
		// After overriding equals() and hashCode(), both stud3 and stud4 should be equal and have the same hash code
				System.out.println("\nEQUALS? - " + stud3.equals(stud4));		// => TRUE
				System.out.println("SAME HASH? - " + (stud3.hashCode() == stud4.hashCode()));		// => TRUE
	}
}
