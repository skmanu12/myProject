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

public class Basics3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Add place
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body("{\r\n"
						+ "  \"location\": {\r\n"
						+ "    \"lat\": -38.383494,\r\n"
						+ "    \"lng\": 33.427362\r\n"
						+ "  },\r\n"
						+ "  \"accuracy\": 50,\r\n"
						+ "  \"name\": \"Frontline house\",\r\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
						+ "  \"types\": [\r\n"
						+ "    \"shoe park\",\r\n"
						+ "    \"shop\"\r\n"
						+ "  ],\r\n"
						+ "  \"website\": \"http://google.com\",\r\n"
						+ "  \"language\": \"French-IN\"\r\n"
						+ "}\r\n"
						+ "")
		.when().post("/maps/api/place/add/json").then().log().all()
		.assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js=new JsonPath(res);
		Assert.assertEquals(js.get("status"), "OK");
		Assert.assertEquals(js.get("scope"), "APP");
		String place_id=js.get("place_id");
		System.out.println(place_id);
		//update place address
		String newAddress="70 Summer walk, USA";
		
		String updateAddress = given().log().all()
				.contentType(ContentType.JSON).queryParam("key", "qaclick123")
		.body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1=new JsonPath(updateAddress);
		Assert.assertEquals(js1.get("msg"), "Address successfully updated");
		
		//get placess
		String getAddress = given().log().all()
		.queryParam("key", "qaclick123").queryParam("place_id", place_id)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js2=new JsonPath(getAddress);
		Assert.assertEquals(js2.get("address"), newAddress);
		
	}

}
