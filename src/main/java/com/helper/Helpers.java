package com.helper;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;

import com.model.Models;
import com.mongodb.util.JSON;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Helpers  extends Models{
	
	public static RestAssured api;
	
	public static Response res;

	
	public static void post_request(String post_body , String post_resource) {
		RequestSpecification all = api.given().contentType(ContentType.JSON).body(post_body).log().all();
		
		
		 res = all.post(post_resource);

	}
	
	public static void get_request(String get_request) {
  res= api.get(get_request);
  
  List as = res.getBody().as(List.class);
  
  Object object = as.get(as.size()-1);
  
  System.out.println("************** " + object);
	}
	
	public static void put_request(String put_resource) {
		
		setTitle("Tester");
		
		setBody("API");
		
		setAuthor("Kishore");
		
		
		List<Object>as = res.getBody().as(List.class);
		
		Map<String, Object>  m = (Map<String, Object>) as.get(as.size() -1);
		m.replace("title", getTitle());
		m.replace("body", getBody());
		m.replace("author", getAuthor());
		
		Set<Entry<String, Object>> entrySet = m.entrySet();
		
		JSONObject j = new JSONObject();
		
		String str = j.toJSONString();
		
		j.putAll(m);
		RequestSpecification r = api.given().contentType(ContentType.JSON).body(str).log().all();
		
		r.put("\n" + put_resource);
		
	}
	
	public static void header_validation() {
		
	List<Header> asList = res.getHeaders().asList();
	for (int i = 0; i < asList.size(); i++) {
		System.out.println(asList.get(i));
		
	}

	}
	
	public static void time_validation() {
		
		long timeIn = res.timeIn(TimeUnit.MILLISECONDS);
		System.out.println(timeIn);

	}
	
	public static void getbody(String response_body) {

		
		String s = res.getBody().prettyPrint();
		
	 System.out.println("@@@@@@@@@ " + s);
	}

	
	
	public static void statuscode_validation(int status_code) {
		ValidatableResponse all = res.then().statusCode(status_code).log().all();

		
		//ValidatableResponse statusCode = all.statusCode(200);
		
		//System.out.println("$$$$$$$$$$$ " + status_code);
		
		//System.out.println("######### " + all);
	}
	
	public static void delete_reslousce(String del_body,String del_resource) {
		
		
		
		RequestSpecification del = api.given().contentType(ContentType.JSON).body(del_body).log().all();
		
		Response delete = del.delete(del_resource);
		
		System.out.println(delete.prettyPrint());
	}
	
	public static void loger() {
		

	}
	
	
	
	
	
	
	
	
	
	
	
}
