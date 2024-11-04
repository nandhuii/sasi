package com.omrbranch;


import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Sample {
	public static void main(String[] args) throws  IOException, ParseException {
		JSONParser json=new JSONParser(); 
Object object = json.parse(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Flight.json"));
		JSONObject jsonObject= (JSONObject)object;
		Object object2 = jsonObject.get("data");
		System.out.println(object2);

		JSONObject jsonObject1= (JSONObject)object2;
		Object object3 = jsonObject1.get("id");
		System.out.println(object3);
		Object object4 = jsonObject1.get("flightName");
		System.out.println(object4);
		Object object5 = jsonObject1.get("Country");
		System.out.println(object5);
		Object object6 = jsonObject1.get("Destinations");
		System.out.println(object6);
		Object object7 = jsonObject1.get("URL");
		System.out.println(object7);
		Object object8 = jsonObject1.get("Created_Date");
		System.out.println(object8);
		Object object9 = jsonObject1.get("Updated_Date");
		System.out.println(object9);

		Object object10 = jsonObject.get("support");
		System.out.println(object10);
		JSONObject jsonsObject2= (JSONObject)object;
		Object object11 = jsonsObject2.get("url");
		System.out.println(object11);
		Object object12 = jsonsObject2.get("text");
		System.out.println(object12);

	}
}
