import java.util.*;

public class CourseSchedule{
	private int CSid;
	private double price;
	private Date startDateTime;
	private Date endDateTime;
	private String location;

	public CourseSchedule(int CSid, double price, Date startDateTime, Date endDateTime, String location) {
		this.CSid = CSid;
		this.price = price;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.location = location;
	}

	public int getCSid() {
		return CSid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}
	
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
//Lim Mae Yee Alicia