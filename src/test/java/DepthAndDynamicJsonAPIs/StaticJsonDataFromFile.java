package DepthAndDynamicJsonAPIs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Payload.JsonPayloads;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StaticJsonDataFromFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(new String(Files.readAllBytes(Paths.get(""))))
				.body(new String(Files.readAllBytes(
						Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\addPlace.json"))))
				.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.header("Server", "Apache/2.4.41 (Ubuntu)").body("status", equalTo("OK")).contentType(ContentType.JSON)
				.extract().response();
	}

}
