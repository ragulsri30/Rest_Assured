package com.Steps;

import com.endpoints.Endpoint;
import com.helper.Helpers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class StepDefinition extends Endpoint {

	@Given("To setup the base URI")
	public void to_setup_the_base_uri() {
	    RestAssured.baseURI = "https://www.c2ta.co.in";
	}

	@When("To send the post request")
	public void to_send_the_post_request() {
		Helpers.post_request(post_body, post_resourse);
		
	    
	}
	@Then("To validate the post status code")
	public void to_validate_the_post_status_code() {
		Helpers.statuscode_validation(200);
		
	}

	@When("To send the get request")
	public void to_send_the_get_request() {
		
		Helpers.get_request(get_resourse);
		
		Helpers.put_request(put_resourse);
		
		Helpers.get_request(get_resourse);
		
		//Helpers.header_validation();
		
		Helpers.time_validation();
		
		Helpers.getbody(put_body);
		
		Helpers.delete_reslousce(delete_body, delete_resourse);
	    
	}
	
	
	
}
