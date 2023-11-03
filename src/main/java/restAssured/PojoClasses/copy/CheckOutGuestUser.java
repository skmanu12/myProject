package pojoClasses;

import java.util.List;

public class CheckOutGuestUser {
	private int userDevice;
	private int purchaseType;
	private List<CheckOutEntryGuestUser> entry;
	private CheckOutPaymentGuestUser payment;
	
	public int getUserDevice() {
		return userDevice;
	}
	public void setUserDevice(int userDevice) {
		this.userDevice = userDevice;
	}
	public int getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(int purchaseType) {
		this.purchaseType = purchaseType;
	}
	public List<CheckOutEntryGuestUser> getEntry() {
		return entry;
	}
	public void setEntry(List<CheckOutEntryGuestUser> entry) {
		this.entry = entry;
	}
	public CheckOutPaymentGuestUser getPayment() {
		return payment;
	}
	public void setPayment(CheckOutPaymentGuestUser payment) {
		this.payment = payment;
	}
	


}
