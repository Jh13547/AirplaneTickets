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
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public String getPrice() {
		return price;
	}
	public int getTicketsavialable() {
		return ticketsavialable;
	}
	public String getDes() {
		return des;
	}
	public String getDep() {
		return dep;
	}
	public Flights(String id, String des, String dep, String date, int ticketsavialable) {
		this.id = id;
		this.des = des;
		this.dep = dep;
		this.date = date;
		this.ticketsavialable = ticketsavialable;
		//okay this should be the end of the object class hopefull shit I need functions to get something else hold on
		
		
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTicketsavialable(int ticketsavialable) {
		this.ticketsavialable = ticketsavialable;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
