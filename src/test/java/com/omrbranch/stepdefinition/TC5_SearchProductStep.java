 package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.Product.Pojo.SearchProduct_Output_Pojo;
import com.omrbranch.base.BaseClass;

import com.omrbranch.payload.product.ProductPayload;
import com.omrbranch.pojo.endpoints.Endpoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_SearchProductStep extends BaseClass{
	 Response response ;
	 static ProductPayload productPayload=new ProductPayload();

	@Given("User add headers for to SearchProduct")
	public void userAddHeadersForToSearchProduct() {
		
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		
		
		
	}
	@When("User add request body {string} for get SearchProduct")
	public void userAddRequestBodyTextForGetSearchProduct(String text) {
		addBody(productPayload.searchProduct("nuts"));
		
		
	}
	@When("User send {string} request for SearchProduct endpoint")
	public void userSendRequestForSearchProductEndpoint(String type) {
		  response = addReqType(type, Endpoints.SEARCHPRODUCT);
		 int statusCode = getStatusCode(response);
		 TC1_LoginStep.globalDatas.setStatuscode(statusCode);
	}
		
		
		
	
	@Then("User Should Verify the SearchProduct response message matches {string}")
	public void userShouldVerifyTheSearchProductResponseMessageMatches(String expsearch) {
		 SearchProduct_Output_Pojo as = response.as(SearchProduct_Output_Pojo.class);
		String message = as.getMessage();
		System.out.println(message);
		Assert.assertEquals("Verify the OK message",expsearch,message);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	



}
