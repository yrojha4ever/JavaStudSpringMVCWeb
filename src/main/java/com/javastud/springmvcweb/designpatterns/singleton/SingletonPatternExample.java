package com.javastud.springmvcweb.designpatterns.singleton;

import java.io.IOException;

public class SingletonPatternExample {
	public static void main(String[] args) {
		Company comp1 = Company.getInstance();
		System.out.println(comp1);

		Company comp2 = Company.getInstance();
		System.out.println(comp2);

		System.out.println(comp1 == comp2);
		
		// best Example : open calc(Runtime)
		try {
			Runtime r = Runtime.getRuntime();
			r.exec("calc");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
