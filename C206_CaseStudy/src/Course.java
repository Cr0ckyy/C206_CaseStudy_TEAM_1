
public class Course extends CourseCategory {

	private int courseCode;
	private String courseTitle;
	private String courseDescription;
	private int courseDuration;
	private String prerequisiteCourse;

	public Course (int courseCode, String courseTitle, String courseCategory, String courseDescription,
			int courseDuration, String prerequisiteCourse) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
//		super(courseCategory);
		this.courseDescription = courseDescription;
		this.courseDuration = courseDuration;
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
	
//	public String getCourseCategory() {
//		return super.getCourseCategory();
//	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public String getPrerequisiteCourse() {
		return prerequisiteCourse;
	}

}
// JU LONG