import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static ArrayList<CourseCategory> categoryList = new ArrayList<CourseCategory>();
	private static ArrayList<Course> courseList = new ArrayList<Course>();
	private static ArrayList<Member> memberList = new ArrayList<Member>();
	private static ArrayList<Register> regiList = new ArrayList<Register>();
	private static ArrayList<CourseSchedule> scheduleList = new ArrayList<CourseSchedule>();

	public static void main(String[] args) {
		
	}

	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// Hui Wen
	public static String retreiveAllMember(ArrayList<Member> memberList) {
		String output = "";
		for (Member i : memberList) {
			output += String.format("%-15s %-10s %-10d %-20s %-10s %-10s\n", i.getName(), i.getGender(), i.getMobile(),
					i.getEmail(), i.getDateOfbirth(), i.getCountryOfresidence());
		}
		return output;

	}

	// Hui Wen
	public static void viewAllMember(ArrayList<Member> memberList) {
		C206_CaseStudy.setHeader("MEMBER LIST");
		String output = String.format("%-15s %-10s %-10s %-20s %-10s %-10s\n", "Name", "Gender", "Mobile", "Email",
				"DOB", "Country of Residennce");
		output += retreiveAllMember(memberList);
		System.out.println(output);
	}

	// Hui Wen
	public static void inputMember() {
		String name = Helper.readString("Ënter name> ");
		String gender = Helper.readString("Enter gender> ");
		int moblie = Helper.readInt("Enter mobile> ");
		String email = Helper.readString("Enter email> ");
		String dob = Helper.readString("Enter date of birth (dd/mm/yyyy)> ");
		String cor = Helper.readString("Enter country of residence> ");
		String password = Helper.readString("Enter password> ");

		Member mb = new Member(name, gender, moblie, email, dob, cor, password);
		addMember(memberList, mb);
	}

	// Hui Wen
	public static void addMember(ArrayList<Member> memberList, Member mb) {
		boolean isAdded = true;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getEmail() == mb.getEmail())
				isAdded = false;
		}
		if (isAdded == false) {
			System.out.println("Email must be unique");
		} else {
			memberList.add(mb);
			System.out.println("Member added");
		}
	}

	// Hui Wen
	public static boolean dodeleteMember(ArrayList<Member> memberList, String email) {

		boolean isDeleted = false;

		for (int i = 0; i < memberList.size(); i++) {
			String EmailAddress = memberList.get(i).getEmail();
			if (email.contentEquals(EmailAddress)) {
				memberList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	// Hui Wen
	public static void deletetMember(ArrayList<Member> memberList) {

		C206_CaseStudy.viewAllMember(memberList);
		String email = Helper.readString("Enter the Member's email to delete> ");
		boolean isDeleted = dodeleteMember(memberList, email);

		if (isDeleted == false) {
			System.out.println("Invalid email");
		} else {
			System.out.println("Member " + email + "  deleted");
		}

	}

	// LI SHUFANG
	  public static void addCourseCategory(ArrayList<CourseCategory> categoryList) {
	    System.out.println("-----------ADD COURSE CATEGORY-----------------");
	    var courseCategoryName = Helper.readString("Enter Course Category: ");
	    var courseCategoryDescription = Helper.readString("Enter Course Category Description: ");
	    var newCC = new CourseCategory(courseCategoryName, courseCategoryDescription);
	    categoryList.add(newCC);
	  }

	  // LI SHUFANG
	  public static void deleteCourseCategory(ArrayList<CourseCategory> categoryList) {
	    System.out.println("-----------DELETE COURSE CATEGORY-----------------");
	    var searchCategory = Helper.readString("Enter the name of the category you want to delete: ");
	    for (int i = 0; i < categoryList.size(); i++) {
	      if (categoryList.get(i).getCategoryName().equalsIgnoreCase(searchCategory)) {
	        var deletion = Helper.readString("Are you sure that you want to delete this category? (Y/N) > ");
	        if (deletion.equalsIgnoreCase("Y")) {
	          categoryList.remove(i);
	        } else {
	          System.out.println("Error in category deletion.");
	        }
	        return;
	      }
	    }
	    System.out.println("Categories not found.");

	  }

	  // LI SHUFANG
	  public static void viewCourseCategory(ArrayList<CourseCategory> categoryList) {
	    System.out.println("-----------VIEW COURSE CATEGORY-----------------");
	    System.out.println(String.format("%-20s, %-30s", "COURSE CATEGORY", "DESCRIPTION"));
	    for (var i : categoryList) {
	      System.out.println(String.format("%-20s, %-30s", i.getCategoryName(),
	          i.getCategoryDescription()));
	    }
	  }

	// Ju Long
	public static void addCourse() {
		int id = courseList.size() + 1;
		String title = Helper.readString("Enter Course Name: ");
		String category = Helper.readString("Enter Course Category Name: ");
		String description = Helper.readString("Enter Course Description (less than 50 characters): ");
		int duration = Helper.readInt("Enter Course Duration(Days): ");
		String prerequisite = Helper.readString("Enter Course Condition: ");

		Course course = new Course(id, title, category, description, duration, prerequisite);
		doAddCourse(courseList, course);
	}

	// Ju Long
	public static void doAddCourse(ArrayList<Course> courseList, Course course) {
		boolean isRepeated = false;

		for (Course i : courseList) {
			if (i.getCourseCode() != course.getCourseCode())
				isRepeated = true;
		}

		if (!isRepeated) {
			courseList.add(course);
			System.out.println("Course has been added");
		} else {
			System.out.println("The Course Code have been repeated, please enter again!");
			addCourse();
		}
	}

	// Ju Long
	public static String viewCourse(ArrayList<Course> courseList) {
		String output = "";
		output += String.format("%-10s | %-15s | %-20s | %-50s | %-15s | %s\n", "Course ID", "Course Title", "Course Category",
				"Course Description", "Course Duration", "Pre-requisite Course");
		if (!courseList.isEmpty()) {
			for (Course i : courseList) {
				output += String.format("%-10d | %-15s | %-20s | %-50s | %-15d | %s\n", i.getCourseCode(), i.getCourseTitle(),
						i.getCourseCategory(), i.getCourseDescription(), i.getCourseDuration(), i.getPrerequisiteCourse());
			}
		}
		return (output);
	}
	
	// Ju Long
	public static void deleteCourse() {
		System.out.println(viewCourse(courseList));
		int id = Helper.readInt("Enter Course ID: ");
		
		doDeleteCourse(courseList, id);
	}
	
	// Ju Long
	public static void doDeleteCourse(ArrayList<Course> courseList, int courseID) {
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseCode() == courseID) {
				courseList.remove(i);
				System.out.println("Course has been removed");
			}
		}
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
		idList.add(scheduleID);
		
		CourseSchedule sch = new CourseSchedule(courseID, scheduleID, price, startDate, startTime, endDate, endTime, location);
		scheduleList.add(sch);
	}
	
	//Alicia
	public static String viewCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String output = "";
		
		if(scheduleList.size()==0) {
			output += "There are no schedules to display";
		}else {
			output += String.format("%-13s %-12s %-11s %-11s %-10s %-9s %-10s", "Schedule ID",
					"Start Date", "Start Time", "End Date", "End Time", "Price", "Location");
			
			for(CourseSchedule i : scheduleList) {
				output += String.format("\n%5d %18s %11s %12s %8s %7.2f %14s", i.getCSid(), i.getStartDate(),
						i.getStartTime(), i.getEndDate(), i.getEndTime(), i.getPrice(), i.getLocation());
			}
		}
		return output;
	}
	
	//Alicia
	public static void deleteCourseSchedule() {
		viewCourseSchedule(scheduleList);
		int scheduleID = Helper.readInt("Enter Schedule ID: ");
		
		for(CourseSchedule i: scheduleList) {
			if(i.getCSid()==scheduleID) {
				scheduleList.remove(i);
			}
		}
		System.out.println("Course Schedule has been deleted.");
	}
	
	// Qi Kai
	  public static void registerCS() {
	    int courseCode = Helper.readInt("Enter Course code: ");
	    int CSid = Helper.readInt("Enter course Schedule ID: ");
	    int regiID = regiList.size() + 1;
	    String memEmail = Helper.readString("Enter Email: ");
	    boolean status = false;
	    LocalDateTime regiDate = LocalDateTime.now();
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	    String formattedDate = regiDate.format(format);

	    regiList.add(new Register(courseCode, CSid, regiID, memEmail, status, formattedDate));
	    System.out.println("A confirmation E-mail has been sent to your" + memEmail + " mailbox");
	  }

	  // Qi kai
	  public static String viewRegister(ArrayList<Register> regiList) {

	    String output = String.format("%-20s %-20s %-20s %-20s %-20s\n", "Registration ID", "Course Schedule ID",
	        "Member Email", "Status", "Registration Date & time");
	    output += retrieveRegiList(regiList);
	    return output;
	  }

	  // Qikai
	  public static String retrieveRegiList(ArrayList<Register> regiList) {

	    String output = "";
	    for (int i = 0; i < regiList.size(); i++) {
	      output += String.format("%-20s %-20s %-20s %-20s %-20s\n", regiList.get(i).getRegiID(),
	          regiList.get(i).getCSid(), regiList.get(i).getMemEmail(), regiList.get(i).getStatus(),
	          regiList.get(i).getRegiDate());
	    }
	    return output;
	  }

	  // Qi kai
	  public static String deleRegi() {
	    int deleRegi = Helper.readInt("Enter your registration ID: ");
	    String output="";
	    for (int i = 0; i < regiList.size(); i++) {
	      if (regiList.get(i).getRegiID() == deleRegi) {
	        regiList.remove(i);
	        output+=("Registration has been deleted");
	        System.out.println("An Email has been sent to your mailbox");
	      }

	    }
	    return output;
	  }

	}