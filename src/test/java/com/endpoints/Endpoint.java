package com.endpoints;

public class Endpoint {

	public static final String post_resourse = "/api/insert.php";

	public static final String get_resourse = "/api/read.php";

	public static final String put_resourse = "/api/update.php";

	public static final String delete_resourse = "/api/delete.php";
	
	
	public static final String delete_body= "{\r\n"
			+ "\"id\" : \"1111\"\r\n"
			+ "}\r\n"
			+ "";
	

	public static final String post_body = "{\r\n" + "\"title\": \"Project Manager\" ,\r\n"
			+ "\"body\": \"selenium\",\r\n" + "\"author\": \"joshi\"\r\n" + "}\r\n" + "";

	public static final String put_body = "{\r\n" + "        \"id\": \"1123\",\r\n"
			+ "        \"title\": \"Project Manager\",\r\n" + "        \"body\": \"Automation\",\r\n"
			+ "        \"author\": \"joshi\"\r\n" + "    }\r\n" + "";
}
