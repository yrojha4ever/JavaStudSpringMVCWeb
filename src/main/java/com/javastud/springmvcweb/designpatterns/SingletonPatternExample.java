package com.javastud.springmvcweb.designpatterns;

public class SingletonPatternExample {
	public static void main(String[] args) {
		Company comp1 = Company.getInstance();
		System.out.println(comp1);

		Company comp2 = Company.getInstance();
		System.out.println(comp2);

		System.out.println(comp1 == comp2);

	}
}
