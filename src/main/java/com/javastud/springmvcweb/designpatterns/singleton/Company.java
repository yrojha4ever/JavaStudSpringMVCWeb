package com.javastud.springmvcweb.designpatterns.singleton;

public class Company {

	private static Company instance = new Company();

	private Company() {

	}

	public static Company getInstance() {
		return instance;
	}

	public String getName() {
		return "NGSOFT";
	}

	@Override
	public String toString() {
		return "NGSOFT CORP.";
	}

}
