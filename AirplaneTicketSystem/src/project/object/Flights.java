package project.object;

import java.sql.Date;

public class Flights {
	//TODO set up Flights data object
	String id;
	Date date;
	int ticketsavialable;
	String des;
	String dep;
	
	public Flights(String id, Date date, int ticketsavailable) {
		this.id  = id;
		this.date = date;
		this.ticketsavialable = ticketsavailable;
	}
	public Flights(String id, String des, String dep, Date date, int ticketsavialable) {
		this.id = id;
		this.des = des;
		this.dep = dep;
		this.date = date;
		this.ticketsavialable = ticketsavialable;
		//okay this should be the end of the object class hopefull shit I need functions to get something else hold on
		
		
	}
	
}
