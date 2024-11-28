package com.omrbranch.AddAddress;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.omrbranch.Login.BaseClass;
import com.omrbranch.Login.Login_Output_Pojo;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class Sample extends BaseClass{
	String stateIdText;
	String logToken;
	int stateIdNum;
	int cityIdNum;
	String stateId;
	String address_id;
	String groceryId;
	@Test(priority=1)
	public void login() {
		addHeader("accept", "application/json");
		addBasicAuth("nandynandy.240799@gmail.com", "Nandhu@123");
		Response reqType = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		int statuscode = getStatusCode(reqType);
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200,"verify Statuscode");
		Login_Output_Pojo login_Output= reqType.as(Login_Output_Pojo.class);
		String first_name = login_Output.getData().getFirst_name();
		System.out.println(first_name);
		logToken = login_Output.getData().getLogtoken();
		Assert.assertEquals(first_name, "Nandhini","verify first name");
	}
	@Test(priority=2)
	public void getStateList() {
		addHeader("accept", "application/json");
		Response type = addReqType("GET", "http://omrbranch.com/api/stateList");
		int code = getStatusCode(type);
		System.out.println(code);
		StateListAndCityList_Output_Pojo as = type.as(StateListAndCityList_Output_Pojo.class);
		ArrayList<Datum> date = as.getData();
		for (Datum eachStateList : date) {
			String name = eachStateList.getName();
			System.out.println("hello");
			if(name.equals("Tamil Nadu")) {
				stateIdNum=eachStateList.getId();
				stateIdText = String.valueOf(stateIdNum);
				System.out.println(stateIdNum);
				break;
			}
		}
	}
	@Test(priority=3)
	public void getCityList() {
		List<Header> listHeader=new ArrayList<>();
		Header h1=new Header ("accept","application/json");
		Header h2=new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		CityList_Input_Pojo cityList=new  CityList_Input_Pojo(stateIdText);
		addBody(cityList);
		Response type = addReqType("POST","https://omrbranch.com/api/cityList");
		int code=getStatusCode(type);
		System.out.println(code);
		StateListAndCityList_Output_Pojo cityListInput = type.as(StateListAndCityList_Output_Pojo.class);
		ArrayList<Datum> cityList1 = cityListInput.getData();
		for(Datum eachCityList:cityList1) {
			String name = eachCityList.getName();
			if(name.equals("Alandur")) {
				cityIdNum = eachCityList.getId();
				System.out.println(cityIdNum);
				break;
			}
		}

	}

	@Test(priority=4)
	public void addUserAddress() {
		List<Header> listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/josn");
		Header h2=new Header("Authorization","Bearer "+logToken);
		Header h3=new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		AddUserAddress_Input_Pojo addUserAddress_Input=new AddUserAddress_Input_Pojo("Nandhini","Anandhi","1234567890","AN",stateIdNum,cityIdNum,100,"600097","Chennai","home");
		addBody(addUserAddress_Input);
		Response reqType = addReqType("POST", "https://omrbranch.com/api/addUserAddress");
		int code = getStatusCode(reqType);
		System.out.println(code);
		AddUserAddress_Output_Pojo userAddress_Output_Pojo = reqType.as(AddUserAddress_Output_Pojo.class);
		String message = userAddress_Output_Pojo.getMessage();
		address_id = userAddress_Output_Pojo.getAddress_id();
		String value = String.valueOf(address_id);
		System.out.println(message);
		Assert.assertEquals(message, "Address added successfully","verify Address added succesfully");
	}
	@Test(priority=5)
	public void updateUserAddress() {
		List<Header> listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/josn");
		Header h2=new Header("Authorization","Bearer "+logToken);
		Header h3=new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		UpdateUserAddress_Input_Pojo updateUser_Input=new UpdateUserAddress_Input_Pojo("95270","Nandhini","Anandhi","1234567890","ANK",stateIdNum,cityIdNum,100,"600098","Chennai","home");
		addBody(updateUser_Input);
		Response reqType = addReqType("PUT", "https://omrbranch.com/api/updateUserAddress");
		int code = getStatusCode(reqType);
		System.out.println(code);
		UpdateUserAddress_Output_Pojo updateUser_Output = reqType.as(UpdateUserAddress_Output_Pojo.class);
		String message = updateUser_Output.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address updated successfully","verify Address added succesfully");
	}	
	@Test(priority=6)
	public void getUserAddress() {
		List<Header> listHeader=new ArrayList<>();
		Header h1=new Header("accept"," application/json");
		Header h2=new Header("Authorization","Bearer "+logToken);
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		Response reqType = addReqType("GET", "https://omrbranch.com/api/getUserAddress");
		int statuscode = getStatusCode(reqType);
		System.out.println(statuscode);
		GetUserAddress_Input_Pojo userAddress = reqType.as(GetUserAddress_Input_Pojo.class);
		String message = userAddress.getMessage();
		Assert.assertEquals(message, "OK", "verify ok msg");
	}
	@Test(priority=7)
	public void getDeleteAddress() {
	List<Header> listHeader=new ArrayList<>();
	Header h1=new Header("accept"," application/json");
	Header h2=new Header("Authorization","Bearer "+logToken);
	Header h3=new Header("Content-Type"," application/json");
	listHeader.add(h1);
	listHeader.add(h2);
	listHeader.add(h3);
	Headers headers=new Headers(listHeader);
	addHeaders(headers);
	DeleteAddress_Input_Pojo del=new DeleteAddress_Input_Pojo(address_id);
	addBody(del);
	Response reqType = addReqType("DELETE", "https://omrbranch.com/api/deleteAddress");
	int statuscode = getStatusCode(reqType);
	System.out.println(statuscode);
	DeleteAddress deleteAddress = reqType.as(DeleteAddress.class);
	String message = deleteAddress.getMessage();
Assert.assertEquals(message, "Address deleted successfully","verify deleted msg");		
	}
	@Test(priority=8)
	public void getSearchProduct() {
		List<Header> listHeader=new ArrayList<>();
		Header h1=new Header("accept"," application/json");
		Header h2=new Header("Content-Type"," application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		SearchProduct_Input_Pojo searchProduct=new SearchProduct_Input_Pojo("nuts");
		addBody(searchProduct);
		Response reqType = addReqType("POST", "https://omrbranch.com/api/searchProduct");
		int statuscode = getStatusCode(reqType);
		System.out.println(statuscode);
		SearchProduct_Output productOutput = reqType.as(SearchProduct_Output.class);
		String message = productOutput.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "OK", "verify ok msg");
	}
	@Test(priority=9)
	public void CartClear() {
		List<Header> listHeader=new ArrayList<>();
		Header h1=new Header("accept"," application/json");
		Header h2=new Header("Authorization","Bearer "+logToken);
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
		Response reqType = addReqType("GET","https://omrbranch.com/api/clearCart");
		int statuscode = getStatusCode(reqType);
		System.out.println(statuscode);
		ClearCart cart = reqType.as(ClearCart.class);
		String message = cart.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Currently Your Cart is empty", "verify msg");
	}
			
	@Test(priority=10)
	public void getCategoryList() {
		addHeader("accept","application/json");
		Response reqType = addReqType("GET","https://omrbranch.com/api/categoryList");
		int statuscode = getStatusCode(reqType);
		System.out.println(statuscode);
		CategoryList_Output_Pojo as = reqType.as(CategoryList_Output_Pojo.class);
		ArrayList<CategoryList_Output> data = as.getData();
		for (CategoryList_Output categoryList_Output : data) {
			String catName = categoryList_Output.getName();
			if(catName.equals("Grocery")) {
				int catId = categoryList_Output.getId();
				groceryId = String.valueOf(catId);
				System.out.println(catId);
				ArrayList<ChildCatList> child_cat_list = categoryList_Output.getChild_cat_list();
				System.out.println(child_cat_list);
					for(ChildCatList childCat: child_cat_list) {
						String name = childCat.getName();
						if(name.equals("Fruit & Nuts")) {
							int i = childCat.getId();
							System.out.println(i);
						}
				}
			}
		}
		}
		@Test(priority=11)
		public void getProductList() {
			List<Header> listHeader=new ArrayList<>();
			Header h1=new Header("accept"," application/json");
			Header h2=new Header("Content-Type","application/json");
			listHeader.add(h1);
			listHeader.add(h2);
			Headers headers=new Headers(listHeader);
			addHeaders(headers);
			ProductList_Input_Pojo productList=new ProductList_Input_Pojo(groceryId,"0");
			addBody(productList);
			Response reqType = addReqType("POST", "https://omrbranch.com/api/productList");
			int statuscode = getStatusCode(reqType);
			System.out.println(statuscode);
			ProductList_Output_Pojo list_Output_Pojo = reqType.as(ProductList_Output_Pojo.class);
			ArrayList<ProductList_Output> data = list_Output_Pojo.getData();
			System.out.println(data);
			for (ProductList_Output productList_Output : data) {
				String name = productList_Output.getName();
				if(name.equals("YUM YUM Daily Needs Dry Fruits Combo Pack")) {
					int g = productList_Output.getId();
					System.out.println(g);
					ArrayList<Variation> variations = productList_Output.getVariations();
					for (Variation listVariation : variations) {
						String specifications = listVariation.getSpecifications();
						if(specifications.equals("500 g")) {
							int k = listVariation.getId();
							System.out.println(k);
						}
					}
				}
				
			}
		}

		
		
		
		
		
		
	
}	
