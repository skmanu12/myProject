package restAssured.BasicsAPIResponseValidation;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import restAssured.Files.Payloads;
import restAssured.Files.ReUsables;

import static io.restassured.RestAssured.*;

import org.junit.Assert;

public class BasicAddPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response addResponse = given().log().all().header("Content-Type", "application/json")
				.queryParam("key", "qaclick123")
				.body(Payloads.addPlace())
				.when()
				.post("/maps/api/place/add/json")
				.then()
				.body("scope", equalTo("APP"), "status", equalTo("OK"))
				.header("Server", "Apache/2.4.41 (Ubuntu)")
				.log()
				.all()
				.assertThat()
				.statusCode(200)
				.extract()
				.response();
		//addResponse.path("");
		JsonPath js = ReUsables.getJsonPath(addResponse.asString());
		Assert.assertEquals(js.get("status"), "OK");
		Assert.assertEquals(js.get("scope"), "APP");

		// Extract the Place Id
		// Add Place=> Update place with new address=>Get Place to validate if new
		// address is updated

		String place_id = js.getString("place_id");
		System.out.println(place_id);

		// Update Place with new address
		String newAddress = "70 Summer walk, USA";
		Response updatePlace = given().log().all().header("Content-Type", "application/json")
				.queryParam("key", "qaclick123")
				.body("{\r\n" + "\"place_id\":\"" + place_id + "\",\r\n" + "\"address\":\"" + newAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")
				.when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).extract()
				.response();

		JsonPath js1 = ReUsables.getJsonPath(updatePlace.asString());
		Assert.assertEquals(js1.get("msg"), "Address successfully updated");

		// Get add place
		Response getPlace = given().log().all().header("Content-Type", "application/json")
				.queryParam("key", "qaclick123").queryParam("place_id", place_id).when().get("/maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200).extract().response();

		JsonPath js2 = ReUsables.getJsonPath(getPlace.asString());
		Assert.assertEquals(js2.get("address"), newAddress);

	}

}
