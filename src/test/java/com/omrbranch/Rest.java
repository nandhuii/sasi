package com.omrbranch;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest {
public static void main(String[] args) {
	Rest r=new Rest();
	r.createFlight();
	r.updateFlight();
	r.updateFlights();
//	r.deleteFlight();
	r.listFlight();
}
public void createFlight() {
	RequestSpecification reqSpec;
	//1.initilaize the rest assured class
	reqSpec=RestAssured.given();
	//2. pass the header name, body(request body,payload)Authentication
	reqSpec.header("content-Type","application/json");
	//3. payload,request body
	reqSpec.body("{\r\n"
			+ "    \"flightName\": \"AirIndia\",\r\n"+ "    \"Country\": \"India\",\r\n"
			+ "    \"Destinations\": \"87\",\r\n"
			+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"+ "}");
	//4.request type , endpoint
	Response respons = reqSpec.post("https://omrbranch.com/api/flights");
	//status code
	int code = respons.getStatusCode();
	System.out.println(code);
	//res body-asString
	String asString = respons.asString();
	System.out.println(asString);
	//res body-AsPrettyString
	String prettyString = respons.asPrettyString();
	System.out.println(prettyString);
	
}
public void updateFlight() {
	RequestSpecification reqSpec;
	//1.initilaize the rest assured class
		reqSpec=RestAssured.given();
		//2. pass the header name, body(request body,payload)Authentication
		reqSpec.header("content-Type","application/json");
		//3. payload,request body
	reqSpec.body("{\r\n"
			+ "    \"flightName\": \"AirIndia\",\r\n"+ "    \"Country\": \"India\",\r\n"
			+ "    \"Destinations\": 75,\r\n"+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"+ "}");
	//4.request type , endpoint
		Response respons = reqSpec.put("https://omrbranch.com/api/flight/34548");
		//status code
		int code = respons.getStatusCode();
		System.out.println(code);
		//res body-asString
		String asString = respons.asString();
		System.out.println(asString);
		//res body-AsPrettyString
		String prettyString = respons.asPrettyString();
		System.out.println(prettyString);
	
}

public void updateFlights() {
	RequestSpecification reqSpec;
	//1.initilaize the rest assured class
		reqSpec=RestAssured.given();
		//2. pass the header name, body(request body,payload)Authentication
		reqSpec.header("content-Type","application/json");
		//3. payload,request body
	reqSpec.body("{\r\n"+ "    \"Destinations\": 52\r\n"+ "}");
	//4.request type , endpoint
		Response respons = reqSpec.patch("https://omrbranch.com/api/flight/34548");
		//status code
		int code = respons.getStatusCode();
		System.out.println(code);
		//res body-asString
		String asString = respons.asString();
		System.out.println(asString);
		//res body-AsPrettyString
		String prettyString = respons.asPrettyString();
		System.out.println(prettyString);
}
public void singleFlight() {
	RequestSpecification reqSpec;
	//1.initilaize the rest assured class
			reqSpec=RestAssured.given();
			//2. pass the header name, body(request body,payload)Authentication
			reqSpec.header("content-Type","application/json");
		//3request type , endpoint
			Response respons = reqSpec.get("https://omrbranch.com/api/flight/34548");
			//status code
			int code = respons.getStatusCode();
			System.out.println(code);
			//res body-asString
			String asString = respons.asString();
			System.out.println(asString);
			//res body-AsPrettyString
			String prettyString = respons.asPrettyString();
			System.out.println(prettyString);
		
}
public void deleteFlight() {
	RequestSpecification reqSpec;
	//1.initilaize the rest assured class
		reqSpec=RestAssured.given();
		//2. pass the header name, body(request body,payload)Authentication
		reqSpec.header("content-Type","application/json");
	//3.request type , endpoint
		Response respons = reqSpec.delete("https://omrbranch.com/api/flight/34548");
		//status code
		int code = respons.getStatusCode();
		System.out.println(code);
		//res body-asString
		String asString = respons.asString();
		System.out.println(asString);
		//res body-AsPrettyString
		String prettyString = respons.asPrettyString();
		System.out.println(prettyString);
	
}
public void listFlight() {
	RequestSpecification reqSpec;
	//1.initilaize the rest assured class
		reqSpec=RestAssured.given();
		//2. pass the header name, body(request body,payload)Authentication
		reqSpec.header("content-Type","application/json");
	//3.request type , endpoint
		Response respons = reqSpec.get("https://omrbranch.com/api/flights?page=1");
		//status code
		int code = respons.getStatusCode();
		System.out.println(code);
		//res body-asString
		String asString = respons.asString();
		System.out.println(asString);
		//res body-AsPrettyString
		String prettyString = respons.asPrettyString();
		System.out.println(prettyString);
	
}
}
