import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {
	
	private static ArrayList<CourseCategory> categoryList = new ArrayList<CourseCategory>();
	private static ArrayList<Course> courseList = new ArrayList<Course>();
	private static ArrayList<Member> memberList = new ArrayList<Member>();
	private static ArrayList<Register> regiList = new ArrayList<Register>();
	private static ArrayList<CourseSchedule> scheduleList = new ArrayList<CourseSchedule>();

	public static void main(String[] args) {
		
	}
	
	//Hui Wen
	public static void addMember() {
        Helper.line(40,"=");
        System.out.println("ADD NEW MEMBER");
        Helper.line(40,"=");
        String name = Helper.readString("Ënter name> ");
        String gender = Helper.readString("Enter gender> ");
        int moblie = Helper.readInt("Enter mobile> ");
        String email = Helper.readString("Enter email> ");
        String dob = Helper.readString("Enter date of birth (dd/mm/yy)> ");
        String cor = Helper.readString("Enter country of residence> ");
        String password = Helper.readString("Enter password");
       
        for (Member i : memberList) {
            if (!i.getEmail().contains(email)) {
                memberList.add(new Member(name,gender,moblie,email,dob,cor,password));
            }else {
                System.out.println("Email must be unique");
            }
        }
       
    }
	
	//Hui Wen
    public static void viewMember() {
        String output = "";
        output += String.format("%-15s %-10s %-10s %-20s %-10s %-10s", "Name","Gender","Mobile", "Email", "DOB", "Country of Residennce");
       
        for (Member i : memberList) {
            output += String.format("%-15s %-10s %-10d %-20s %-10s %-10s",
                    i.getName(), i.getGender(),i.getMobile(),i.getEmail(),i.getDateOfbirth(),i.getCountryOfresidence());
        }
        System.out.println(output);
       
    }
    
	//Hui Wen
    public static void deleteMember(){
        String ed = Helper.readString("Enter the Member's email to delete> ");
        for (Member i : memberList) {
            if (i.getEmail().contentEquals(ed)) {
                memberList.remove(i);
            }
        }
    }
	
 // LI SHUFANG
    public static void addCategory() {
      var name = Helper.readString("Enter Course Category Name: ");
      var description = Helper.readString("Enter Course Category Description: ");
      for (var i : categoryList) {
        if (i.getCategoryName() != name) {
          categoryList.add(new CourseCategory(name, description));
          System.out.println("The Course Category has been added");
        } else {
          System.out.println("The Category Name have been repeated, please enter again!");
          addCategory();
        }
      }
    }
    
	// LI SHUFANG
	public static void viewCategory() {
		var output = "";
		output += String.format("%-10s %-15s", "Category name", "Category description");
		for (var i : categoryList) {
			output += String.format("%-10d %-15s", i.getCategoryName(), i.getCategoryDescription());
		}
		System.out.println(output);
	}

	// LI SHUFANG
	@SuppressWarnings("unlikely-arg-type")
	public static void deleteCategory() {
		var cc = Helper.readString("Enter the Course Category to delete> ");
		for (var i : categoryList) {
			if (i.getCategoryName().equalsIgnoreCase(cc)) {
				courseList.remove(cc);
			}

		}
	}
    
	//Ju Long
	public static void addCourse() {
		int id = courseList.size() + 1;
		String title = Helper.readString("Enter Course Name: ");
		String category = Helper.readString("Enter Course Category Name: ");
		String description = Helper.readString("Enter Course Description (less than 50 characters): ");
		int duration = Helper.readInt("Enter Course Duration(Days): ");
		String prerequisite = Helper.readString("Enter Course Condition: ");
		
		for (Course i : courseList) {
			if (i.getCourseCode() != id) {
				courseList.add(new Course(id, title, category, description, duration, prerequisite));
				System.out.println("Course has been added");
			} else {
				System.out.println("The Course Code have been repeated, please enter again!");
				addCourse();
			}
		}
		
	}

	//Ju Long
	public static String viewCourse() {
		String output = "";
		output += String.format("%-10s %-15s %-20s %-50s %-15d %s", 
				"Course ID", "Course Title", "Course Category", "Course Description", "Course Duration", "Pre-requisite Course");
		for (Course i : courseList) {
			output += String.format("%-10d %-15s %-20s %-50s %-15s %s", 
					i.getCourseCode(), i.getCourseTitle(), i.getCourseCategory(), i.getCourseDescription(), i.getCourseDuration(), i.getPrerequisiteCourse());
		}
		return (output);
	}
	
	//Ju Long
	public static void deleteCourse() {
		System.out.println(viewCourse());
		int id = Helper.readInt("Enter Course ID: ");
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseCode() == id) {
				courseList.remove(i);
			}
		}
		System.out.println("Course has been removed");
	}
	
	//Alicia
	public static void addCourseSchedule() {
		String output = "";
		output += String.format("%-10s %-15s", "Course ID", "Course Title");
		
		for(Course i : courseList) {
			output += String.format("%-10d %-15s", i.getCourseCode(), i.getCourseTitle());
		}
		System.out.println(output);
		
		int courseID = Helper.readInt("Enter Course ID: ");
		double price = Helper.readDouble("Enter Price: ");
		String startDate = Helper.readString("Enter Start Date(DD/MM/YYYY): ");
		String startTime = Helper.readString("Enter Start Time(HH:MM)AM/PM: ");
		String endDate = Helper.readString("Enter End Date(DD/MM/YYYY): ");
		String endTime = Helper.readString("Enter End Time(HH:MM)AM/PM: ");
		String location = Helper.readString("Enter Location: ");
		
		ArrayList<Integer> idList = new ArrayList<Integer>();
		int scheduleID = 0;
		
		if(idList.size()==0) {
			scheduleID = idList.size()+1;
		}else {
			while(idList.contains(scheduleID)) {
				scheduleID +=1;
			}
		}
		
		CourseSchedule sch = new CourseSchedule(courseID, scheduleID, price, startDate, startTime, endDate, endTime, location);
		scheduleList.add(sch);
	}
	
	//Alicia
	public static void viewCourseSchedule() {
		String output = "";
		
		if(scheduleList.size()==0) {
			output += "There are no schedules to display";
		}else {
			output += String.format("%-10s %-10s %-15s %-20s %-20s %-15s %-10s", "Schedule ID",
					"Start Date", "Start Time", "End Date", "End Time", "Price", "Location");
			
			for(CourseSchedule i : scheduleList) {
				output += String.format("%-10d %-10s %-15s %-20s %-20s %-15d %-10s", i.getCSid(), i.getStartDate(),
						i.getStartTime(), i.getEndDate(), i.getEndTime(), i.getPrice(), i.getLocation());
			}
		}
		System.out.println(output);
	}
	
	//Alicia
	public static void deleteCourseSchedule() {
		
	}
	
	// Qi Kai
	public static void registerCS() {
		int courseCode = Helper.readInt("Enter Course code: ");
		int CSid = Helper.readInt("Enter course Schedule ID: ");
		int regiID = regiList.size() + 1;
		String memEmail = Helper.readString("Enter Email: ");
		LocalDateTime regiDate = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String formattedDate = regiDate.format(format);
		regiList.add(new Register(courseCode, CSid, regiID, memEmail, false, formattedDate));
	}

	//Qi Kai
	public static void viewRegister() {
		String output = "";
		output += String.format("%-20s %-20s %-20s %-50s %-20s", "Registration ID", "Course Schedule ID",
				"Member Email", "Status", "Registration Date & time");
		for (Register i : regiList) {
			output += String.format("%-20d %-20d %-20s %-50s %-20s", i.getRegiID(), i.getCSid(), i.getMemEmail(),
					i.getStatus(), i.getRegiDate());
		}
		System.out.println(output);

	}

	//Qi Kai
	public static void deleRegi() {
		int deleRegi = Helper.readInt("Enter your registration ID: ");
		for (int i = 0; i < regiList.size(); i++) {
			if (regiList.get(i).getRegiID() == deleRegi) {
				regiList.remove(i);
				System.out.println("Registration has been deleted");
			}

		}
	}

}