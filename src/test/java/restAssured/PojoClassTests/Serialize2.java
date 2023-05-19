package restAssured.PojoClassTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import restAssured.TestData.TestBuildData;

import static io.restassured.RestAssured.*;

public class Serialize2 {
	@Test
	public void addPlace() {
		SerializationData data = new SerializationData();
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com").addHeader("Content-Type", "application/json")
				.addHeader("key", "qaclick123").setUrlEncodingEnabled(false).setRelaxedHTTPSValidation().build();

		ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();

		Response req = given().log().all().spec(requestSpecification).body(data.addPlace()).when()
				.post("/maps/api/place/add/json").then().log().all().spec(responseSpecification).extract().response();

	}
}
