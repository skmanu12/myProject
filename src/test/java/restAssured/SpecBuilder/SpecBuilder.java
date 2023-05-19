package restAssured.SpecBuilder;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import restAssured.TestData.TestBuildData;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SpecBuilder {
	@Test
	public void addPlace() throws FileNotFoundException {
		TestBuildData data = new TestBuildData();
		
		FileOutputStream file=new FileOutputStream("log.txt");
		PrintStream log=new PrintStream(file);
		
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com").addHeader("key", "qaclick123")
				.addHeader("Content-Type", "application/json").addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		
		
		ResponseSpecification responseSpecification=new ResponseSpecBuilder()
				.expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		
		RequestSpecification request = given().spec(requestSpecification)
				.body(data.addPlace());
				String response = request.when().post("/maps/api/place/add/json").then().spec(responseSpecification)
						.extract().response().asString();
		System.out.println(response);
	}
}
