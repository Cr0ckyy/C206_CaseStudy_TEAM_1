import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static ArrayList<Course> courseList = new ArrayList<Course>();

	public static void main(String[] args) {
		
	}
	
	public static void addCourse() {
		int id = Helper.readInt("Enter Course ID: ");
		String title = Helper.readString("Enter Course Name: ");
		String category = Helper.readString("Enter Course Category: ");
		String description = Helper.readString("Enter Course Description (less than 50 characters): ");
		int duration = Helper.readInt("Enter Course Duration(Days): ");
		String prerequisite = Helper.readString("Enter Course Condition: ");
		
		courseList.add(new Course(id, title, category, description, duration, prerequisite));
		System.out.println("Course has been added");
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
	
	public static void deleteCourse() {
		int id = Helper.readInt("Enter Course ID: ");
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseCode() == id) {
				courseList.remove(i);
			}
		}
		System.out.println("Course has been removed");
	}
}
