package project.object;

public class Planes 
//Plane datatype with getters and setters
{


	String compname,  planetype;
	int ttlseats;
	
	public Planes(String compname, int ttlseats, String planetype) {
		this.compname = compname;
		this.ttlseats = ttlseats;
		this.planetype = planetype;
	}
	
	public void setCompname(String compname) {
		this.compname = compname;
	}

	public void setPlanetype(String planetype) {
		this.planetype = planetype;
	}

	public void setTtlseats(int ttlseats) {
		this.ttlseats = ttlseats;
	}

	public String getCompname() {
		return compname;
	}

	public String getPlanetype() {
		return planetype;
	}

	public int getTtlseats() {
		return ttlseats;
	}
	
	
}
