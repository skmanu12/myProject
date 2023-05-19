package ValidatingAPIResponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import static org.hamcrest.Matchers.*;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
						+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Frontline house\",\r\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n"
						+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
						+ "  \"website\": \"http://google.com\",\r\n" + "  \"language\": \"French-IN\"\r\n" + "}\r\n"
						+ "\r\n" + "")
				.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).header("Server", "Apache/2.4.41 (Ubuntu)").body("status", equalTo("OK"))
				.contentType(ContentType.JSON).extract().response();
		
		Headers headers = response.getHeaders();
		for(Header header:headers) {
			System.out.println("Headers are:"+header.getName()+":"+header.getValue());
			
		}
		Assert.assertEquals(response.getHeader("Server"), "Apache/2.4.41 (Ubuntu)");
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.path("status"),"OK");
		Assert.assertEquals(response.getBody().jsonPath().getString("status"),"OK");
		
		
		

	}

}
