package pojoClasses;

public class AddPaymentCards {
private String paymentCardType;
private String lastFourDigits;
private int expirationMonth;
private int expirationYear;
private String postalCode;
private String authorizationToken;

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
public int getExpirationMonth() {
	return expirationMonth;
}
public void setExpirationMonth(int expirationMonth) {
	this.expirationMonth = expirationMonth;
}
public int getExpirationYear() {
	return expirationYear;
}
public void setExpirationYear(int expirationYear) {
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

}
