package pojoClasses;

import java.util.List;

public class CheckOutRegisteredUser {
private int deviceType;
private int orderType;
private int saleType;
private List<CheckOutEntryRegisteredUser> entry;
private CheckOutPaymentRegisteredUser payment;

public int getDeviceType() {
	return deviceType;
}
public void setDeviceType(int deviceType) {
	this.deviceType = deviceType;
}
public int getOrderType() {
	return orderType;
}
public void setOrderType(int orderType) {
	this.orderType = orderType;
}
public int getSaleType() {
	return saleType;
}
public void setSaleType(int saleType) {
	this.saleType = saleType;
}
public List<CheckOutEntryRegisteredUser> getEntry() {
	return entry;
}
public void setEntry(List<CheckOutEntryRegisteredUser> entry) {
	this.entry = entry;
}
public CheckOutPaymentRegisteredUser getPayment() {
	return payment;
}
public void setPayment(CheckOutPaymentRegisteredUser payment) {
	this.payment = payment;
}

}
