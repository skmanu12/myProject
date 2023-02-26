package restAssured.SpecBuilder;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restAssured.TestData.TestBuildData;

import static io.restassured.RestAssured.*;

public class SpecBuilder {
	@Test
	public void addPlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		TestBuildData data = new TestBuildData();
		String addPlaceResp = given().header("key", "qaclick123").header("Content-Type", "application/json")
				.body(data.addPlace()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
				.extract().response().asString();
		System.out.println(addPlaceResp);
	}
}
