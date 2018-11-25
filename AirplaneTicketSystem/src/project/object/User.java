package project.object;

public class User {
	
	//this class should be done
	//two instanciation methods one for creation, the other for using the id to find booked flights with the user
	String id, firstName, lastName, email, password;
	boolean admin=false;
	
	
	public User(String firstName, String lastName, String email, String password,boolean admin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.admin=admin;
	}
	
	public User(String id, String firstName, String lastName, String email, String password,boolean admin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.admin=admin;
		this.id = id;
	}
	
	public User(){
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
	};
	
	public String id() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String toString() {
		return id+"#"+firstName+"#"+lastName+"#"+email;
		
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getAdmin() {
		return admin;}
}
