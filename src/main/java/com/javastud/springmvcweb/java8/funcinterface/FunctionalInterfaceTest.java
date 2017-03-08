package com.javastud.springmvcweb.java8.funcinterface;

//https://www.techempower.com/blog/2013/03/26/everything-about-java-8/
public class FunctionalInterfaceTest {
	public static void main(String[] args) {

		// 1. Lambda: Runnable example
		Runnable normalR = new Runnable() {
			@Override
			public void run() {
				System.out.println("I am Normal Old Runnable.");
			}
		};

		Runnable lambdaR = () -> {
			System.out.println("I am New Lambda Runnable.");
		};

		// ==========================

		Bank normalGlobal = new Global();
		System.out.println(normalGlobal);
		System.out.println(normalGlobal.getName() + "\n-----------------");

		Bank annonymousGlobal = new Bank() {
			@Override
			public String getName() {
				return "Name: Annonymous Global Bank.";
			}
		};
		System.out.println(annonymousGlobal);
		System.out.println(annonymousGlobal.getName() + "\n-----------------");

		Bank lambdaGlobal = () -> "Name: Lambda Global Bank. ／人 ◕ ‿‿ ◕ 人＼";
		System.out.println(lambdaGlobal);
		System.out.println(lambdaGlobal.getName() + "\n-----------------");

		// OR for multiline code inside method.
		Bank lambdaGl = () -> {
			return "Name: Lambda Global Bank. ／人 ◕ ‿‿ ◕ 人＼";
		};

	}
}
