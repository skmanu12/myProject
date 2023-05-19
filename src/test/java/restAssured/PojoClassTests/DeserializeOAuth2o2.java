package restAssured.PojoClassTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import restAssured.PojoClasses.API;
import restAssured.PojoClasses.GetCourses;
import restAssured.PojoClasses.WebAutomation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeserializeOAuth2o2 {
	@Test
	public void getCourses() {
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AbUR2VPvQjcEwTS_eXBCpyYID8gp4ZU5ykcL6ACH722fNxWhQLRByzbVxj3pa9LUg3cbLQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String code = url.split("code=")[1].split("&scope")[0];
		System.out.println(code);

		// get access token
		Response resp = given().log().all().urlEncodingEnabled(false).queryParam("code", code)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").then().log().all().assertThat().statusCode(200)
				.extract().response();

		JsonPath js = new JsonPath(resp.asString());
		String token = js.get("access_token");

		getCoursePjoClass courses = given().log().all().queryParam("access_token", token).expect()
				.defaultParser(Parser.JSON).when().get("https://rahulshettyacademy.com/getCourse.php").then().log()
				.all().assertThat().statusCode(200).extract().response().as(getCoursePjoClass.class);

		System.out.println(courses.getInstructor());

//
		List<Api> apicourses = courses.getCourses().getApi();
		for (int i = 0; i < apicourses.size(); i++) {

			if (courses.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				String price = courses.getCourses().getApi().get(i).getPrice();
				String titles = courses.getCourses().getApi().get(i).getCourseTitle();
				System.out.println(titles + ":" + price);
			}

		}
		//
		String[] expectedCourses = { "Selenium Webdriver Java", "Cypress", "Protractor" };
		List<String> expected = Arrays.asList(expectedCourses);
		List<String> a = new ArrayList<String>();
		List<restAssured.PojoClassTests.WebAutomation> webCourses = courses.getCourses().getWebAutomation();
		for (int i = 0; i < webCourses.size(); i++) {
			a.add(webCourses.get(i).getCourseTitle());
		}
		Assert.assertEquals(a, expected);
	}
}
