import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {

	private static ArrayList<Member> memberList = new ArrayList<Member>();
	private static ArrayList<CourseCategory> categoryList = new ArrayList<CourseCategory>();
	private static ArrayList<Course> courseList = new ArrayList<Course>();
	private static ArrayList<CourseSchedule> scheduleList = new ArrayList<CourseSchedule>();
	private static ArrayList<Register> regiList = new ArrayList<Register>();

	private static final int LINES = 40;

	public static void main(String[] args) {
		// adding info into list
		memberList
				.add(new Member("John", "Male", 12345678, "john123@gmail.com", "23/08/1999", "Singapore", "password"));
		memberList.add(
				new Member("Cherly", "Female", 98765432, "cherly1@gmail.com", "18/11/1995", "Malaysia", "password"));
		memberList.add(new Member("Jack", "Male", 23456789, "jack99@gmail.com", "01/01/2000", "Singapore", "password"));

		categoryList.add(new CourseCategory("Information Technology", "we learn how to use computer"));
		categoryList.add(new CourseCategory("Sport", "we learn how body works"));
		categoryList.add(new CourseCategory("Engineering", "we learn everything"));

		courseList.add(new Course(1, "Mobile Software Development", "IT", "we learn coding", 70, "o-lvl score min 26"));
		courseList.add(new Course(2, "Sport Science", "Sport", "we learn body health", 70, "o-lvl score min 26"));
		courseList.add(new Course(3, "Electric Electronic Engineering", "Engineering", "we learn coding", 70,
				"o-lvl score min 26"));

		scheduleList.add(new CourseSchedule(1, 1, 100, "19/05/2020", "10:00", "19/05/2020", "16:00", "W64H"));
		scheduleList.add(new CourseSchedule(1, 2, 100, "20/05/2020", "10:00", "20/05/2020", "16:00", "W64H"));
		scheduleList.add(new CourseSchedule(2, 3, 100, "19/05/2020", "10:00", "19/05/2020", "16:00", "W14G"));

		regiList.add(new Register(1, 1, 1, "john123@gmail.com", true, "08/03/2020"));
		regiList.add(new Register(1, 1, 2, "cherly1@gmail.com", true, "08/03/2020"));
		regiList.add(new Register(1, 2, 3, "jack99@gmail.com", false, "23/04/2020"));

		int option = 0;

		while (option != -1) {
			int choice = 0;

			menu(option);
			option = Helper.readInt("Enter an Option (-1 to escape): ");
			System.out.println();
			menu(option);

			if (option == -1)
				break;
			// Member
			else if (option == 1) {
				choice = Helper.readInt("Enter a Choice: ");
				System.out.println();
				switch (choice) {
				case 1:
					inputMember();
					break;
				case 2:
					viewAllMember();
					break;
				case 3:
					// updateMember();
					break;
				case 4:
					// searchMember();
					break;
				case 5:
					// listCourseMember();
					break;
				case 6:
					deleteMember();
					;
					break;
				default:
					System.out.println("Invalid option");
				}
			}
			// CourseCategory
			else if (option == 2) {
				choice = Helper.readInt("Enter a Choice: ");
				System.out.println();
				switch (choice) {
				case 1:
					addCourseCategory();
					break;
				case 2:
					viewCourseCategory();
					break;
				case 3:
					// updateCourseCategory();
					break;
				case 4:
					// searchCourseCategory();
					break;
				case 5:
					// listCourseCategory();
					break;
				case 6:
					deleteCourseCategory();
					;
					break;
				default:
					System.out.println("Invalid option");
				}
			}
			// Course
			else if (option == 3) {
				choice = Helper.readInt("Enter a Choice: ");
				System.out.println();
				switch (choice) {
				case 1:
					addCourse();
					break;
				case 2:
					viewCourse();
					break;
				case 3:
					// updateCourse();
					break;
				case 4:
					// searchCourse();
					break;
				case 5:
					// listScheduleCourse();
					break;
				case 6:
					deleteCourse();
					;
					break;
				default:
					System.out.println("Invalid option");
				}
			}
			// Course Schedule
			else if (option == 4) {
				choice = Helper.readInt("Enter a Choice: ");
				System.out.println();
				switch (choice) {
				case 1:
					addCourseSchedule();
					break;
				case 2:
					viewCourseSchedule();
					break;
				case 3:
					// updateCourseSchedule();
					break;
				case 4:
					// searchCourseSchedule();
					break;
				case 5:
					// listScheduleMember();
					break;
				case 6:
					deleteCourseSchedule();
					break;
				default:
					System.out.println("Invalid option");
				}
			}
			// Regsitration
			else if (option == 5) {
				choice = Helper.readInt("Enter a Choice: ");
				System.out.println();
				switch (choice) {
				case 1:
					registerCS();
					break;
				case 2:
					viewRegister();
					break;
				case 3:
					// updateCourseSchedule();
					break;
				case 4:
					// searchCourseSchedule();
					break;
				case 5:
					// listScheduleMember();
					break;
				case 6:
					deleRegi();
					break;
				default:
					System.out.println("Invalid option");
				}
			}
			option = 0;
		}
	}

	private static void menu(int option) {
		if (option == 0) {
			Helper.line(40, "=");
			System.out.println("Course Management System");
			Helper.line(40, "=");
			System.out.println();
			System.out.println("Option 1: Member");
			System.out.println("Option 2: Course Category");
			System.out.println("Option 3: Course");
			System.out.println("Option 4: Course Schedule");
			System.out.println("Option 5: Register for Course");
			System.out.println();
		} else if (option == 1) {
			Helper.line(LINES, "-");
			System.out.println("Member");
			Helper.line(LINES, "-");
			System.out.println();
			System.out.println("Choice 1: Add Member");
			System.out.println("Choice 2: View Member");
			System.out.println("Choice 3: Update Member");
			System.out.println("Choice 4: Search Member");
			System.out.println("Choice 5: List Upcoming Course");
			System.out.println("Choice 6: Delete Member");
			System.out.println();
		} else if (option == 2) {
			Helper.line(LINES, "-");
			System.out.println("Course Category");
			Helper.line(LINES, "-");
			System.out.println();
			System.out.println("Choice 1: Add Category");
			System.out.println("Choice 2: View Category");
			System.out.println("Choice 3: Update Category");
			System.out.println("Choice 4: Search Category");
			System.out.println("Choice 5: List Category that have Course");
			System.out.println("Choice 6: Delete Course");
			System.out.println();
		} else if (option == 3) {
			Helper.line(LINES, "-");
			System.out.println("Course");
			Helper.line(LINES, "-");
			System.out.println();
			System.out.println("Choice 1: Add Course");
			System.out.println("Choice 2: View Course");
			System.out.println("Choice 3: Update Course");
			System.out.println("Choice 4: Search Course");
			System.out.println("Choice 5: List a Course's Schedule");
			System.out.println("Choice 6: Delete Course");
			System.out.println();
		} else if (option == 4) {
			Helper.line(LINES, "-");
			System.out.println("Course Schedule");
			Helper.line(LINES, "-");
			System.out.println();
			System.out.println("Choice 1: Add Schedule");
			System.out.println("Choice 2: View Schedule");
			System.out.println("Choice 3: Update Schedule");
			System.out.println("Choice 4: Search Schedule");
			System.out.println("Choice 5: List all Member that Register for the Schedule");
			System.out.println("Choice 6: Delete Schedule");
			System.out.println();
		} else if (option == 5) {
			Helper.line(LINES, "-");
			System.out.println("Course Registration");
			Helper.line(LINES, "-");
			System.out.println();
			System.out.println("Choice 1: Add Registration");
			System.out.println("Choice 2: View Registration");
			System.out.println("Choice 3: Update Registration");
			System.out.println("Choice 4: Search Registration");
			System.out.println("Choice 5: List all Schedule for a Member");
			System.out.println("Choice 6: Delete Registration");
			System.out.println();
		} else if (option == -1) {
			System.out.println("Have a nice day!");
		}
	}

	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(LINES, "-");
		System.out.println(header);
		Helper.line(LINES, "-");
	}

	// Hui Wen
	public static void viewAllMember() {
		C206_CaseStudy.setHeader("VIEW MEMBER");
		String output = String.format("%-15s %-10s %-10s %-20s %-10s %-10s\n", "Name", "Gender", "Mobile", "Email",
				"DOB", "Country of Residennce");
		output += retreiveAllMember(memberList);
		System.out.println(output);
		System.out.println();
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
	public static void inputMember() {
		C206_CaseStudy.setHeader("ADD MEMBER");
		String name = Helper.readString("Ënter name> ");
		String gender = Helper.readString("Enter gender> ");
		int moblie = Helper.readInt("Enter mobile> ");
		String email = Helper.readString("Enter email> ");
		String dob = Helper.readString("Enter date of birth (dd/mm/yyyy)> ");
		String cor = Helper.readString("Enter country of residence> ");
		String password = Helper.readString("Enter password> ");

		Member mb = new Member(name, gender, moblie, email, dob, cor, password);
		addMember(memberList, mb);
		System.out.println();
	}

	// Hui Wen
	public static void addMember(ArrayList<Member> memberList, Member mb) {
		boolean isAdded = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getEmail() == mb.getEmail())
				isAdded = true;
		}
		if (isAdded) {
			System.out.println("Email must be unique");
			System.out.println();
			inputMember();
		} else {
			memberList.add(mb);
			System.out.println("Member added");
		}
	}

	// Hui Wen
	public static void deleteMember() {
		C206_CaseStudy.setHeader("DELETE MEMBER");
		viewAllMember();
		String email = Helper.readString("Enter the Member's email to delete> ");
		boolean isDeleted = dodeleteMember(memberList, email);

		if (isDeleted == false) {
			System.out.println("Invalid email");
		} else {
			System.out.println("Member " + email + "  deleted");
		}
		System.out.println();
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

	// LI SHUFANG
	public static void addCourseCategory() {
		C206_CaseStudy.setHeader("ADD CATEGORY");
		var courseCategoryName = Helper.readString("Enter Course Category Name: ");
		var courseCategoryDescription = Helper.readString("Enter Course Category Description: ");
		var newCC = new CourseCategory(courseCategoryName, courseCategoryDescription);
		doAddCategory(categoryList, newCC);
		System.out.println();
	}

	// LI SHUFANG
	public static void doAddCategory(ArrayList<CourseCategory> categoryList, CourseCategory category) {
		boolean isunique = true;
		for (CourseCategory i : categoryList) {
			if (i.getCategoryName() == category.getCategoryName()) {
				isunique = false;
			}
		}

		if (isunique) {
			categoryList.add(category);
			System.out.println("Category added");
		} else {
			System.out.println("Name must be unique");
		}
	}

	// LI SHUFANG
	public static void viewCourseCategory() {
		C206_CaseStudy.setHeader("VIEW CATEGORY");
		System.out.println(String.format("%-50s %s", "COURSE CATEGORY", "DESCRIPTION"));
		System.out.println(doViewCourseCategory(categoryList));
		System.out.println();
	}

	// LI SHUFANG
	public static String doViewCourseCategory(ArrayList<CourseCategory> categoryList) {
		String output = "";
		for (var i : categoryList) {
			output += (String.format("%-50s %s", i.getCategoryName(), i.getCategoryDescription()));
		}
		return output;
	}

	// LI SHUFANG
	public static void deleteCourseCategory() {
		C206_CaseStudy.setHeader("DELETE CATEGORY");
		var searchCategory = Helper.readString("Enter the name of the category you want to delete: ");
		doDeleteCourseCategory(categoryList, searchCategory);
		System.out.println();
	}

	// LI SHUFANG
	public static void doDeleteCourseCategory(ArrayList<CourseCategory> categoryList, String categoryName) {

		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).getCategoryName().equalsIgnoreCase(categoryName)) {
				var deletion = Helper.readString("Are you sure that you want to delete this category? (Y/N) > ");
				if (deletion.equalsIgnoreCase("Y")) {
					categoryList.remove(i);
					System.out.println("Category have been deleted");
				} else {
					System.out.println("Error in category deletion.");
				}
			}
		}

	}

	// Ju Long
	public static void addCourse() {
		C206_CaseStudy.setHeader("ADD COURSE");
		int id = courseList.size() + 1;
		String title = Helper.readString("Enter Course Name: ");
		String category = Helper.readString("Enter Course Category Name: ");
		String description = Helper.readString("Enter Course Description (less than 50 characters): ");
		int duration = Helper.readInt("Enter Course Duration(Days): ");
		String prerequisite = Helper.readString("Enter Course Condition: ");

		Course course = new Course(id, title, category, description, duration, prerequisite);
		doAddCourse(courseList, course, categoryList);
		System.out.println();
	}

	// Ju Long
	public static void doAddCourse(ArrayList<Course> courseList, Course course, ArrayList<CourseCategory> categoryList) {
		boolean isRepeated = false;
		
		for (CourseCategory i : categoryList) {
			if (i.getCategoryName() == course.getCourseCategory()) {
				isRepeated = true;
			}
		}

		if (isRepeated) {
			courseList.add(course);
			System.out.println("Course has been added");
		} else
			System.out.println("The Category Name is not contained in Category list!");
	}

	// Ju Long
	public static void viewCourse() {
		C206_CaseStudy.setHeader("VIEW COURSE");
		String output = "";
		output += String.format("%-10s %-30s %-20s %-50s %-15s %s\n", "Course ID", "Course Title", "Course Category",
				"Course Description", "Course Duration", "Pre-requisite Course");
		output += doViewCourse(courseList);
		System.out.println(output);
		System.out.println();
	}

	// Ju Long
	public static String doViewCourse(ArrayList<Course> courseList) {
		String output = "";
		if (!courseList.isEmpty()) {
			for (Course i : courseList) {
				output += String.format("%-10d %-30s %-20s %-50s %-15d Days %s\n", i.getCourseCode(),
						i.getCourseTitle(), i.getCourseCategory(), i.getCourseDescription(), i.getCourseDuration(),
						i.getPrerequisiteCourse());
			}
		}
		return output;
	}

	// Ju Long
	public static void deleteCourse() {
		viewCourse();
		int id = Helper.readInt("Enter Course ID: ");

		doDeleteCourse(courseList, id);
		System.out.println();
	}

	// Ju Long
	public static void doDeleteCourse(ArrayList<Course> courseList, int courseID) {
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseCode() == courseID) {
				courseList.remove(i);
				System.out.println("Course has been removed");
				break;
			}
		}
	}

	// Alicia
	public static void addCourseSchedule() {
		C206_CaseStudy.setHeader("ADD SCHEDULE");
		String output = "";
		output += String.format("%-10s %-15s\n", "Course ID", "Course Title");

		for (Course i : courseList) {
			output += String.format("%-10d %-15s\n", i.getCourseCode(), i.getCourseTitle());
		}
		System.out.println(output);

		int courseID = Helper.readInt("Enter Course ID: ");
		double price = Helper.readDouble("Enter Price: ");
		String startDate = Helper.readString("Enter Start Date(DD/MM/YYYY): ");
		String startTime = Helper.readString("Enter Start Time(HH:MM)AM/PM: ");
		String endDate = Helper.readString("Enter End Date(DD/MM/YYYY): ");
		String endTime = Helper.readString("Enter End Time(HH:MM)AM/PM: ");
		String location = Helper.readString("Enter Location: ");

		CourseSchedule sch = new CourseSchedule(courseID, scheduleList.size() + 1, price, startDate, startTime, endDate,
				endTime, location);
		doAddCourseSchedule(scheduleList, sch);
		System.out.println();
	}

	public static String doAddCourseSchedule(ArrayList<CourseSchedule> scheduleList, CourseSchedule schedule) {
		boolean isRepeat = false;
		String output = "";
		for (CourseSchedule i : scheduleList) {
			if (schedule.getCSid() == i.getCSid())
				isRepeat = true;
		}
		if (!isRepeat) {
			scheduleList.add(schedule);
			output = "Schedule added";
		} else {
			output = "The Schedule id is being repeated. Please try again.";
		}
		return output;
	}

	// Alicia
	public static void viewCourseSchedule() {
		C206_CaseStudy.setHeader("VIEW SCHEDULE");
		String output = "";

		if (scheduleList.size() != 0) {
			output += String.format("%-13s %-12s %-11s %-11s %-10s %-9s %-10s\n", "Schedule ID", "Start Date",
					"Start Time", "End Date", "End Time", "Price", "Location");
		}
		output += doViewCourseSchedule(scheduleList);
		System.out.println(output);
		System.out.println();
	}

	// Alicia
	public static String doViewCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String output = "";

		if (scheduleList.size() == 0) {
			output += "There are no schedules to display";
		} else {
			for (CourseSchedule i : scheduleList) {
				output += String.format("%-13d %-12s %-11s %-11s %-10s $%-9.2f %-10s\n", i.getCSid(), i.getStartDate(),
						i.getStartTime(), i.getEndDate(), i.getEndTime(), i.getPrice(), i.getLocation());
			}
		}

		return output;
	}

	// Alicia
	public static void deleteCourseSchedule() {
		C206_CaseStudy.setHeader("DELETE SCHEDULE");
		int scheduleID = 0;

		if (scheduleList.size() != 0) {
			viewCourseSchedule();
			scheduleID = Helper.readInt("Enter Schedule ID: ");
		} else {
			scheduleID = -1;
		}
		String output = doDeleteCourseSchedule(scheduleList, scheduleID);
		System.out.println(output);
	}

	// Alicia
	public static String doDeleteCourseSchedule(ArrayList<CourseSchedule> scheduleList, int scheduleID) {

		String output = "";

		if (scheduleID == -1) {
			output = "There are no Course Schedules to delete";
		} else {
			viewCourseSchedule();

			int deleteIdx = -1;

			for (int i = 0; i < scheduleList.size(); i++) {
				if (scheduleList.get(i).getCSid() == scheduleID) {
					deleteIdx = i;
				}
			}

			if (deleteIdx == -1) {
				output = "Invalid Course Schedule ID";
			} else {
				scheduleList.remove(deleteIdx);
				output = "Course Schedule has been deleted";
			}
		}

		return output;

	}

	// Qi Kai
	public static void registerCS() {
		C206_CaseStudy.setHeader("ADD REGISTER");
		int courseCode = Helper.readInt("Enter Course code: ");
		int CSid = Helper.readInt("Enter course Schedule ID: ");
		int regiID = regiList.size() + 1;
		String memEmail = Helper.readString("Enter Email: ");
		boolean status = false;
		LocalDateTime regiDate = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String formattedDate = regiDate.format(format);

		Register register = new Register(courseCode, CSid, regiID, memEmail, status, formattedDate);
		doRegisterCS(regiList, register, memberList);
		
		System.out.println();
	}
	
	// Qi Kai
	public static void doRegisterCS(ArrayList<Register> regiList, Register register, ArrayList<Member> memberList) {
		boolean isThere = false;
		for (Member i : memberList) {
			if (i.getEmail().equals(register.getMemEmail())) {
				isThere = true;
			}
		}
		if (isThere) {
			regiList.add(register);
			System.out.println("Registration have been added");
		} else {
			System.out.println("Email entered is not available in the Member list");
		}
	}

	// Qi kai
	public static void viewRegister() {
		C206_CaseStudy.setHeader("VIEW ALL REGISTER");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s\n", "Registration ID", "Course Schedule ID",
				"Member Email", "Status", "Registration Date & time");
		output += retrieveRegiList(regiList);
		
		System.out.println(output);
		System.out.println();
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
	public static void deleRegi() {
		C206_CaseStudy.setHeader("DELETE REGISTRATION");
		int deleRegi = Helper.readInt("Enter your registration ID: ");

		doDeleRegi(regiList, deleRegi);
		System.out.println();
	}
	
	// Qi kai
	public static String doDeleRegi(ArrayList<Register> regiList, int deleRegi) {
		String output = "";
		for (int i = 0; i < regiList.size(); i++) {
			if (regiList.get(i).getRegiID() == deleRegi) {
				regiList.remove(i);
				output += ("Registration has been deleted");
				output += ("An Email has been sent to your mailbox");
			}
		}
		return output;
	}

}