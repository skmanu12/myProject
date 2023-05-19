package DepthAndDynamicJsonAPIs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Payload.JsonPayloads;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DynamicJsonWithDataProvider {

	@Test(dataProvider="getData")
	public void addBook(String isbn,String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		given().log().all().header("Content-Type", "application/json").body(JsonPayloads.addBook(isbn,aisle)).when()
				.post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response();
	}
	
	@DataProvider(name="getData")
	public Object[][] getData() {
		return new Object[][] {{"isbn1","aisle1"},{"isbn2","aisle2"}};
		/*Object[][] data=new Object[2][2];
		data[0][0]="isbn1";
		data[0][1]="aisle1";
		data[1][0]="isbn2";
		data[1][1]="aisle2";
		
		return data;*/
	}

}
