package com.javastud.springmvcweb.designpatterns.factory;

public class FactoryPatterenExample {
	public static void main(String[] args) {
		BankFactory bankFactory = new BankFactory();

		Bank global = bankFactory.getBank(BankType.GLOBAL);
		global.info();

		Bank nabil = bankFactory.getBank(BankType.NABIL);
		nabil.info();
		
		//Best Example: Hibernate SessionFactory
	}
}
