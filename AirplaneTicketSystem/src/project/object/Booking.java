package project.object;

public class Booking {
//TODO set up the logic for the booking model
	String bookingid, uid, flightid;
	String amountbooked;
	public Booking(String bookingid, String uid, String flightid, String amountbooked) {
		this.bookingid = bookingid;
		this.uid = uid;
		this.flightid = flightid;
		this.amountbooked = amountbooked;
		
	}
	public Booking(String uid, String flightid, String amountbooked) {
		this.uid = uid;
		this.flightid = flightid;
		this.amountbooked = amountbooked;
	}
	
	
	
	public String getBookingid() {
		return bookingid;
	}
	public String getUid() {
		return uid;
	}
	public String getFlightid() {
		return flightid;
	}
	public String getAmountbooked() {
		return amountbooked;
	}
	
	
}
