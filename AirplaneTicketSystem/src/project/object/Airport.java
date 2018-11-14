package project.object;

public class Airport {
//TODO set up the logic for the Airport model
	String city, state, country;
	public Airport(String city, String state, String country) {
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	

}
