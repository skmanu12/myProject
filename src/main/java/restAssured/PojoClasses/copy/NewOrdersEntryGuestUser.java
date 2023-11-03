package pojoClasses;

public class NewOrdersEntryGuestUser {
	private int locationCode;
	private String startAt;
	private String stopAt;
	private int quantity;

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

}
