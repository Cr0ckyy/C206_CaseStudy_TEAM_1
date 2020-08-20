import java.util.*;

public class CourseSchedule extends Course{
	private int CSid;
	private double price;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	private String location;

	public CourseSchedule(int courseCode, int CSid, double price, String startDate, String startTime, String endDate, String endTime, String location) {
		super(courseCode);
		this.CSid = CSid;
		this.price = price;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.location = location;
	}
	
	public CourseSchedule(int courseCode, int CSid) {
		super(courseCode);
		this.CSid = CSid;
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

	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
//Lim Mae Yee Alicia