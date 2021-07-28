package com.test.restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_requesttcoo2 {
	@Test
	void Registernew() {

		// specify base uri
		RestAssured.baseURI = "https://reqres.in/api/users";

		// request object
		RequestSpecification httpRequest = RestAssured.given();
		// response object
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "leader");
		httpRequest.header("Content-Type","Application/json");
		httpRequest.body(requestParams.toString());
		Response response=httpRequest.request(Method.POST,"?Users");
		// print response in console
		String ResponseBody = response.getBody().asString();
		System.out.println("Response Body " + ResponseBody);
		// status code verify
		int StatusCode = response.getStatusCode();
		System.out.println("status code " + StatusCode);
		Assert.assertEquals(StatusCode, 201);
		// status line verification
		//String Successcode=response.jsonPath().get(Successcode);
		//Assert.assertEquals(Successcode,"OPERATION_SUCCESS");
		response.jsonPath().get("Successcode");
String successcode=response.jsonPath().get("Successcode");
Assert.assertEquals(successcode, 201);
	}
}
