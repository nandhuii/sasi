package com.omrbranch;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class T extends BaseClass{
Integer id;
	@Test(priority=1)
	public void createFlight() {
		addHeader("content-Type","application/json");
		addBody("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"+ "}");
		Response re = addReqType("POST","https://omrbranch.com/api/flights");
		int status= getStatusCode(re);
		System.out.println(status);
		JsonPath jsonPath = re.jsonPath();
		Object object = jsonPath.get("data.id");
		id=(Integer)object;
		System.out.println(id);
		String asPrettyString = getResBodyAsPrettyString(re);
		System.out.println(asPrettyString);
		
	}
	@Test(priority=2)
	public void singleFlight() {
		addHeader("content-Type","application/json");
		Response type = addReqType("GET","https://omrbranch.com/api/flight/"+id);
		int statusCode = getStatusCode(type);
		System.out.println(statusCode);
		String asPrettyString = getResBodyAsPrettyString(type);
		System.out.println(asPrettyString);
	}
	@Test(priority=3)
	public void update() {
		addHeader("content-Type","application/json");
		addBody("{\r\n"+ "    \"flightName\": \"AirIndia\",\r\n"+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 77,\r\n"+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"+ "}");
		Response reqType = addReqType("PUT","https://omrbranch.com/api/flight/"+id);
		int i = getStatusCode(reqType);
		System.out.println(i);
		String asPrettyString = getResBodyAsPrettyString(reqType);
		System.out.println(asPrettyString);
	}
	@Test(priority=4)
	public void updateFlight() {
		addHeader("content-Type","application/json");
		addBody("{\r\n"+ "    \"Destinations\": 12\r\n"+ "}");
		Response reqType = addReqType("PATCH","https://omrbranch.com/api/flight/"+id);
		int i = getStatusCode(reqType);
		System.out.println(i);
		String asPrettyString = getResBodyAsPrettyString(reqType);
		System.out.println(asPrettyString);
	}

	@Test(priority=6)
	public void delete() {
		addHeader("content-Type","application/json");
		Response reqType = addReqType("DELETE","https://omrbranch.com/api/flight/"+id);
		int i = getStatusCode(reqType);
		System.out.println(i);
		
	}
	@Test(priority=7)
	public void getListFlights() {
		addHeader("content-type","application/json");
		Response response = addReqType("GET","https://omrbranch.com/api/flights?page=1");
		int code = getStatusCode(response);
		System.out.println(code);
		String asPrettyString = getResBodyAsPrettyString(response);
		System.out.println(asPrettyString);
		
	}
}
