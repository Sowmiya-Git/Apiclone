package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.payload.address.AddressPayload;
import com.omrbranch.pojo.address.DeleteUserAddress_Output_Pojo;
import com.omrbranch.pojo.address.GetUserAddress_Output_Pojo;
import com.omrbranch.pojo.address.UpdateUserAddress_Output_Pojo;
import com.omrbranch.pojo.address.UserAddAddress_Output_Pojo;
import com.omrbranch.pojo.endpoints.Endpoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {
	static AddressPayload addressPayload=new AddressPayload(); 
	Response response;
	
	

	@Given("User add header and bearer authorization for accessing address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Content-Type", "application/json");
		Header h3=new Header("Authorization","Bearer "+TC1_LoginStep.globalDatas.getLogtoken());
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		
	}
	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String firstName, String LastName, String mobile, String apartment,String stateId ,
			String cityId, String country, String zipcode, String address, String addressaType) {
	addBody(addressPayload.createAddress(firstName, LastName, mobile, apartment,TC1_LoginStep.globalDatas.getStateIdNum(),TC1_LoginStep.globalDatas.getCityIdNum(), Integer.parseInt(country), zipcode, address, addressaType));

//	 | firstName | | mobile     | apartment | stateId | cityId | country | zipCode | address | addressaType |
	}
	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String type) {
		 response = addReqType(type, Endpoints.ADDUSERADDRESS);
		 int statusCode = getStatusCode(response);
	     TC1_LoginStep.globalDatas.setStatuscode(statusCode);
	}
	@Then("User Should verify the addUserAddress response message matches {string}")
	public void userShouldVerifyTheAddUserAddressResponseMessageMatches(String expAddressMsg) {
		UserAddAddress_Output_Pojo userAddAddress_Output_Pojo = response.as(UserAddAddress_Output_Pojo.class);
		String message = userAddAddress_Output_Pojo.getMessage();
		System.out.println(message);
		int address_id = userAddAddress_Output_Pojo.getAddress_id();
	
		
		System.out.println(address_id);
		String addressid = String.valueOf(address_id);
		TC1_LoginStep.globalDatas.setAdressid(addressid);
		Assert.assertEquals("verify message", message,expAddressMsg);
		//Assert.assertEquals("Address added successfully", expAddressMsg, message);
		
		
		
	}


	@When("User add request body for add new address {string} {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String address_id, String firstName, String LastName, String mobile, String apartment,String stateId ,
			String cityId, String country, String zipcode, String address, String addressaType) {
		addBody(addressPayload.updateAddress(TC1_LoginStep.globalDatas.getAdressid(), firstName, LastName, mobile, apartment,TC1_LoginStep.globalDatas.getStateIdNum(),TC1_LoginStep.globalDatas.getCityIdNum(), Integer.parseInt(country), zipcode, address, addressaType));
	
	
	}
	@When("User send {string} request for updateUserAddress endpoint")
	public void userSendRequestForUpdateUserAddressEndpoint(String type) {
		 response = addReqType(type, Endpoints.UPDATEUSERADDRESS);
		 int statusCode = response.getStatusCode();
			TC1_LoginStep.globalDatas.setStatuscode(statusCode);
	}
	@Then("User Should verify the updateUserAddress response message matches {string}")
	public void userShouldVerifyTheUpdateUserAddressResponseMessageMatches(String expudateadress) {
		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String messages = updateUserAddress_Output_Pojo.getMessage();
		System.out.println(messages);
		Assert.assertEquals("verify message", messages,expudateadress);

		//Assert.assertEquals("Verify message", message,expudateadress );
		
	}


	@When("User send {string} request for getUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String type) {
		 response = addReqType(type,Endpoints.GETUSERADDRESS);
		 int statusCode = getStatusCode(response);
		 System.out.println(statusCode );
		 TC1_LoginStep.globalDatas.setStatuscode(statusCode);
		
	}
	@Then("User Should verify the getUserAddress response message matches {string}")
	public void userShouldVerifyTheGetUserAddressResponseMessageMatches(String expgetadress) {
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String message = getUserAddress_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals("Verify the Ok message", expgetadress, message);
		
	}


	@When("User add request body {string} for get deleteUseraddress")
	public void userAddRequestBodyForGetDeleteUseraddress(String stateid) {
		addBody(addressPayload.deleteAddress(TC1_LoginStep.globalDatas.getAdressid()));
	}

	
	@When("User send {string} request for deleteUserAddress endpoint")
	public void userSendRequestForDeleteUserAddressEndpoint(String type) {
		
		 response = addReqType(type,Endpoints.DELETEADDDRESS);
		 int statusCode = getStatusCode(response);
		 System.out.println(statusCode );
		 TC1_LoginStep.globalDatas.setStatuscode(statusCode);
	}
	@Then("User Should verify the deleteUserAddress response message matches {string}")
	public void userShouldVerifyTheDeleteUserAddressResponseMessageMatches(String expdelmsg) {
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		 String message = deleteUserAddress_Output_Pojo .getMessage();
		 Assert.assertEquals("Verify Address updated successfully", expdelmsg, message);
		
		
		
		
		
	}






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Given("User add header and bearer authorization for accessing address endpoints")
//	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpoints() {
//		List<Header>listHeader=new ArrayList<>();
//		Header h1=new Header("accept", "application/json");
//		Header h2=new Header("Content-Type", "application/json");
//		Header h3=new Header("Authorization","Bearer "+TC1_LoginStep.globalDatas.getLogtoken());
//		listHeader.add(h1);
//		listHeader.add(h2);
//		listHeader.add(h3);
//		Headers headers=new Headers(listHeader);
//		addHeaders(headers);
//		
//		
//		
//		
//		
//	}
//	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
//	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name , String mobile , String apartment, String state, String city, String country, String zipcode, String address, String address_type) {
//	addBody(addressPayload.createAddress(first_name, last_name, mobile, apartment,TC1_LoginStep.globalDatas.getCityIdNum(),TC1_LoginStep.globalDatas.getCityIdNum(), country, zipcode, address, address_type));
//		
//	}
//	@When("User send {string} request for addUserAddress endpoint")
//	public void userSendRequestForAddUserAddressEndpoint(String type) {
//		addReqType(type, Endpoints.)
//		
//	}
//	@Then("User Should verify the addUserAddress response message matches {string}")
//	public void userShouldVerifyTheAddUserAddressResponseMessageMatches(String string) {
//	}
//
//	@When("User add request body for add new address {string} {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
//	public void userAddRequestBodyForAddNewAddressAnd(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) {
//	}
//	@Then("User Should verify the updateUserAddress response message matches {string}")
//	public void userShouldVerifyTheUpdateUserAddressResponseMessageMatches(String string) {
//	}
//
//	@Then("User Should verify the getUserAddress response message matches {string}")
//	public void userShouldVerifyTheGetUserAddressResponseMessageMatches(String string) {
//	}
//
//	@When("User add request body addressid for get deleteUseraddress")
//	public void userAddRequestBodyAddressidForGetDeleteUseraddress() {
//	}
//	@Then("User Should verify the deleteUserAddress response message matches {string}")
//	public void userShouldVerifyTheDeleteUserAddressResponseMessageMatches(String string) {
//	}












}
