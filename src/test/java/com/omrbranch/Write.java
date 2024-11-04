package com.omrbranch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Write {
public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
	ObjectMapper mapper=new ObjectMapper();
	ArrayList<B> c=new ArrayList<B>();
	B e1=new B(3,"AirIndia","India","28","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
B e2=new B(33,"AirIndia","India","20","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
B e3=new B(36,"AirIndia","India","71","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
B e4=new B(42,"AirIndia","India","98","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
B e5=new B(49,"AirIndia","India","88","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
B e6=new B(59,"AirIndia","India","87","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
c.add(e1);
c.add(e2);
c.add(e3);
c.add(e4);
c.add(e5);
c.add(e6);

C f=new C("https:\\/\\/omrbranch.com","For Joining Automation Course, Please Contact-Velmurugan 9944152058");
A a=new A(1,6,9118,1520,c,f);
mapper.writeValue(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Details.json"),a );

}

}
