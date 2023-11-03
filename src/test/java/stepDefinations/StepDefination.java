# resource Folders code
	#1.API Resources
package resources;

public enum APIResources {
	newOrderAPI("/api/v2/Orders/new"),
	checkOutAPI("/api/v2/Orders/{Microsite_Order_id}/checkout"),
	refundAPI("/api/v2/Orders/{Microsite_Order_id}/refund?eventName=officia sint&isEventCancelled=false&isRefundAdminPortal=false&refundAllBlocks=true"),
	signUpAPI("/api/v2/Accounts/signup?autoConfirm=false"),
	signInAPI("/api/v2/Accounts/login"),
	addPaymentCards("/api/v2/PaymentCards"),
	getPaymentCards("/api/v2/PaymentCards"),
	addVehicles("/api/v2/Vehicles"),
	getVehicles("/api/v2/Vehicles");
	
	private String resource;

	APIResources(String resource){
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}

}
#-----------------------------------------------------------------
	#2. Test Data
	package resources;

import java.util.ArrayList;
import java.util.List;

import pojoClasses.AddPaymentCards;
import pojoClasses.AddVehicles;
import pojoClasses.CheckOutGuestUser;
import pojoClasses.CheckOutEntryGuestUser;
import pojoClasses.CheckOutEntryRegisteredUser;
import pojoClasses.CheckOutEntryVehiclesInfoGuestUser;
import pojoClasses.CheckOutEntryVehiclesInfoRegisteredUser;
import pojoClasses.CheckOutPaymentGuestUser;
import pojoClasses.CheckOutPaymentRegisteredUser;
import pojoClasses.CheckOutRegisteredUser;
import pojoClasses.NewOrdersGuestUser;
import pojoClasses.NewOrdersRegisteredUser;
import pojoClasses.NewOrdersEntryGuestUser;
import pojoClasses.NewOrdersEntryRegisteredUser;
import pojoClasses.SignIn;
import pojoClasses.SignUP;

public class TestData {
	public SignUP signUp(String firstName, String lastName, String email, String password, String confirmPassword) {
		SignUP s = new SignUP();
		s.setFirstName(firstName);
		s.setLastName(lastName);
		s.setEmail(email);
		s.setPassword(password);
		s.setConfirmPassword(confirmPassword);
		return s;
	}

	public SignIn signIn(String email, String password) {
		SignIn si = new SignIn();
		si.setEmail(email);
		si.setPassword(password);
		return si;
	}

	public AddPaymentCards addPaymentCards(String paymentCardType, String lastFourDigits, int expirationMonth,
			int expirationYear, String postalCode, String authorizationToken) {
		AddPaymentCards a = new AddPaymentCards();
		a.setPaymentCardType(paymentCardType);
		a.setLastFourDigits(lastFourDigits);
		a.setExpirationMonth(expirationMonth);
		a.setExpirationYear(expirationYear);
		a.setPostalCode(postalCode);
		a.setAuthorizationToken(authorizationToken);
		return a;
	}

	public AddVehicles addVehicles(String vehicleType, String licensePlate, String licensedState, String make,
			String model, String color, String numberOfPassengers, String alias) {
		AddVehicles a = new AddVehicles();
		a.setVehicleType(vehicleType);
		a.setLicensePlate(licensePlate);
		a.setLicensedState(licensedState);
		a.setMake(make);
		a.setModel(model);
		a.setColor(color);
		a.setNumberOfPassengers(numberOfPassengers);
		a.setAlias(alias);

		return a;

	}

	public NewOrdersGuestUser createNewOrderForGuestUsers(int userDevice, int orderType, int locationCode,
			String startAt, String stopAt, int quantity) {

		NewOrdersGuestUser newOrder = new NewOrdersGuestUser();
		newOrder.setUserDevice(userDevice);
		newOrder.setOrderType(orderType);

		NewOrdersEntryGuestUser entryNewOrder = new NewOrdersEntryGuestUser();
		entryNewOrder.setLocationCode(locationCode);
		entryNewOrder.setStartAt(startAt);
		entryNewOrder.setStopAt(stopAt);
		entryNewOrder.setQuantity(quantity);

		ArrayList<NewOrdersEntryGuestUser> entrySet = new ArrayList<NewOrdersEntryGuestUser>();
		entrySet.add(entryNewOrder);

		newOrder.setEntry(entrySet);
		return newOrder;

	}

	public CheckOutGuestUser createCheckOutNewOrdersForGuestUser(int userDevice, int purchaseType, int locationCode,
			String startAt, String stopAt, int quantity, String reserToken, String isArriveIntegrationAbsent,
			String vehicleType, String licensePlate, String licensedState, String make, String model, String color,
			String alias, String isDefault, int numberOfPassengers, String paymentCardType, String lastFourDigits,
			String expirationMonth, String expirationYear, String postalCode, String authorizationToken, String email,
			String firstName, String lastName, String phone) {

		CheckOutGuestUser c = new CheckOutGuestUser();
		c.setUserDevice(userDevice);
		c.setPurchaseType(purchaseType);

		CheckOutEntryGuestUser ce = new CheckOutEntryGuestUser();
		ce.setLocationCode(locationCode);
		ce.setStartAt(startAt);
		ce.setStopAt(stopAt);
		ce.setQuantity(quantity);
		ce.setReservationToken(reserToken);
		ce.setArriveIntegrationAbsent(isArriveIntegrationAbsent);

		CheckOutEntryVehiclesInfoGuestUser v = new CheckOutEntryVehiclesInfoGuestUser();
		v.setVehicleType(vehicleType);
		v.setLicensePlate(licensePlate);
		v.setLicensedState(licensedState);
		v.setMake(make);
		v.setModel(model);
		v.setColor(color);
		v.setAlias(alias);
		v.setDefault(isDefault);
		v.setNumberOfPassengers(numberOfPassengers);
		ce.setVehicleInfo(v);

		List<CheckOutEntryGuestUser> entrySet = new ArrayList<CheckOutEntryGuestUser>();
		entrySet.add(ce);
		c.setEntry(entrySet);

		CheckOutPaymentGuestUser p = new CheckOutPaymentGuestUser();
		p.setPaymentCardType(paymentCardType);
		p.setLastFourDigits(lastFourDigits);
		p.setExpirationMonth(expirationMonth);
		p.setExpirationYear(expirationYear);
		p.setPostalCode(postalCode);
		p.setAuthorizationToken(authorizationToken);
		p.setEmail(email);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setPhone(phone);

		c.setPayment(p);
		return c;
	}

	// New Order API payload for Registered user
	public NewOrdersRegisteredUser createNewOrderForRegisteredUsers(int deviceType, int orderType, int saleType,
			int locationCode, String startAt, String stopAt, int quantity) {
		NewOrdersRegisteredUser newOrderRegistered = new NewOrdersRegisteredUser();
		newOrderRegistered.setDeviceType(deviceType);
		newOrderRegistered.setOrderType(orderType);
		newOrderRegistered.setSaleType(saleType);

		NewOrdersEntryRegisteredUser ne = new NewOrdersEntryRegisteredUser();
		ne.setLocationCode(locationCode);
		ne.setStartAt(startAt);
		ne.setStopAt(stopAt);
		ne.setQuantity(quantity);
		List<NewOrdersEntryRegisteredUser> enrtySet = new ArrayList<NewOrdersEntryRegisteredUser>();
		enrtySet.add(ne);

		newOrderRegistered.setEntry(enrtySet);
		return newOrderRegistered;
	}

	public CheckOutRegisteredUser createCheckOutForRegisteredUsers(int deviceType, int orderType, int saleType,
			int locationCode, int quantity, String startAt, String stopAt, String reservationToken,
			String isArriveIntegrationAbsent, String vehicleId, String paymentId) {
		CheckOutRegisteredUser ck = new CheckOutRegisteredUser();
		ck.setDeviceType(deviceType);
		ck.setOrderType(orderType);
		ck.setSaleType(saleType);

		CheckOutEntryRegisteredUser cke = new CheckOutEntryRegisteredUser();
		cke.setLocationCode(locationCode);
		cke.setQuantity(quantity);
		cke.setStartAt(startAt);
		cke.setStopAt(stopAt);
		cke.setReservationToken(reservationToken);
		cke.setArriveIntegrationAbsent(isArriveIntegrationAbsent);

		CheckOutEntryVehiclesInfoRegisteredUser ckev = new CheckOutEntryVehiclesInfoRegisteredUser();
		ckev.setId(vehicleId);

		cke.setVehicleInfo(ckev);

		List<CheckOutEntryRegisteredUser> entrySetReg = new ArrayList<CheckOutEntryRegisteredUser>();
		entrySetReg.add(cke);

		ck.setEntry(entrySetReg);

		CheckOutPaymentRegisteredUser ckp = new CheckOutPaymentRegisteredUser();
		ckp.setId(paymentId);

		ck.setPayment(ckp);
		return ck;
	}
}
#---------------------------------------------------------
	#3. Utilties
	package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utilities {
	public static RequestSpecification req;
	ResponseSpecification resspec;
	JsonPath js;

	public RequestSpecification requestSpecificatins() throws IOException {
		if (req == null) {

			PrintStream log = new PrintStream(new FileOutputStream("Logs.txt"));

			req = new RequestSpecBuilder().setBaseUri(getGlobleProperty("baseURI"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	public ResponseSpecification responseSpecifications() {
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return resspec;
	}

	public static String getGlobleProperty(String key) throws IOException {
		Properties pro = new Properties();
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\globalVariables.properties";
		FileInputStream fis = new FileInputStream(filePath);
		pro.load(fis);
		return pro.getProperty(key);

	}

	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
#----------------------------------------------------------------------
	#stepDefinations Folder
	#1.  Add_First_2nd_OR_3rd_AlreadyExist_PaymentCards_VehiclesForNewUser
	package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utilities;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class Add_First_2nd_OR_3rd_AlreadyExist_PaymentCards_VehiclesForNewUser extends Utilities {
	RequestSpecification request;
	Response response;
	RequestSpecification reqVehicles;
	TestData data = new TestData();

	// Add First First Payment card for new user and Expect isDefault field should
	// be 'true' in the response body
	@Given("Add First Payment Card for New User with Payload {string} {string} {int} {int} {string} {string}")
	public void add_first_payment_card_for_new_user_with_payload(String paymentCardType, String lastFourDigits,
			Integer expirationMonth, Integer expirationYear, String postalCode, String authorizationToken)
			throws IOException {
		System.out.println("bearer" + " " + SignUpAndSignIn.id_token);
		// Write code here that turns the phrase above into concrete actions
		request = given().log().all().spec(requestSpecificatins())
				.header("Authorization", "bearer" + " " + SignUpAndSignIn.id_token)
				.body(data.addPaymentCards(paymentCardType, lastFourDigits, expirationMonth, expirationYear, postalCode,
						authorizationToken));
	}

	@When("user calls for account {string} with {string} http request")
	public void user_calls_for_account_with_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		if (method.equalsIgnoreCase("POST"))
			response = request.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("PUT"))
			response = request.when().get(resourceAPI.getResource());
		else if (method.contentEquals("GET"))
			response = request.when().get(resourceAPI.getResource());
		// System.out.println(response.asString());
		// .then().log().all().spec(responseSpecifications()).extract().response();
	}

	@Then("the account API call got success with status code {int}")
	public void the_account_api_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("Verify the actual {string} matching with expected {string}")
	public void verify_the_actual_matching_with_expected(String actualKey, String expectedKey) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(response, actualKey), expectedKey);

	}

	// Add First Vehicle for new user and Expect isDefault field should be 'true' in
	// the response body
	@Given("Add First Vehicle for New User with Payload {string} {string} {string} {string} {string} {string} {string} {string}")
	public void add_first_vehicle_for_new_user_with_payload(String vehicleType, String licensePlate,
			String licensedState, String make, String model, String color, String numberOfPassengers, String alias)
			throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().log().all().spec(requestSpecificatins())
				.header("Authorization", "bearer" + " " + SignUpAndSignIn.id_token).body(data.addVehicles(vehicleType,
						licensePlate, licensedState, make, model, color, numberOfPassengers, alias));
	}

	// Add 2nd OR 3rd nd OR 3rd Payment Card for new user and Expect isDefault field
	// should be 'false' in
	// the response body
	@Given("Add 2nd OR 3rd Payment Card for New User with Payload {string} {string} {int} {int} {string} {string}")
	public void add_2nd_or_3rd_payment_card_for_new_user_with_payload(String paymentCardType, String lastFourDigits,
			Integer expirationMonth, Integer expirationYear, String postalCode, String authorizationToken)
			throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().log().all().spec(requestSpecificatins())
				.header("Authorization", "bearer" + " " + SignUpAndSignIn.id_token)
				.body(data.addPaymentCards(paymentCardType, lastFourDigits, expirationMonth, expirationYear, postalCode,
						authorizationToken));
	}

	// Add 2nd OR 3rd nd OR 3rd Vehicles for new user and Expect isDefault field
	// should be 'false' in
	// the response body
	@Given("Add 2nd OR 3rd Vehicle for New User with Payload {string} {string} {string} {string} {string} {string} {string} {string}")
	public void add_2nd_or_3rd_vehicle_for_new_user_with_payload(String vehicleType, String licensePlate,
			String licensedState, String make, String model, String color, String numberOfPassengers, String alias)
			throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().log().all().spec(requestSpecificatins())
				.header("Authorization", "bearer" + " " + SignUpAndSignIn.id_token).body(data.addVehicles(vehicleType,
						licensePlate, licensedState, make, model, color, numberOfPassengers, alias));

	}

	// Add Existing Vehicles and EXpect error message
	@Given("Add Existing Vehicles for user User with Payload {string} {string} {string} {string} {string} {string} {string} {string}")
	public void add_existing_vehicles_for_user_user_with_payload(String vehicleType, String licensePlate,
			String licensedState, String make, String model, String color, String numberOfPassengers, String alias)
			throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().log().all().spec(requestSpecificatins())
				.header("Authorization", "bearer" + " " + SignUpAndSignIn.id_token).body(data.addVehicles(vehicleType,
						licensePlate, licensedState, make, model, color, numberOfPassengers, alias));
	}

	@Then("Verify the Existing Acual Error {string} with Expected Error Message {string}")
	public void verify_the_existing_acual_error_with_expected_error_message(String actualMessage,
			String expectedEmessage) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(getJsonPath(response, actualMessage) + " " + expectedEmessage);
		assertEquals(getJsonPath(response, actualMessage), expectedEmessage);
	}

//Add existing payment cards and expect error message
	@Given("Add Existing Payment Card for User with Payload {string} {string} {int} {int} {string} {string}")
	public void add_existing_payment_card_for_user_with_payload(String paymentCardType, String lastFourDigits,
			Integer expirationMonth, Integer expirationYear, String postalCode, String authorizationToken)
			throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().log().all().spec(requestSpecificatins())
				.header("Authorization", "bearer" + " " + SignUpAndSignIn.id_token)
				.body(data.addPaymentCards(paymentCardType, lastFourDigits, expirationMonth, expirationYear, postalCode,
						authorizationToken));
	}


}

#--------------------------------------------------------------------------------
	#2. Get_PaymentCardId_And_VehicleId_For_Reservations

package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utilities;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class Get_PaymentCardId_And_VehicleId_For_Reservations extends Utilities {
	RequestSpecification request;
	Response response;
	TestData data = new TestData();
	public static String payment_Id;
	public static String vehicle_Id;

	@Given("Add and Get Payment Card for Reservations")
	public void add_and_get_payment_card_for_reservations() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().log().all().spec(requestSpecificatins()).auth().oauth2(SignUpAndSignIn.id_token);
		// .header("Authorization","bearer" + " " + SignUpAndSignIn.id_token);
	}

	@When("user calls PaymentCards Vehicles for Reservations {string} with {string} http request")
	public void user_calls_payment_cards_vehicles_for_reservations_with_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		if (method.equalsIgnoreCase("POST"))
			response = request.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			response = request.when().get(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("PUT"))
			response = request.when().put(resourceAPI.getResource());

	}

	@Then("the API PaymentCardsVehicles call got success with status code {int}")
	public void the_api_payment_cards_vehicles_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);

	}

//Add and Get payment card ids for Reservations
	@Then("Add Payment Cards using addPaymentCardAPI {string} with {string} with parameters {string} {string} {int} {int} {string} {string}")
	public void add_payment_cards_using_add_payment_card_api_with_with_parameters(String resource, String method,
			String paymentCardType, String FourDigits, Integer expirationMonth, Integer expirationYear,
			String postalCode, String authorizationToken) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().log().all().spec(requestSpecificatins())
				.header("Authorization", "bearer" + " " + SignUpAndSignIn.id_token).body(data.addPaymentCards(
						paymentCardType, FourDigits, expirationMonth, expirationYear, postalCode, authorizationToken));

		int size = Integer.parseInt(getJsonPath(response, "size()"));
		System.out.println(size);

		if (size < 3) {
			if (size == 0) {
				user_calls_payment_cards_vehicles_for_reservations_with_http_request(resource, method);
				payment_Id = getJsonPath(response, "id");
				System.out.println(payment_Id);
			} else {
				for (int i = 0; i < size; i++) {
					String LastFourDigits = getJsonPath(response, "lastFourDigits[" + i + "]");
					// int ExpirationMonth = Integer.parseInt(getJsonPath(response,
					// "expirationMonth[" + i + "]"));
					// int ExpirationYear = Integer.parseInt(getJsonPath(response, "expirationYear["
					// + i + "]"));

					if ((FourDigits.equals(LastFourDigits))) {
						payment_Id = getJsonPath(response, "id[" + i + "]");
						System.out.println(LastFourDigits + ":" + payment_Id);
					}

				}
				int j = 0;
				for (int i = 0; i < size; i++) {
					String LastFourDigits = getJsonPath(response, "lastFourDigits[" + i + "]");
					// int ExpirationMonth = Integer.parseInt(getJsonPath(response,
					// "expirationMonth[" + i + "]"));
					// int ExpirationYear = Integer.parseInt(getJsonPath(response, "expirationYear["
					// + i + "]"));

					if (!FourDigits.equals(LastFourDigits)) {
						j++;
					}

				}
				if (j == size) {
					user_calls_payment_cards_vehicles_for_reservations_with_http_request(resource, method);
					payment_Id = getJsonPath(response, "id");
					System.out.println(payment_Id);
				}
			}

		} else if (size == 3) {

			for (int i = 0; i < size; i++) {
				// String LastFourDigits = getJsonPath(response, "lastFourDigits[" + i + "]");

				String isDefault = getJsonPath(response, "isDefault[" + i + "]");
				// int ExpirationMonth = Integer.parseInt(getJsonPath(response,
				// "expirationMonth[" + i + "]"));
				// int ExpirationYear = Integer.parseInt(getJsonPath(response, "expirationYear["
				// + i + "]"));

				if ((isDefault.equals("true"))) {
					payment_Id = getJsonPath(response, "id[" + i + "]");
					System.out.println(payment_Id);

				}

			}
			// payment_Id = getJsonPath(response, "errors[0]");
			// System.out.println("Delete any card and add new one");
		}
	}

	// ---------------------------------------------------------------------------
	/// Add and Get Veicles ids for Reservations
	@Given("Add and Get Vehicles Ids for Reservations")
	public void add_and_get_vehicles_ids_for_reservations() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().log().all().spec(requestSpecificatins()).header("Authorization",
				"bearer" + " " + SignUpAndSignIn.id_token);
	}

	@Then("Add Vehciles using addVehiclesAPI {string} with {string} with parameters {string} {string} {string} {string} {string} {string} {string} {string}")
	public void add_vehciles_using_add_vehicles_api_with_with_parameters(String resource, String method,
			String vehicleType, String licenseplate, String licensedState, String make, String model, String color,
			String numberOfPassengers, String alias) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().log().all().spec(requestSpecificatins())
				.header("Authorization", "bearer" + " " + SignUpAndSignIn.id_token).body(data.addVehicles(vehicleType,
						licenseplate, licensedState, make, model, color, numberOfPassengers, alias));

		int size = Integer.parseInt(getJsonPath(response, "size()"));
		System.out.println("Response size: " + size);
		if (size < 3) {
			if (size == 0) {
				user_calls_payment_cards_vehicles_for_reservations_with_http_request(resource, method);
				vehicle_Id = getJsonPath(response, "value.id");
				System.out.println(vehicle_Id);
			} else {
				for (int i = 0; i < size; i++) {
					String LicensePlate = getJsonPath(response, "licensePlate[" + i + "]");
					// String LicensedState = getJsonPath(response, "licensedState[" + i + "]");
                    //&& (LicensedState.equalsIgnoreCase(licensedState))
					if (LicensePlate.equalsIgnoreCase(licenseplate)) {
						vehicle_Id = getJsonPath(response, "id[" + i + "]");
						System.out.println(LicensePlate + ":  " + vehicle_Id);
					}

				}
				int j = 0;
				for (int i = 0; i < size; i++) {
					String LicensePlate = getJsonPath(response, "licensePlate[" + i + "]");
					// String LicensedState = getJsonPath(response, "licensedState[" + i + "]");
					// &&!licensedState.equalsIgnoreCase(LicensedState)
					if (!licenseplate.equalsIgnoreCase(LicensePlate)) {
						j++;
					}

				}

				if (j == size) {
					user_calls_payment_cards_vehicles_for_reservations_with_http_request(resource, method);
					vehicle_Id = getJsonPath(response, "value.id");
					System.out.println(vehicle_Id);
				}
			}

		} else if (size == 3) {

			for (int i = 0; i < size; i++) {

				String isDefault = getJsonPath(response, "isDefault[" + i + "]");
				// int ExpirationMonth = Integer.parseInt(getJsonPath(response,
				// "expirationMonth[" + i + "]"));
				// int ExpirationYear = Integer.parseInt(getJsonPath(response, "expirationYear["
				// + i + "]"));

				if ((isDefault.equals("true"))) {
					vehicle_Id = getJsonPath(response, "id[" + i + "]");
					System.out.println(vehicle_Id);
				}

			}
			// payment_Id = getJsonPath(response, "errors[0]");
			// System.out.println("Delete any card and add new one");
		}

	}

}
#--------------------------------------------------------------------------------------
	#3. Guest_User_End_To_End_Reservations
	package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utilities;

public class Guest_User_End_To_End_Reservations extends Utilities {
	RequestSpecification request;
	Response response;
	TestData data = new TestData();
	static String order_Id;
	static String reservation_Token;

	@Given("New Order Payload with {int} {int} {int} {string} {string} {int}")
	public void new_order_payload_with(Integer userDevice, Integer orderType, Integer locationCode, String startAt,
			String stopAt, Integer quantity) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecificatins()).log().all()
				.body(data.createNewOrderForGuestUsers(userDevice, orderType, locationCode, startAt, stopAt, quantity));

	}

	@When("user Guest User calls {string} with {string} http request")
	public void user_guest_user_calls_with_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		if (method.equalsIgnoreCase("POST"))
			response = request.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("PUT"))
			response = request.when().put(resourceAPI.getResource());
		else if (method.contentEquals("GET"))
			response = request.when().get(resourceAPI.getResource());
		// System.out.println(response.asString());
		// .then().log().all().spec(responseSpecifications()).extract().response();
	}

	@Then("the guest user API call got success with status code {int}")
	public void the_guest_user_api_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("the response key {string} in response body is {string}")
	public void the_response_key_in_response_body_is(String actualKey, String expectedKey) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(getJsonPath(response, actualKey), expectedKey);
	}

	@Then("verify Microsite_Order_id {string} and reservationsToken {string} created using newOrderAPI")
	public void verify_microsite_order_id_and_reservations_token_created_using_new_order_api(String orderIdKey,
			String reservationTokenKey) {
		// Write code here that turns the phrase above into concrete actions
		order_Id = getJsonPath(response, orderIdKey);
		System.out.println(order_Id);
		reservation_Token = getJsonPath(response, reservationTokenKey);
		System.out.println(reservation_Token);

	}

	// Checkout API
	@Given("CheckOut Payload with {int} {int} {int} {string} {string} {int} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {int} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void check_out_payload_with(Integer userDevice, Integer purchaseType, Integer locationCode, String startAt,
			String stopAt, Integer quantity, String reserToken, String isArriveIntegrationAbsent, String vehicleType,
			String licensePlate, String licensedState, String make, String model, String color, String alias,
			String isDefault, Integer numberOfPassengers, String paymentCardType, String lastFourDigits,
			String expirationMonth, String expirationYear, String postalCode, String authorizationToken, String email,
			String firstName, String lastName, String phone) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecificatins()).pathParam("Microsite_Order_id", order_Id)
				.header("Site-Auth", getGlobleProperty("micrositeId")).log().all()
				.body(data.createCheckOutNewOrdersForGuestUser(userDevice, purchaseType, locationCode, startAt, stopAt,
						quantity, reservation_Token, isArriveIntegrationAbsent, vehicleType, licensePlate, licensedState, make,
						model, color, alias, isDefault, numberOfPassengers, paymentCardType, lastFourDigits,
						expirationMonth, expirationYear, postalCode, authorizationToken, email, firstName, lastName,
						phone));

	}

	@Then("verify actualKeys {string} {string} is displayed in checkOutAPIBody is matching with expectedKey is generated in newOrderAPI using checkOutAPI")
	public void verify_actual_keys_is_displayed_in_check_out_api_body_is_matching_with_expected_key_is_generated_in_new_order_api_using_check_out_api(String orderId, String Token) {
	    // Write code here that turns the phrase above into concrete actions
	    
	    assertEquals(getJsonPath(response,orderId),order_Id);
	    assertEquals(getJsonPath(response,Token),reservation_Token);
	
	}
	
	//Refund API for Cancelling the Orders

@Given("Cancelling the Order using Refund API with Order Id")
public void cancelling_the_order_using_refund_api_with_order_id() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	request = given().spec(requestSpecificatins()).pathParam("Microsite_Order_id", order_Id).header("Site-Auth", getGlobleProperty("micrositeId")).log().all();		
}

}
#---------------------------------------------------------------------------
	#4. Hooks
	package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@Get_PaymentCardId_VehcileId_For_Reservations")
	//@Get_PaymentCardId_VehcileId_For_Reservations
	public void beforeScenarios() throws IOException {
		SignUpAndSignIn sin = new SignUpAndSignIn();
		if (SignUpAndSignIn.id_token == null) {
			sin.sign_in_payload_with("skmanu100031@mailinator.com", "Parking@1");
			sin.user_calls_with_http_request("signInAPI", "POST");
			sin.verify_the_id_token_is_generated("id_token");
		}
	}

	@Before("@AddFirst_Card_And_Vehicle_ForNewUser=True")
	public void beforeScenarios_Add_First_2nd_OR_3rd_PaymentCards_VehiclesForNewUser() throws IOException {
		SignUpAndSignIn sin = new SignUpAndSignIn();
		if (SignUpAndSignIn.id_token == null) {
			sin.sign_in_payload_with("skmanu100031@mailinator.com", "Parking@1");
			sin.user_calls_with_http_request("signInAPI", "POST");
			sin.verify_the_id_token_is_generated("id_token");
		}
	}

	/*
	 * if(size<3) { addPaymentCards -while adding card first, checking is that card
	 * already exist in the account, if it is true then get first payment id. Or if
	 * card is not exist in the account then add the same card and get the payment
	 * id } else { get payment card id which is default one }
	 */

}
#-----------------------------------------------------------------
	#5. Registered_User_End_To_End_Reservations
	package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintStream;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utilities;

public class Registered_User_End_To_End_Reservations extends Utilities {
	RequestSpecification request;
	Response response;
	static String order_Id;
	static String reservation_Token;
	TestData data = new TestData();
	
	static String paymentId=Get_PaymentCardId_And_VehicleId_For_Reservations.payment_Id;
	
	static String vehicleId=Get_PaymentCardId_And_VehicleId_For_Reservations.vehicle_Id;
	//Get_PaymentCardId_And_VehicleId_For_Reservations pv=new Get_PaymentCardId_And_VehicleId_For_Reservations();
	
	
	
	@Given("New Order RegisteredUser Payload with {int} {int} {int} {int} {string} {string} {int}")
	public void new_order_registered_user_payload_with(Integer deviceType, Integer orderType, Integer saleType,
			Integer locationCode, String startAt, String stopAt, Integer quantity) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecificatins())
				.header("Authorization", "bearer" + " " + SignUpAndSignIn.id_token).log().all()
				.body(data.createNewOrderForRegisteredUsers(deviceType, orderType, saleType, locationCode, startAt,
						stopAt, quantity));

	}

	@When("user Registered User calls {string} with {string} http request")
	public void user_registered_user_calls_with_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		if (method.equalsIgnoreCase("POST"))
			response = request.when().post(resourceAPI.getResource()).then().extract().response();
		else if (method.equalsIgnoreCase("GET"))
			response = request.when().get(resourceAPI.getResource()).then().extract().response();
		else if (method.equalsIgnoreCase("PUT"))
			response = request.when().put(resourceAPI.getResource()).then().extract().response();
	}

	@Then("the registered user API call got success with status code {int}")
	public void the_registered_user_api_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("the Registered user workflowState key {string} in response body is {string}")
	public void the_registered_user_workflow_state_key_in_response_body_is(String actualKey, String expectedKey) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(getJsonPath(response, actualKey), expectedKey);
	}

	@Then("Verify microsite_Order_id {string} and reservationsToken {string} created using newOrderAPI for Registered")
	public void verify_microsite_order_id_and_reservations_token_created_using_new_order_api_for_registered(
			String orderIdKey, String reservationTokenKey) {
		// Write code here that turns the phrase above into concrete actions
		order_Id = getJsonPath(response, orderIdKey);
		System.out.println(order_Id);
		reservation_Token = getJsonPath(response, reservationTokenKey);
		System.out.println(reservation_Token);
	}

	// Check Out API
	@Given("CheckOut Registered Payload with {int} {int} {int} {int} {int} {string} {string} {string} {string}")
	public void check_out_registered_payload_with(Integer deviceType, Integer orderType, Integer saleType,
			Integer locationCode, Integer quantity, String startAt, String stopAt, String reservationToken,
			String isArriveIntegrationAbsent) throws IOException {
		//PrintStream log = null;
		// Write code here that turns the phrase above into concrete actions
		//=Get_PaymentCardId_And_VehicleId_For_Reservations.payment_Id;
		//pv.payment_Id
		request = given().spec(requestSpecificatins()).pathParam("Microsite_Order_id", order_Id)
				.header("Authorization", "bearer" + " " + SignUpAndSignIn.id_token).log().all()
				.body(data.createCheckOutForRegisteredUsers(deviceType, orderType, saleType, locationCode, quantity,
						startAt, stopAt, reservation_Token, isArriveIntegrationAbsent, vehicleId, paymentId));
	}

	@Then("verify Registered user orderId, reservationToken keys {string} {string} is displayed in checkOutAPIBody is matching with expectedKey is generated in newOrderAPI using checkOutAPI")
	public void verify_registered_user_order_id_reservation_token_keys_is_displayed_in_check_out_api_body_is_matching_with_expected_key_is_generated_in_new_order_api_using_check_out_api(
			String orderId, String reserverToken) {
		// Write code here that turns the phrase above into concrete actions
		      assertEquals(getJsonPath(response,orderId),order_Id);
		    assertEquals(getJsonPath(response,reserverToken),reservation_Token);
	}

}
#----------------------------------------------------------------------------------
	#6.SignUpAndSignIn
	package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utilities;

public class SignUpAndSignIn extends Utilities {
	RequestSpecification res;
	// ResponseSpecification resspec;
	Response response;
	TestData data = new TestData();
	public static String id_token;

//Test Case 1: SignUp API
	@Given("Sign Up Payload with {string} {string} {string} {string} {string}")
	public void sign_up_payload_with(String firstName, String lastName, String email, String pasword,
			String confirmPassword) throws IOException {
		// Write code here that turns the phrase above into concrete

		res = given().spec(requestSpecificatins()).header("microSiteId", getGlobleProperty("micrositeId")).log().all()
				.body(data.signUp(firstName, lastName, email, pasword, confirmPassword));

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource());

		else if (method.equalsIgnoreCase("PUT"))
			response = res.when().put(resourceAPI.getResource());

		else if (method.contentEquals("GET"))
			response = res.when().get(resourceAPI.getResource());

		// System.out.println(response.asString());
		// .then().log().all().spec(responseSpecifications()).extract().response();
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		// response.then().spec(responseSpecifications()).extract().response();

		assertEquals(response.getStatusCode(), 200);
		// String string=response.asString();
		//response.path("");

	}

	@Then("Verify the {string} is created matching {string}")
	public void verify_the_is_created_matching(String key, String email) {
		// Write code here that turns the phrase above into concrete actions
		// System.out.println(response.asString());

		assertEquals(getJsonPath(response, key), email);

	}

	// SignUp with already existing email
	@Then("Verify the actual error {string} message matching with expected error message {string}")
	public void verify_the_actual_error_message_matching_with_expected_error_message(String actual, String expected) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(getJsonPath(response, actual), expected);
	}

	// Test Case1: SignIn API
	// Sign In with valid credentials
	@Given("Sign In Payload with {string} {string}")
	public void sign_in_payload_with(String email, String password) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		res = given().spec(requestSpecificatins()).header("microSiteId", getGlobleProperty("micrositeId")).log().all()
				.body(data.signIn(email, password));
	}

	@Then("Verify the id_token {string} is generated")
	public void verify_the_id_token_is_generated(String id_Token) {
		// Write code here that turns the phrase above into concrete actions
		id_token = getJsonPath(response, id_Token);

	}

	@Then("Verify the Error {string} Message is displayed for Invalid Credentials {string} message")
	public void verify_the_error_message_is_displayed_for_invalid_credentials_message(String actualMessage,
			String expectMessage) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(getJsonPath(response, actualMessage), expectMessage);
	}
}
#------------------------------------------------------
	
