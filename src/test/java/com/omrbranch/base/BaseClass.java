package com.omrbranch.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqspec;
	static Response response;
	
	public static String getProjectPath() {
		
		return System.getProperty("user.dir");

	}
	public static String getPopertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		//properties.load(new FileInputStream("C:\Users\R.KIRUTHIGA\eclipse-workspace\OMRBranchGroceryAPIAutomation\src\test\resources\config\config.properties"));
		properties.load(new FileInputStream(getProjectPath()+ "src\\test\\resources\\config\\config.properties"));
		String value=(String)properties.get(key);
		return  value;

	}
	public void addHeader(String key,String value) {
		reqspec= RestAssured.given().header(key,value);

	}
public void addBody(Object body) {
	reqspec.body(body);

}
public void addHeaders(Headers headers) {
	reqspec = RestAssured.given().headers(headers);

}
	public void addBasicAuth(String username,String password) {
		RequestSpecification basic = reqspec.auth().preemptive().basic(username, password);
		

	}
	public void addPathParameter(String key,String value) {
		reqspec= reqspec.pathParam(key, value);
	}
	public void querryParameter(String key,String value) {
		reqspec=reqspec.queryParam(key, value);
	}
	public void addBody(String body) {
	reqspec = reqspec.body(body);

	}
	public Response  addReqType(String type,String endpoint) {
		switch (type) {
		case "GET":
			response=reqspec.get(endpoint);
			break;
		case "POST":
			response=reqspec.post(endpoint);
			break;
		case "PUT":
			response=reqspec.put(endpoint);
			break;
		case "PATCH":
			response=reqspec.patch(endpoint);
			break;
		case "DELETE":
			response=reqspec.delete(endpoint);
			break;

		default:
			break;
		}
		return response;

	}
	public int getStatusCode(Response response) {
       int statusCode = response.getStatusCode();
	return statusCode;
	}
public String getResBodyAsString() {
	String asString = response.asString();
	return asString;

}
public String getResBodyAsPrettyString(Response response) {
	String asPrettyString = response.asPrettyString();
	return asPrettyString;

}
}


