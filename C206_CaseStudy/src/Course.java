
public class Course {

	private int courseCode;
	private String courseTitle;
	private String courseCategory;
	private String courseDescription;
	private String courseStartDate;
	private String courseEndDate;
	private String prerequisiteCourse;

	public Course (int courseCode, String courseTitle, String courseCategory, String courseDescription,
			String courseStartDate, String courseEndDate, String prerequisiteCourse) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.courseCategory = courseCategory;
		this.courseDescription = courseDescription;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.prerequisiteCourse = prerequisiteCourse;
	}
	
	public Course (int courseCode) {
		this.courseCode = courseCode;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}
	
	public String getCourseCategory() {
		return courseCategory;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public String getCourseStartDate() {
		return courseStartDate;
	}

	public String getCourseEndDate() {
		return courseEndDate;
	}

	public String getPrerequisiteCourse() {
		return prerequisiteCourse;
	}

}
// JU LONG 19013345