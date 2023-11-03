package pojoClasses;

import java.util.List;

public class NewOrdersGuestUser {

	private int userDevice;
	private int orderType;
	private List<NewOrdersEntryGuestUser> entry;

	public int getUserDevice() {
		return userDevice;
	}

	public void setUserDevice(int userDevice) {
		this.userDevice = userDevice;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public List<NewOrdersEntryGuestUser> getEntry() {
		return entry;
	}

	public void setEntry(List<NewOrdersEntryGuestUser> entry) {
		this.entry = entry;
	}

}
