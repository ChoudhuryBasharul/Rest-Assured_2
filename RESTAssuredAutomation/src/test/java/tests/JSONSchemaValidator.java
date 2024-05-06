package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

// https://www.youtube.com/watch?v=rkGI32WXmPQ&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=10

public class JSONSchemaValidator {
	
	
	
	@Test (priority=1)
	public void getRequest() {				
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200).
			body("data[4].first_name", equalTo("George" )).
			body("data.first_name", hasItems("George", "Rachel"));

}
}
