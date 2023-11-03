package pojoClasses;

public class CheckOutEntryRegisteredUser {
private int locationCode;
private int quantity;
private String startAt;
private String stopAt;
private String reservationToken;
private String isArriveIntegrationAbsent;
private CheckOutEntryVehiclesInfoRegisteredUser vehicleInfo;

public int getLocationCode() {
	return locationCode;
}
public void setLocationCode(int locationCode) {
	this.locationCode = locationCode;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getStartAt() {
	return startAt;
}
public void setStartAt(String startAt) {
	this.startAt = startAt;
}
public String getStopAt() {
	return stopAt;
}
public void setStopAt(String stopAt) {
	this.stopAt = stopAt;
}
public String getReservationToken() {
	return reservationToken;
}
public void setReservationToken(String reservationToken) {
	this.reservationToken = reservationToken;
}
public String isArriveIntegrationAbsent() {
	return isArriveIntegrationAbsent;
}
public void setArriveIntegrationAbsent(String isArriveIntegrationAbsent) {
	this.isArriveIntegrationAbsent = isArriveIntegrationAbsent;
}
public CheckOutEntryVehiclesInfoRegisteredUser getVehicleInfo() {
	return vehicleInfo;
}
public void setVehicleInfo(CheckOutEntryVehiclesInfoRegisteredUser vehicleInfo) {
	this.vehicleInfo = vehicleInfo;
}

}
