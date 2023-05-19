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

public class DynamicJson {
	@Test(dataProvider = "getData")
	public void addBookToLibrary(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		Response addBookResponse = given().header("Content-Type", "application/json")
				.body(Payloads.addBook(isbn, aisle)).log().all().when()
				.post("/Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).extract().response();
		JsonPath js1=new JsonPath(addBookResponse.asString());
		//JsonPath js1 = ReUsables.getJsonPath(addBookResponse.asString());
		Assert.assertEquals(js1.get("Msg"), "successfully added");
		System.out.println(js1.get("ID"));
		System.out.println(js1.get("ID"));
		

	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "isbn", "1234" }, { "isbn1", "3214" } };
	}
	@DataProvider
	public Object[][] getData1() {
		return new Object[][] {{"isbn1","12334"},{"isbn2","4321"}};
	}

}
