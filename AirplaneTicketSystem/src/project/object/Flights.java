package project.object;

import java.sql.Date;

public class Flights {
	//TODO set up Flights data object
	String id;
	Date date;
	int ticketsavialable;
	
	public Flights(String id, Date date, int ticketsavailable) {
		this.id  = id;
		this.date = date;
		this.ticketsavialable = ticketsavailable;
	}
}
