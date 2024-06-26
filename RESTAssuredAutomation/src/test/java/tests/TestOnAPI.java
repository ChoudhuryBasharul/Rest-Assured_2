package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class TestOnAPI {
	
	
	@Test (priority=1)
	public void get() {
		
		baseURI= "http://localhost:3000";
		
		given().get("/users").then().statusCode(200).log().all();		
		
	}
	
	@Test (priority=2)
	public void post() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Thomas");
		request.put("lastName", "Edison");
		request.put("subjectId", 1);
		
		baseURI= "http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201);
		
	}
	
	
	@Test (priority=3) 
	public void put() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Albert");
		request.put("lastName", "Einstein");
		request.put("subjectId", 2);
		
		baseURI= "http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/users/2c71")
		.then()
			.statusCode(200);
		
		
	}

	
	@Test (priority=4)
	public void patch() {
		
		JSONObject request = new JSONObject();
		
		 
		request.put("lastName", "Doe");
	 
		
		baseURI= "http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/users/2c71")
		.then()
			.statusCode(200);
		
		
	}
	
	
	@Test (priority=5)
	public void delete () {
		
		baseURI= "http://localhost:3000";
		
		when().delete("/users/2c71").then().statusCode(200);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

