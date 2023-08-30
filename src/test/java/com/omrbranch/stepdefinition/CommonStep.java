package com.omrbranch.stepdefinition;

import org.junit.Assert;

import io.cucumber.java.en.Then;

public class CommonStep {
	@Then("User Should Verify the status code is {int}")
	public void userShouldVerifyTheStatusCodeIs(int expStatuscode) {
		int actstatuscode = TC1_LoginStep.globalDatas.getStatuscode();
		Assert.assertEquals("Verify statuscode",expStatuscode ,actstatuscode );
	}

}
