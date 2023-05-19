package HandleOAuth20;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import restAssured.PojoClasses.copy.TestData;

import static io.restassured.RestAssured.*;

public class AddPlaceData {
	@Test(dataProvider = "getData")
	public void addPlaceValidation(double lat, double lng, int accuracy, String name, String phone_number,
			String address, String types1, String types2, String website, String language) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().contentType(ContentType.JSON)
				.body(TestData.addPlace(lat, lng, accuracy, name, phone_number, address, types1, types2, website,
						language))
				.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract()
				.response();
	}

	@DataProvider(name = "getData")
	public Object[][] getData() {
		Object[][] data = new Object[1][10];
		data[0][0] = -38.383494;
		data[0][1] = 33.427362;
		data[0][2] = 50;
		data[0][3] = "Frontline house";
		data[0][4] = "(+91) 983 893 3937";
		data[0][5] = "29, side layout, cohen 09";
		data[0][6] = "shoe park";
		data[0][7] = "shop";
		data[0][8] = "http://google.com";
		data[0][9] = "French-IN";
		return data;
	}

}
