
public class Course extends CourseCategory{

	private int courseCode;
	private String courseTitle;
	private String courseDescription;
	private int courseDuration;
	private String prerequisiteCourse;
	
	public Course(int courseCode, String courseTitle, String courseName, String courseDescription, int courseDuration, String orerequisiteCourse) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		super(courseName);
		this.courseDescription = courseDescription;
		this.courseDuration = courseDuration;
		this.prerequisiteCourse = prerequisiteCourse;
	}
	
	public void viewCourse() {
		
	}
	
	public void deleteCourse(int courseCode) {
		
	}
}
