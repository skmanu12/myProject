package QAs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderCookiesContentTpe {
@Test
public void getHeaders() throws IOException {
	Response response = given().header("Content-Type", "application/json").log().all()
			.body(new String(Files.readAllBytes(Paths.get(
					"C:\\Users\\manappa.kalmani\\OneDrive - Qualitest Group\\Manappa\\Design\\RestAPIAutomation\\src\\main\\resources\\addPlace.json"))))
			.when().post("/maps/api/place/add/json").then()
			.body("scope", equalTo("APP"), 
					"status", equalTo("OK")).log().all()
			.assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
	Headers header = response.getHeaders();
	System.out.println(response.getHeader("status"));
	System.out.println(response.getHeader("scope"));
	System.out.println(response.header("Content-Type"));
	System.out.println(response.getCookies());
	System.out.println(response.getContentType());
	
	System.out.println("APIs");
	Headers header2 = response.headers();
}
}
