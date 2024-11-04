package com.omrbranch;


import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class samp {
public static void main(String[] args) throws  IOException, ParseException {
	JSONParser json=new JSONParser();
	Object object = json.parse(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Employee.json"));
JSONObject jsonObject=(JSONObject)object;
Object object2 = jsonObject.get("page");
System.out.println(object2);
Object obj = jsonObject.get("per_page");
System.out.println(obj);
Object obj1 = jsonObject.get("total");
System.out.println(obj1);
Object ob = jsonObject.get("total_pages");
System.out.println(ob);
Object obje = jsonObject.get("data");
System.out.println(obje);
JSONArray array=(JSONArray)obje;
for(int i=0;i<array.size();i++) {
	Object object3 = array.get(i);
	System.out.println(object3);
	JSONObject jsons=(JSONObject)object3;
	Object t = jsons.get("id");
	System.out.println(t);
	Object l = jsons.get("flightName");
	System.out.println(l);
	Object oj = jsons.get("Country");
	System.out.println(oj);
	Object j = jsons.get("Destinations");
	System.out.println(j);
	Object c = jsons.get("URL");
	System.out.println(c);
}
Object object4 = jsonObject.get("support");
System.out.println(object4);
JSONObject jso=(JSONObject)object4;
Object object5 = jso.get("url");
System.out.println(object5);
Object object6 = jso.get("text");
System.out.println(object6);










}
}
