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

public class DeserializeOAuth2o {
	@Test
	public void getCourses() {
		// Get Code
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\manappa.kalmani\\OneDrive - Qualitest Group\\Manappa\\Design\\Jars\\chromedriver_win32\\chromedriver.exe"
		 * ); WebDriver driver=new ChromeDriver(); driver.get(
		 * "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verify"
		 * ); String url=driver.getCurrentUrl(); System.out.println(url);
		 */
		String[] courseList= {"Selenium Webdriver Java","Cypress","Protractor"};

		String url = "https://rahulshettyacademy.com/getCourse.php?state=verify&code=4%2F0AWtgzh6WoS2HQZVhoBBDRiBstFzJgTQzGccnSnKmbbKTMfUG9Ffnk7KU-FH88lPIQAcxtA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";

		String code = url.split("code=")[1].split("&scope")[0].trim();
		System.out.println(code);
		// Get Access Token
		Response accessTokenResp = given().urlEncodingEnabled(false).log().all().queryParam("code", code)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").then().log().all().assertThat().statusCode(200)
				.extract().response();
		JsonPath js = new JsonPath(accessTokenResp.asString());
		Object accessToken = js.get("access_token");
		// Get Courses
		GetCourses getCourseResp = given().contentType("application/json").queryParam("access_token", accessToken)
				.expect().defaultParser(Parser.JSON).when().get("https://rahulshettyacademy.com/getCourse.php").then()
				.assertThat().statusCode(200).extract().response().as(GetCourses.class);
		System.out.println(getCourseResp);
		System.out.println(getCourseResp.getExpertise());
		System.out.println(getCourseResp.getInstructor());
		String apilist = getCourseResp.getCourses().getApi().get(1).getCourseTitle();
		System.out.println(apilist);

		List<API> api = getCourseResp.getCourses().getApi();
		for (int i = 0; i < api.size(); i++) {
			if (api.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println(api.get(i).getCourseTitle() + ":" + api.get(i).getPrice());
			}

		}
		//Get web automation courses
		List<String> expectedCourses = Arrays.asList(courseList);
		List<String> a=new ArrayList<String>();
		List<WebAutomation> wb = getCourseResp.getCourses().getWebAutomation();
		for (int i = 0; i < wb.size(); i++) {
			a.add(wb.get(i).getCourseTitle());

		}
		Assert.assertTrue(a.equals(expectedCourses));
		//Assert.assertEquals(expectedCourses, a);

	}
}
