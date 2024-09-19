package com.rest_config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;

public class Restconfig {

	protected static Properties pro = new Properties();

	public void config() throws IOException {

		File f = new File("src/test/resources/Config_prop/config.properties");

		FileInputStream fi = new FileInputStream(f);

		pro.load(fi);

		fi.close();

	}

	public static String setbaseuri(String BaseURI) {
		
		RestAssured.baseURI = BaseURI;
		
		return pro.getProperty(BaseURI);

	}

}
