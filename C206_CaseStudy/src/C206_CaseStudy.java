import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static ArrayList<Course> courseList = new ArrayList<Course>();

	public static void main(String[] args) {
		
		
		
	}
	
	public static void addCourse() {
		
	}

	public static void viewCourse() {
		String output = "";
		output += String.format("%-10s %-15s %-20s %-50s %-15d %s", 
				"Course ID", "Course Title", "Course Category", "Course Description", "Course Duration", "Pre-requisite Course");
		for (Course i : courseList) {
			output += String.format("%-10d %-15s %-20s %-50s %-15s %s", 
					i.getCourseCode(), i.getCourseTitle()/*, i.getCourseCategory()*/, i.getCourseDescription(), i.getCourseDuration(), i.getPrerequisiteCourse());
		}
		System.out.println(output);
	}
}
