package project.logic;

import project.object.Airport;
import project.object.Booking;
import project.object.Companies;
import project.object.Flights;
import project.object.Planes;
import project.object.User;

import java.util.ArrayList;
import java.util.List;

import project.db.*;

public class LoginLogic {
	DbAccessImpl db = new DbAccessImpl();
	
	//method to allow user sign up 
	public boolean signUp(User u) {
		
		//set up query for creating a new user
		String query = "Insert into login(firstname, lastname, upass, uemail, isadmin) values " +
						"( \"" + u.getFirstName() + "\" , \"" + u.getLastName() + "\" , \"" + u.getPassword() +
						"\" , \"" + u.getEmail() + "\" , 0);";
		
		//db stuff call connect and disconnect before and after
		db.connect();
		int j = db.create(query);
		db.disconnect();
		
		//if success create of one user return true in the program
		if(j == 1) {
			return true;
		}
		
		//did nto successfully create a user
		else
			return false;
	}
	
	
	public String login(User u) {
		//TODO login logic should return user id to be used in session tracking
		String query;
		String userID = null;
		return userID;
		
	}
	
	public List<Flights> rtnFlightList(String dep, String des, int month, int day, int year, int ticketsrequested){
		//TODO create a function to return a list of flights to use in creationg
		List<Flights> lf = new ArrayList<>();
		return lf;
		
	}
	public boolean createFlight(Flights f) {
		//TODO create a function to insert a flight in database return if the create worked or not
		return true;
	}
	
	public boolean createPlane(Planes p) {
		//TODO create function insert a new plane
		
		return true;
	}
	
	public boolean createCompany(Companies c) {
		//TODO create function to insert a new company
		return true;
	}
	public boolean createBooking(Booking b) {
		//TODO create function to insert new booking into the system
		return true;
	}
	public boolean createAirport(Airport a) {
		//TODO create function to insert a new airport
		return true;
	}
	public List<Booking> getBookings(User u){
		//TODO create function to allow a user to retrieve his bookings
		
		
		List<Booking> lb = new ArrayList<>();
		return lb;
	}
	
	public boolean updatePassword(User u) {
		//TODO create functionality for a user to update his password
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
}
