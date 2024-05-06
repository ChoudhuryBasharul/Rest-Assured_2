package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;;

public class SOAPXMLRequest {
	
	
	
	@Test (priority=1)
	public void validateSOAPXML() throws IOException {
		
		
		File file = new File("./SOAPRequest/Add.xml");
		
		if (file.exists())
			System.out.println(" >> File exist");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
	 

		baseURI =  "http://www.dneonline.com" ;
		
		given().
			contentType("text/xml"). 
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("/calculator.asmx").
		then().
			statusCode(200).log().all().
		and ().
			body("//*:AddResult.text()", equalTo("5"));
		
	 
		
				
		
	}
 
		
	}


