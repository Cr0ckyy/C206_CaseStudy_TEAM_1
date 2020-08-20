import java.util.Date;

public class Register extends CourseSchedule {
  private int regiID;
  private boolean status;
  private Date regiStart;
  private Date regiEnd;

  public Register(int courseCode, int CSid, double price, String startDate, String startTime, String endDate,
      String endTime, String location, int regiID, boolean status, Date regiStart, Date regiEnd) {
    super(courseCode, CSid, price, startDate, startTime, endDate, endTime, location);
    this.regiID = regiID;
    this.status = status;
    this.regiStart = regiStart;
    this.regiEnd = regiEnd;
  }

  public int getRegiID() {
    return regiID;
  }

  public void setRegiID(int regiID) {
    this.regiID = regiID;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Date getRegiStart() {
    return regiStart;
  }

  public void setRegiStart(Date regiStart) {
    this.regiStart = regiStart;
  }

  public Date getRegiEnd() {
    return regiEnd;
  }

  public void setRegiEnd(Date regiEnd) {
    this.regiEnd = regiEnd;
  }

}