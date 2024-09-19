package com.model;

public class Models {
	
	private static String title="";
	
	private static String body="";
	
	private static String author="";

	public static String getTitle() {
		return title;
	}

	public static String getBody() {
		return body;
	}

	public static String getAuthor() {
		return author;
	}

	public static void setTitle(String title) {
		Models.title = title;
	}

	public static void setBody(String body) {
		Models.body = body;
	}

	public static void setAuthor(String author) {
		Models.author = author;
	}

}
