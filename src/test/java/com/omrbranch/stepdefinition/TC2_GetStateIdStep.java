package com.omrbranch.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.pojo.address.StateData;
import com.omrbranch.pojo.address.StateList_Output_Pojo;
import com.omrbranch.pojo.endpoints.Endpoints;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC2_GetStateIdStep extends BaseClass {
	Response response;
	@Given("User add headers for to StateList")
	public void userAddHeadersForToStateList() {
		addHeader("accept","application/json");
	}
	@When("User send {string} request for StateList endpoint")
	public void userSendRequestForStateListEndpoint(String type) {
	  response = addReqType(type,Endpoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatuscode(statusCode);
	}
	
	@Then("User Should verify the StateList response matches {string} and save stateid")
	public void userShouldVerifyTheStateListResponseMatchesAndSaveStateid(String stateName) {
		 StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class );
		ArrayList<StateData>stateList  = stateList_Output_Pojo.getData();

			for (StateData eachStateList : stateList) {
				String eachStateName = eachStateList.getName();

				if (eachStateName.equals(stateName)) {
					int stateIdNum = eachStateList.getId();
					TC1_LoginStep.globalDatas.setStateIdNum(stateIdNum);
					String stateId = String.valueOf(stateIdNum);
					TC1_LoginStep.globalDatas.setStateIdText(stateId);
					System.out.println(stateIdNum);
					Assert.assertEquals("Verify statid of TN", stateIdNum, 35);
					break;
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
//	ArrayList<StateData> eachStateList = stateList_Output_Pojo .getData();
//	for (StateData eachStateName : eachStateList) {
//		String eachStatename = eachStateName.getName();
//		if (eachStateName.equals(stateName)) {
//			 int stateIdNum = eachStateName.getId();
//			 System.out.println(stateIdNum);
//			 TC1_LoginStep.globalDatas.setStateIdNum(stateIdNum);
//				String stateId = String.valueOf(stateIdNum);
//				TC1_LoginStep.globalDatas.setStateIdText(stateId);
//				System.out.println(stateId);
//				Assert.assertEquals("Verify statid of TN", stateIdNum, 35);
//				break;
//			TC1_LoginStep.globalDatas.setStateIdNum(stateIdNum);
//			 String name = String.valueOf(stateIdNum);
//			 Assert.assertEquals("verify the stateidofTN", 35,name );
//			 break;
			 
			 
			
		 
			
		}
		
	}
		
		
		
	}




}
