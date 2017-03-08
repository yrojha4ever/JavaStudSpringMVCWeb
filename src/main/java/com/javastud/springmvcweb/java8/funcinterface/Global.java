package com.javastud.springmvcweb.java8.funcinterface;

public class Global implements Bank {

	@Override
	public String getName() {
		return "Global Bank";
	}

	@Override
	public double getRate() {
		return 6.5; // Bank.super.getRate();
	}

	@Override
	public String toString() {
		return "This is global bank child of Functional interface. Rate: " + getRate();
	}

}
