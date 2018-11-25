package project.object;

import java.sql.Date;

public class Flights {
	//TODO set up Flights data object
	String id;

	String departure;
	String destination;
	String companyName;
	int ticketsavialable;
	String destinationDate;
	String departureDate;
	String price;
	
	public Flights(String departure, String destination, String companyName, int ticketsavailable, String destinationDate, String departureDate) {
		this.departure = departure;
		this.destination = destination;
		this.companyName = companyName;
		this.destinationDate = destinationDate;
		this.departureDate = departureDate;
		this.ticketsavialable = ticketsavailable;
		
	}
	public Flights(String departure, String destination, String departureDate) {
		this.departure = departure;
		this.destination = destination;
		this.departureDate = departureDate;
	}
	public Flights(String id,String departure, String destination, String companyName) {
		this.departure = departure;
		this.destination = destination;
		this.companyName=companyName;
		this.id=id;
	}
	public Flights(String id, String departureDate, int ticketsAvailable, String price) {
		this.id = id;
		this.departureDate = departureDate;
		this.ticketsavialable = ticketsavialable;
		this.price = price;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getId() {
		return id;
	}

	public String getDeparture() {
		return departure;
	}

	public String getDestination() {
		return destination;
	}

	public String getCompanyName() {
		return companyName;
	}

	public int getTicketsavialable() {
		return ticketsavialable;
	}

	public String getDestinationDate() {
		return destinationDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setTicketsavialable(int ticketsavialable) {
		this.ticketsavialable = ticketsavialable;
	}

	public void setDestinationDate(String destinationDate) {
		this.destinationDate = destinationDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
}
