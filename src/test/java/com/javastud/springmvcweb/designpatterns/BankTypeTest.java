package com.javastud.springmvcweb.designpatterns;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BankTypeTest {
	
	@Test
	public void testBanks(){
		//WARN: It will fail once any new bank are added in BankTypeEnum
		Assert.assertThat(BankType.values().length, CoreMatchers.is(2));
	}
}
