package restAssured.HandlingDynamicJson;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import restAssured.Files.Payloads;
import restAssured.Files.ReUsables;

import static io.restassured.RestAssured.*;

public class DynamicJson2 {
@Test(dataProvider="data")
	public void addBookToLibrary(String isbn,int aisle) {
	
	RestAssured.baseURI="http://216.10.245.166/";
		Response resp = given().log().all().header("Content-Type","application/json")
		.body(payloads.addBook(isbn, aisle)).when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response();
		JsonPath js=new JsonPath(resp.asString());
		Assert.assertEquals(js.get("Msg"), "successfully added");
		Assert.assertEquals(js.get("ID"), isbn+aisle);

	}

@DataProvider(name="data")
public Object[][] getData() {
	Object[][] data=new Object[2][2];
	data[0][0]="isbn1";
	data[0][1]=0000;
	data[1][0]="isbn2";
	data[1][1]=3333;
	return data;

}

	

}
