package project.object;

public class Booking {

	String bookingid, uid, flightid;
	String amountbooked;

	
	String departure,destination, company,uid, flightid,amountbooked,bookingid;
	
	

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
	
	

	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Booking() {
		// TODO Auto-generated constructor stub
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
	public void setBookingid(String string) {
		this.bookingid = string;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setFlightid(String string) {
		this.flightid = string;
	}
	public void setAmountbooked(String amountbooked) {
		this.amountbooked = amountbooked;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
}
