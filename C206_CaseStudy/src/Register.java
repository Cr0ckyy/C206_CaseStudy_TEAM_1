public class Register extends CourseSchedule {
	private int regiID;
	private boolean status;
	private String regiDate;
	public String memEmail;
	private boolean statuscancel;

	public Register(int courseCode, int CSid, int regiID, String memEmail, boolean status, String regiDate) {
		super(courseCode, CSid);
		this.regiID = regiID;
		this.memEmail = memEmail;
		this.status = status;
		this.statuscancel = false;
		this.regiDate = regiDate;
	}

	public String isStatuscancel() {
		if (this.statuscancel) {
			return "Cancelled";
		} else {
			return "Accepted";
		}

	}

	public void setStatuscancel(boolean statuscancel) {
		this.statuscancel = statuscancel;
	}

	public int getRegiID() {
		return regiID;
	}

	public String getStatus() {
		if (status == true) {
			return "Pending";
		} else {
			return "Cancelled";
		}
	}

	public String getRegiDate() {
		return regiDate;
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

	public void setRegiStart(String regiDate) {
		this.regiDate = regiDate;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

}
//Qikai 19034275