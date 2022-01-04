package com.mars.returnship;

import java.util.Objects;

public class Student {
	private String name;
	private int rollNo;
	private char grade;
	
	public Student(String name, int rollNo, char grade) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	// You must override hashCode() in every class that overrides equals()
	@Override
	public int hashCode() {
		return Objects.hash(grade, name, rollNo);
	}

	// Override of equals() to perform a deep comparison
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		// For any reference value a, a.equals(a) should return true
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		
		Student other = (Student) obj;
		
		// Comparison of each of the object fields
		return grade == other.grade && Objects.equals(name, other.name) && rollNo == other.rollNo;
	}
}
