package project.object;

public class BookingHistory {
	String deplocation, destlocation, deptdate, confnumber;
	public BookingHistory(String confnumber, String deplocation, String destlocation,String deptdate) {
		this.confnumber = confnumber;
		this.deplocation = deplocation;
		this.destlocation = destlocation;
		this.deptdate = deptdate;
	}
	public String getDeplocation() {
		return deplocation;
	}
	public String getDestlocation() {
		return destlocation;
	}
	public String getDeptdate() {
		return deptdate;
	}
	public String getConfnumber() {
		return confnumber;
	}
}
