package tests;

import static io.restassured.RestAssured.*;
 
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;




public class PutPatchAndDelete {
	
	

	@Test (priority=1)
	public void putRequest() {
	
	JSONObject request = new JSONObject();
	
	request.put("name", "Raghav");
	request.put("job", "Teacher");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in";
	
	given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString())
	.when().
		put("/api/users/2").
	then().
		statusCode(200)
		.log().all();
	
	
}


	@Test (priority=2)
	public void patchRequest() {
	
	JSONObject request = new JSONObject();
	
	request.put("name", "Raghav");
	request.put("job", "Teacher");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in";
	
	given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString())
	.when().
		patch("/api/users/2").
	then().
		statusCode(200)
		.log().all();

}
	
	
	@Test (priority=3)
	public void deleteRequest() {
	
	
	baseURI = "https://reqres.in";
	
	 
	when().
		delete("/api/users/2").
	then().
		statusCode(204)
		.log().all();
}
}



