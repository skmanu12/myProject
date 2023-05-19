package restAssured.OAuth20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetCoursesOAuth2o2 {
	@Test
	public void getCourses() {
	

		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AbUR2VMfxYYwZw0rRLZ9jEyz795ZMJaLdO49pXVDulTdIwCc5IlPzbfwrkCgMwf9f_4F3Q&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String code=url.split("code=")[1].split("&scope")[0];
		System.out.println(code);

		//get access token
		Response resp = given().log().all().urlEncodingEnabled(false)
		.queryParam("code", code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type", "authorization_code")
		.when().post("https://www.googleapis.com/oauth2/v4/token")
		.then().log().all().assertThat().statusCode(200).extract().response();
		
		JsonPath js=new JsonPath(resp.asString());
		String token = js.get("access_token");
		
		given().log().all().queryParam("access_token",token)
		.when().get("https://rahulshettyacademy.com/getCourse.php")
		.then().log().all().assertThat().statusCode(200).extract().response();
		
		

	}
}
