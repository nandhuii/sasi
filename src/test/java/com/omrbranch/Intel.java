package com.omrbranch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Intel {
public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
	ObjectMapper mapper=new ObjectMapper();
	A a = mapper.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Employee.json"), A.class);
int page = a.getPage();
System.out.println(page);
int per_page = a.getPer_page();
System.out.println(per_page);
int total = a.getTotal();
System.out.println(total);
ArrayList<B> dat = a.getData();
System.out.println(dat);
	for (B b : dat) {
		int id = b.getId();
		System.out.println(id);
		String name = b.getFlightName();
		System.out.println(name);
		String country = b.getCountry();
		System.out.println(country);
		String destinations = b.getDestinations();
		System.out.println(destinations);
		String url = b.getURL();
		System.out.println(url);
	}
C support = a.getSupport();
System.out.println(support);
String url = support.getUrl();
System.out.println(url);
String text = support.getText();
System.out.println(text);
}
}
