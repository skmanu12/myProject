package pojoClasses;

public class CheckOutEntryGuestUser {
	private int locationCode;
	private String startAt;
	private String stopAt;
	private int quantity;
	private String reservationToken;
	private String isArriveIntegrationAbsent;
	private CheckOutEntryVehiclesInfoGuestUser vehicleInfo;

	public int getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public void setArriveIntegrationAbsent(String isArriveIntegrationAbsent2) {
		this.isArriveIntegrationAbsent = isArriveIntegrationAbsent2;
	}

	public CheckOutEntryVehiclesInfoGuestUser getVehicleInfo() {
		return vehicleInfo;
	}

	public void setVehicleInfo(CheckOutEntryVehiclesInfoGuestUser vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

}
