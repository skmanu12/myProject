package DepthAndDynamicJsonAPIs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import Payload.JsonPayloads;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DynamicJsonAddBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://216.10.245.166";
		given().log().all().header("Content-Type", "application/json").body(JsonPayloads.addBook("isbn","aisle123")).when()
				.post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response();
	}

}
