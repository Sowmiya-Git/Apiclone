package com.omrbranch.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.globaldata.GlobalDatas;
import com.omrbranch.pojo.endpoints.Endpoints;
import com.omrbranch.pojo.login.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass {
	Response response;
	static GlobalDatas globalDatas=new GlobalDatas();

	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept", "application/json");
	}
	@When("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		addBasicAuth("sowmiyaec2015@gmail.com", "Sowmi@1999");
		//addBasicAuth(getPopertyFileValue("username"),getPopertyFileValue("password") );
	}
	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String type) {
	  response = addReqType(type,Endpoints.POSTMANBASICAUTHLOGIN);
	  int statusCode = getStatusCode(response);
	  globalDatas.setStatuscode(statusCode);
	}
	@Then("User Should verify the login response body firstName present as {string} and get the logtoken")
	public void userShouldVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtoken(String expFirstName) {
		
       Login login = response.as(Login.class);
		String first_name = login.getData().getFirst_name();
		String logtoken = login.getData().getLogtoken();
		TC1_LoginStep.globalDatas.setLogtoken(logtoken);
		Assert.assertEquals("verify the firstName",expFirstName , first_name);
		
		
	}




}
