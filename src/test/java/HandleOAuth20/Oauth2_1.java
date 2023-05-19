package HandleOAuth20;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_1 {
	@Test
	public void generateAccessToken() {
		//Get code
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AbUR2VO7BNgGkevd4bDkJPiTjPCElN2UemsTDN59T_zOd9HuauwmCNqoH2LSig32FYcJcg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String code=url.split("code=")[1].split("&scope")[0];
		System.out.println(code);

//Get access token
	

		
	Response repo = given().log().all().urlEncodingEnabled(false).queryParam("code", code)
	.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
	.queryParam("grant_type", "authorization_code")
	.when().post("https://www.googleapis.com/oauth2/v4/token")
	.then().log().all().assertThat().statusCode(200).extract().response();
	JsonPath js=new JsonPath(repo.asString());
	String token=js.get("access_token");
	System.out.println(token);
		
//Get courses
	given().log().all().queryParam("access_token", token)
	.when().get("https://rahulshettyacademy.com/getCourse.php").then().log().all().assertThat().statusCode(200).extract().response();

	}
}
