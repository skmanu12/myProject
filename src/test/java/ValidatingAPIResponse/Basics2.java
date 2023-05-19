package ValidatingAPIResponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import Payload.JsonPayloads;

import static org.hamcrest.Matchers.*;

public class Basics2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(JsonPayloads.addPlace()).when()
				.post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.header("Server", "Apache/2.4.41 (Ubuntu)").body("status", equalTo("OK")).contentType(ContentType.JSON)
				.extract().response();

		Headers headers = response.getHeaders();
		for (Header header : headers) {
			System.out.println("Headers are:" + header.getName() + ":" + header.getValue());

		}
		Assert.assertEquals(response.getHeader("Server"), "Apache/2.4.41 (Ubuntu)");
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.path("status"), "OK");
		Assert.assertEquals(response.getBody().jsonPath().getString("status"), "OK");

		System.out.println(response.asString());

		JsonPath js = new JsonPath(response.asString());
		String placeId = js.getString("place_id");

		System.out.println(js.getString(placeId));

		// Update place
		String expectedAddress = "90 Canada,USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"" + expectedAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")
				.when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated")).extract().response();

		// Get place
		Response getPlace = given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", placeId)
				.when().get("/maps/api/place/get/json").then().log().all().assertThat()
				.body("address", equalTo(expectedAddress)).statusCode(200).extract().response();

	}

}
