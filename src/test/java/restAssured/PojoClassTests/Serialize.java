package restAssured.PojoClassTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import restAssured.TestData.TestBuildData;

import static io.restassured.RestAssured.*;

public class Serialize {
	@Test
	public void addPlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		TestBuildData data = new TestBuildData();
		RequestSpecification requestSpecifications = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com").addHeader("key", "qaclick123")
				.addHeader("Content-Type", "application/json").build();

		RequestSpecification addPlaceReq = given().spec(requestSpecifications).body(data.addPlace());

		ResponseSpecification respnseSpecifications = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				.expectStatusCode(200).build();

		Response addPlaceResponse = addPlaceReq.when().post("/maps/api/place/add/json").then()
				.spec(respnseSpecifications).extract().response();
		System.out.println(addPlaceResponse.asString());
	}
}
