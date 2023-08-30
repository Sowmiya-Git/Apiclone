package com.omrbranch.runner;


import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.base.BaseClass;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
@RunWith(Cucumber.class)
@CucumberOptions(tags=("@Login or @State or @City or @Address"),
publish=true,		
snippets=SnippetType.CAMELCASE,
monochrome=true,
plugin= {"pretty","json:target\\index.json"},
stepNotifications=true,
dryRun=false,
glue="com\\omrbranch\\stepdefinition",
features="src\\test\\resources\\Features")
//@CucumberOptions(tags=("@Login"),dryRun=true,features="src\\test\\resources\\Features\\TC1_Login.feature",glue="com\\omrbranch\\stepdefinition")

public class TestRunnerClass extends BaseClass{
	@AfterClass
	public static void afterClass() {
	
		
	}
	
}
	



//("@Login or @State or @City or @Address")
//@SearchProduct"