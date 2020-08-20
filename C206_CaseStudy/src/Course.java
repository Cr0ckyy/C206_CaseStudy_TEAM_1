
public class Course extends CourseCategory{

	private int courseCode;
	private String courseTitle;
	private String courseDescription;
	private int courseDuration;
	private String prerequisiteCourse;
	
	public Course(int courseCode, String courseTitle, String courseCategory, String courseDescription, int courseDuration, String orerequisiteCourse) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
//		super(courseCategory);
		this.courseDescription = courseDescription;
		this.courseDuration = courseDuration;
		this.prerequisiteCourse = prerequisiteCourse;
	}
	
	public void viewCourse() {
//		String output = "";
//		output += String.format("%-12s %-20s %-25s %-30s %-15s %s", 
//				"Course ID", "Course Title", "Course Category", "Course Description", "Course Duration", "Prerequisite Course");
//		
	}
	
	public void deleteCourse(int courseCode) {
		
	}
}
