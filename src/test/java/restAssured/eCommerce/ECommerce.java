package restAssured.eCommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restAssured.PojoClasses.LoginEcommerceRequest;
import restAssured.PojoClasses.LoginEcommerceResponse;
import restAssured.PojoClasses.OrderDetails;
import restAssured.PojoClasses.Orders;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ECommerce {
	@Test
	public void getEcommerceProducts() {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();

		LoginEcommerceRequest loginRequest = new LoginEcommerceRequest();
		loginRequest.setUserEmail("skmanu12@gmail.com");
		loginRequest.setUserPassword("Chnu@1987");
		LoginEcommerceResponse loginResponse = given().spec(req).body(loginRequest).when().post("/api/ecom/auth/login")
				.then().log().all().assertThat().statusCode(200).extract().response().as(LoginEcommerceResponse.class);
		// System.out.println(loginResponse.asString());
		// JsonPath js=new JsonPath(loginResponse.asString());
		// String authToken=js.get("token");
		String authToken = loginResponse.getToken();
		String userId = loginResponse.getUserId();
		System.out.println(authToken);

		// Add Product
		RequestSpecification addProductBase = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", authToken).build();

		RequestSpecification requestAddProducts = given().relaxedHTTPSValidation().log().all().spec(addProductBase)
				.param("productName", "Kabbadi").param("productAddedBy", userId).param("productCategory", "fashin")
				.param("productSubCategory", "shirts").param("productPrice", "4900000")
				.param("productDescription", "Addias Originals").param("productFor", "men").multiPart("productImage",
						new File("C:\\Users\\manappa.kalmani\\OneDrive - Qualitest Group\\Desktop\\image2.png"));

		String responseAddProducts = requestAddProducts.when().post("/api/ecom/product/add-product").then().log().all()
				.extract().response().asString();
		JsonPath js = new JsonPath(responseAddProducts);
		String productId = js.get("productId");

		// Create Order

		Orders order = new Orders();
		OrderDetails orderDetails = new OrderDetails();

		orderDetails.setCountry("india");
		orderDetails.setProductOrderedId(productId);
		List<OrderDetails> orderList = new ArrayList<OrderDetails>();
		orderList.add(orderDetails);

		order.setOrders(orderList);

		RequestSpecification createProductBase = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", authToken).setContentType(ContentType.JSON).build();

		RequestSpecification requestCreateProductBase = given().relaxedHTTPSValidation().log().all()
				.spec(createProductBase).body(order);

		Response responseCreateProductBase = requestCreateProductBase.when().post("/api/ecom/order/create-order").then()
				.log().all().extract().response();

		// Delete product
		RequestSpecification deleteProductBase = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", authToken).setContentType(ContentType.JSON).build();

		RequestSpecification requestDeleteProductBase = given().relaxedHTTPSValidation().log().all()
				.spec(deleteProductBase).pathParam("productId", productId).body(order);

		String responseDeleteProductBase = requestDeleteProductBase.when()
				.delete("/api/ecom/product/delete-product/{productId}").then().log().all().extract().response()
				.asString();

	}

}
