package QAs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HowToValidateResponseForPostAPIs {
	@Test
	public void responseTime() throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// Content of the file to string=> Content of the file convert to bytes
		Response response = given().header("Content-Type", "application/json").log().all()
				.body(new String(Files.readAllBytes(Paths.get(
						"C:\\Users\\manappa.kalmani\\OneDrive - Qualitest Group\\Manappa\\Design\\RestAPIAutomation\\src\\main\\resources\\addPlace.json"))))
				.when().post("/maps/api/place/add/json").then()
				.body("scope", equalTo("APP"), 
						"status", equalTo("OK")).log().all().assertThat().statusCode(200).extract().response();
		//"skills[0", equalTo("Java"),		"skills[1]",equalTo("c"),"company.name", equalTo("Quali")
		
		//Assert with getBody()
		//MatcherAssert.as
		Assert.assertEquals(response.getBody().path("status"), "OK");
		
		//Assert with jsonPath
		JsonPath js=new JsonPath(response.asString());
		js.get("status");
		
		Assert.assertEquals(js.get("status"), "OK");
	}

}
