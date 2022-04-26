package com.automation;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
public class Test_001_Test {

	@Test
	public void createBooking() {

		RequestSpecification request = RestAssured.given();
		request.baseUri( "https://restful-booker.herokuapp.com");
		request.header("Content-Type", "application/json");
		String requestBody = "{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
		request.body(requestBody);
	Response response = request.post("/booking");
			
			//System.out.println(response.getStatusCode());
			//System.out.println(response.getStatusLine());
			//System.out.println(response.getBody().prettyPrint());
			Assert.assertEquals(response.getStatusCode(), 200);
			Assert.assertNotNull(response.getStatusLine(), "HTTP/1.1 200 OK");
			Assert.assertNotNull(response.getBody().prettyPrint());
	};

}
