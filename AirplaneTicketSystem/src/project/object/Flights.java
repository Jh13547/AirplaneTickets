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
	
	public Flights(String departure, String destination, String companyName, int ticketsavailable, String destinationDate, String departureDate) {
		this.departure = departure;
		this.destination = destination;
		this.companyName = companyName;
		this.destinationDate = destinationDate;
		this.departureDate = departureDate;
		this.ticketsavialable = ticketsavailable;
	}
}
