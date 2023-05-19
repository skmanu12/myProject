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

public class GetCoursesOAuth2o {
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

		String url = "https://rahulshettyacademy.com/getCourse.php?state=verify&code=4%2F0AVHEtk7lm_8-L15oEjkNcLcvyhlKbDs-nXNe9W3Ec9pgbaJr0OO69qWfnY0I4uhFcLy4Kw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=none";

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
		String getCourseResp = given().contentType("application/json").log().all()
				.queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON).when()
				.get("https://rahulshettyacademy.com/getCourse.php").then().assertThat().statusCode(200)
				.extract().response().asString();
		System.out.println(getCourseResp);

	}
}
