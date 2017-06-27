package com.javastud.springmvcweb.java8.funcinterface;

/**
 * A new annotation, <code>@FunctionalInterface</code>, has been introduced. It
 * can be placed on an interface to declare the intention of it being a
 * functional interface. It will cause the interface to refuse to compile unless
 * you've managed to make it a functional interface. It's sort of like
 * <code>@Override</code> in this way; it declares intention and doesn't allow
 * you to use it incorrectly.
 * 
 * An extremely valuable property of functional interfaces is that they can be
 * instantiated using lambdas. Here are a few examples of lambdas:
 * 
 * @author ojhay
 *
 */
@FunctionalInterface
public interface Bank {

	/**
	 * Java 8 is that of a "functional interface". An interface is a functional
	 * interface if it defines exactly one abstract method. Ex: Runnable, Bank
	 */
	public abstract String getName(); // "abstract" modifier not necessary

	/**
	 * Default methods are not abstract, so a functional interface can define as
	 * many default methods as it likes.
	 */
	default double getRate() {
		return 1.0;
	}
	
	default double getMaxTransAmout(){
		return 1_00_000.0;
	}

	public static double getDollarExchangeRate() {
		return 105.5;
	}

}
