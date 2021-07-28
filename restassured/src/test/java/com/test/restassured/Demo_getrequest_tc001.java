package com.test.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo_getrequest_tc001 {
	@Test
	void getweayherDetails() {
		//specify base uri
		RestAssured.baseURI="https://reqres.in/api/users";
		//request object
		RequestSpecification httpRequest=RestAssured.given();
		//response object
		Response response=httpRequest.request(Method.GET,"?page=2");
		//print response in console
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body " +ResponseBody);
		//status code verify
		int StatusCode=response.getStatusCode();
		System.out.println("status code "+ StatusCode);
		Assert.assertEquals(StatusCode, 200);
		//status line verification
		String statusline=response.statusLine();
		System.out.println("status line is:"+ statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		String Contenttype=response.header("Content-Type");
		System.out.println("Content type is:"+ Contenttype);
		Assert.assertEquals(Contenttype, "application/json; charset=utf-8");
		
		String contentencoding=response.header("Content-Encoding");
		System.out.println("Content header is:"+ contentencoding);
		Assert.assertEquals(contentencoding, "gzip");
	}
	}


