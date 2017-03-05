package com.javastud.springmvcweb.designpatterns;

public class BankFactory {
	public Bank getBank(BankType bankType) {

		if (bankType == null) {
			return null;
		}

		if (bankType == BankType.GLOBAL) {
			return new Global();
		} else if (bankType == BankType.NABIL) {
			return new Nabil();
		}

		return null;
	}
}
