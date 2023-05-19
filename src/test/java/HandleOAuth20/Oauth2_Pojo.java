package HandleOAuth20;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import restAssured.PojoClasses.copy.API;
import restAssured.PojoClasses.copy.Course;
import restAssured.PojoClasses.copy.GetCourse;
import restAssured.PojoClasses.copy.WebAutomation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oauth2_Pojo {
	@Test
	public void generateAccessToken() {
		String[] courses= {"Selenium Webdriver Java","Cypress","Protractor"};
		String url = "https://rahulshettyacademy.com/getCourse.php?state=verify&code=4%2F0AVHEtk4b0GBbkRaE8tVIpu97Y7AzTVF37ZdW0FwI64Bg0wro5ys5JmntPcJ_BPdd_HiFCA&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=none";
		String code = url.split("code=")[1].split("&scope")[0];
		System.out.println(code);

//Get access token
	
		Response tokenResponse = given().urlEncodingEnabled(false).log().all().queryParam("code", code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type", "authorization_code").when().post("https://www.googleapis.com/oauth2/v4/token")
		.then().log().all().assertThat().statusCode(200).extract().response();
		
		JsonPath js=new JsonPath(tokenResponse.asString());
		
		String token=js.get("access_token");
		
//Get courses
		RestAssured.baseURI = "";
		GetCourse response = given().log().all().queryParam("access_token", token).expect().defaultParser(Parser.JSON).when().get("https://rahulshettyacademy.com/getCourse.php")
				.then().log().all().assertThat().statusCode(200).extract().response().as(GetCourse.class);

String course = response.getExpertise();
System.out.println(course);
List<API> apiCourses = response.getCourses().getApi();
for(API api:apiCourses) {
	String courseTitle=api.getCourseTitle();
	System.out.println(courseTitle);
}
//Get price of perticular course
for(API api:apiCourses) {
	if(api.getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
		System.out.println(api.getPrice());
	}
	
}
//Compare expected Courses to actual courses
List<String> expectedCourses = Arrays.asList(courses);
List<WebAutomation> WebAutoCourses = response.getCourses().getWebAutomation();
ArrayList<String> actualCourses=new ArrayList<String>();
for(WebAutomation web:WebAutoCourses) {
	actualCourses.add(web.getCourseTitle());
	
}

Assert.assertEquals(expectedCourses, actualCourses);
	}
}
