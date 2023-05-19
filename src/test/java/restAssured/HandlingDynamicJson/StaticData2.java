package restAssured.HandlingDynamicJson;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StaticData2 {
	@Test
	public void staticData() throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// Content of the file to string=> Content of the file convert to bytes
		given().log().all().header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\manappa.kalmani\\OneDrive - Qualitest Group\\Manappa\\Courses\\RestAssured\\addPlace.json"))))
		.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().response();
	}
}
