import java.util.Date;

public class Register extends CourseSchedule {
  private int regiID;
  private boolean status;
  private String regiStart;
  public String memEmail;

  public Register(int courseCode, int CSid, int regiID, String memEmail, boolean status, String regiStart) {
    super(courseCode, CSid);
    this.regiID = regiID;
    this.memEmail = memEmail;
    this.status = false;
    this.regiStart = regiStart;
  }

	public int getRegiID() {
		return regiID;
	}

	public String getStatus() {
		if (this.status == true) {
			return "Approved";
		} else {
			return "Pending";
		}
	}

	public String getRegiStart() {
		return regiStart;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setRegiID(int regiID) {
		this.regiID = regiID;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void setRegiStart(String regiStart) {
		this.regiStart = regiStart;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

}
//Qikai 19034275