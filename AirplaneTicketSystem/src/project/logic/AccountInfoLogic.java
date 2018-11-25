package project.logic;

import project.object.Airport;
import project.object.Booking;
import project.object.Companies;
import project.object.Flights;
import project.object.Planes;
import project.object.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.db.*;

public class AccountInfoLogic {
	DbAccessImpl db = new DbAccessImpl();
	
	public User getUserInfo(String id) {
		User userInfo = new User();
		
		//Returns a user with email, first name and last name
		db.connect();
		ResultSet rs = db.retrieve("Select firstname,lastname, uemail from login where uid="+ id +";");
		try {
			while(rs.next()) {
			userInfo.setFirstName(rs.getString("firstname"));
			userInfo.setLastName(rs.getString("lastname"));
			userInfo.setEmail(rs.getString("uemail"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("UID might not exist");
		}
		db.disconnect();
		return userInfo;
	}
	
	public ArrayList<Booking> getBookings(String id) {
		
		ArrayList<Booking> bookinglist = new ArrayList<Booking>();
		
		db.connect();
		ResultSet rs = db.retrieve("Select confnumber,flightid,AmountBooked from bookedflights where uid="+ id +";");
		try {
			while(rs.next()) {
			Booking booking = new Booking();
			booking.setBookingid(rs.getString("confnumber"));
			booking.setFlightid(rs.getString("flightid"));
			booking.setAmountbooked(rs.getString("AmountBooked"));
			bookinglist.add(booking);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("UID might not exist");
		}
		db.disconnect();
		return bookinglist;
	}
	
	//Returns a destination and departure locations from flight id
	public String[] getFlightInfo(String id) {
		
		String[] flightInfo = new String[3];
		
		
		db.connect();
		ResultSet rs = db.retrieve("SELECT f.flightid, a.citytag as Destination, a2.citytag as Departure " + 
				"FROM flights f, airport a, airport a2 " + 
				"where f.airportDES = a.airportid " + 
				"AND f.airportDEP = a2.airportid " + 
				"AND f.flightid ='"+ id +"';");
		try {
			while(rs.next()) {
			flightInfo[0] = rs.getString("Departure");
			flightInfo[1] = rs.getString("Destination");
			flightInfo[2] = rs.getString("flightid");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("UID might not exist");
		}
		db.disconnect();
		return flightInfo;
	}
	
	//Returns a company from flight id
	public String getCompany(String id) {
	String comp = null;
	db.connect();
	
	ResultSet rs = db.retrieve("SELECT f.planeid,f.flightid, c.compname\r\n" + 
			"FROM flights f, planecomp c, planes p\r\n" + 
			"where f.planeid= p.planeid\r\n" + 
			"AND c.compid = p.compid\r\n" + 
			"AND f.flightid ='"+ id +"';");
	try {
		
		while(rs.next()) {
		 comp = rs.getString("compname");
		}
	}catch(SQLException e) {
		e.printStackTrace();
		System.out.println("FlightId might not exist");
	}
	db.disconnect();
	return comp;
	}
	
	
	
	
		
}
