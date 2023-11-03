package pojoClasses;

public class CheckOutPaymentGuestUser {
private String paymentCardType;
private String lastFourDigits;
private String expirationMonth;
private String expirationYear;
private String postalCode;
private String authorizationToken;
private String email;
private String firstName;
private String lastName;
private String phone;

public String getPaymentCardType() {
	return paymentCardType;
}
public void setPaymentCardType(String paymentCardType) {
	this.paymentCardType = paymentCardType;
}
public String getLastFourDigits() {
	return lastFourDigits;
}
public void setLastFourDigits(String lastFourDigits) {
	this.lastFourDigits = lastFourDigits;
}
public String getExpirationMonth() {
	return expirationMonth;
}
public void setExpirationMonth(String expirationMonth) {
	this.expirationMonth = expirationMonth;
}
public String getExpirationYear() {
	return expirationYear;
}
public void setExpirationYear(String expirationYear) {
	this.expirationYear = expirationYear;
}
public String getPostalCode() {
	return postalCode;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
public String getAuthorizationToken() {
	return authorizationToken;
}
public void setAuthorizationToken(String authorizationToken) {
	this.authorizationToken = authorizationToken;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

}
