package restAssured.Files;

import io.restassured.path.json.JsonPath;

public class ReUsables {

	public static JsonPath getJsonPath(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}
}
