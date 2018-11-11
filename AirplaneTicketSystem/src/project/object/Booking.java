package project.object;

public class Booking {
//TODO set up the logic for the booking model
	int bookingid, uid, flightid;
	double amountbooked;
	public Booking(int bookingid, int uid, int flightid, double amountbooked) {
		this.bookingid = bookingid;
		this.uid = uid;
		this.flightid = flightid;
		this.amountbooked = amountbooked;
		
	}
	public int getBookingid() {
		return bookingid;
	}
	public int getUid() {
		return uid;
	}
	public int getFlightid() {
		return flightid;
	}
	public double getAmountbooked() {
		return amountbooked;
	}
	
	
}
