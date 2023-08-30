package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.payload.address.AddressPayload;
import com.omrbranch.pojo.address.CityListData;
import com.omrbranch.pojo.address.CityList_Output_Pojo;
import com.omrbranch.pojo.endpoints.Endpoints;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;




public class TC3_GetCityIdStep extends BaseClass{
	static AddressPayload  addresspayload=new AddressPayload();
	Response response;
	
	@Given("User add headers for to CityList")
	public void userAddHeadersForToCityList() {
		List<Header>lstHeader=new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers=new Headers(lstHeader);
		addHeaders(headers);
	}
	@When("User add request body stateid for get CityList")
	public void userAddRequestBodyStateidForGetCityList() {
	   addBody(addresspayload.cityList(TC1_LoginStep.globalDatas.getStateIdText()));
	}
	@When("User send {string} request for CityList endpoint")
	public void userSendRequestForCityListEndpoint(String type) {
		 response = addReqType(type, Endpoints.CITYLIST);
		 int statusCode = getStatusCode(response);
		 TC1_LoginStep.globalDatas.setStatuscode(statusCode);
	}
	

	@Then("User Should verify the CityList response message matches {string} and save cityid")
	public void userShouldVerifyTheCityListResponseMessageMatchesAndSaveCityid(String cityName) {
		
		
		
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<CityListData> cityList = cityList_Output_Pojo .getData();
		for (CityListData eachCityList : cityList) {
			String eachcityName = eachCityList.getName();
			if (eachcityName.equals(cityName)) {
				int cityid = eachCityList.getId();
				TC1_LoginStep.globalDatas.setCityIdNum(cityid);
				String cityId = String.valueOf(cityid);
				System.out.println(cityid);
				Assert.assertEquals("Verify the cityid of 3 yercaud", cityid,4440);
	}



//	public void userShouldVerifyTheCityListResponseMatchesAndSaveCityid(String cityName) {
//		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
//		ArrayList<CityListData> cityList = cityList_Output_Pojo .getData();
//		for (CityListData eachCityList : cityList) {
//			String eachcityName = eachCityList.getName();
//			if (eachcityName.equals(cityName)) {
//				int cityid = eachCityList.getId();
//				TC1_LoginStep.globalDatas.setCityIdNum(cityid);
//				System.out.println(cityid);
//				Assert.assertEquals("Verify the cityid of 3 yercaud", cityid,4440);
	}



		}
	}

		























//	@Given("User add headers for to CityList")
//	public void userAddHeadersForToCityList() {
//		List<Header>lstHeader=new ArrayList<>();
//		Header h1=new Header("accept", "application/json");
//		Header h2=new Header("Content-Type", "application/json");
//		lstHeader.add(h1);
//		lstHeader.add(h2);
//		Headers headers=new Headers(lstHeader);
//		addHeaders(headers);
//	}
//	@When("User add request body stateid for get CityList")
//	public void userAddRequestBodyStateidForGetCityList() {
//		addBody(adresspayload.cityList(TC1_LoginStep.globalDatas.getStateIdText()));
//		//addBody(adresspayload.cityList(TC1_LoginStep.globalDatas.getStateIdText()));
//		
//	}
//	@When("User send {string} request for CityList endpoint")
//	public void userSendRequestForCityListEndpoint(String type) {
//		//response = addReqType(type, "https://omrbranch.com/api/cityList");
//	 response = addReqType(type, Endpoints.CITYLIST);
//		 int statusCode = getStatusCode(response);
//		 TC1_LoginStep.globalDatas.setStatuscode(statusCode);
//		 
//		
//	}
//	@Then("User Should Verify the CityList response matches {string} and save cityid")
//	public void userShouldVerifyTheCityListResponseMatchesAndSaveCityid(String cityName) {
//		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
//		ArrayList<CityListData> cityList = cityList_Output_Pojo .getData();
//		
//		
//		
//		for (CityListData eachCityList : cityList) {
//			String eachcityName = eachCityList.getName();
//			if (eachcityName.equals(cityName)) {
//				int cityid = eachCityList.getId();
//				TC1_LoginStep.globalDatas.setCityIdNum(cityid);
//				System.out.println(cityid);
//				Assert.assertEquals("Verify the cityid of 3 yercaud", 4440,cityid);
//				
//		}
//		
//			
//		}
//	}
//	
	



	


