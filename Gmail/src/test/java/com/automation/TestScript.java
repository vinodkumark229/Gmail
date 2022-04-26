package com.automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestScript {
	public static void main(String[] args) {
		
	
RequestSpecification request = RestAssured.given();
request.baseUri("https://restful-booker.herokuapp.com/booking");
Response response = request.get();
System.out.println(response.statusCode());
System.out.println(response.statusLine());
System.out.println(response.getBody().asPrettyString());
	}
}
