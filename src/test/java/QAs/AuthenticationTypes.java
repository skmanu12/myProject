package QAs;

import io.restassured.RestAssured;

public class AuthenticationTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.given().header("","").auth().basic("skmanu12@gmail.com", "12345")
.auth().digest("username", "password").auth().form(null, null, null)
.auth().oauth2("");
	}

}
