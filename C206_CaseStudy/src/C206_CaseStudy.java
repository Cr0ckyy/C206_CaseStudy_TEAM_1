import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.naming.directory.SearchResult;

public class C206_CaseStudy {

	private static ArrayList<Member> memberList;
	private static ArrayList<CourseCategory> categoryList;
	private static ArrayList<Course> courseList;
	private static ArrayList<CourseSchedule> scheduleList;
	private static ArrayList<Register> regiList;

	private static final int LINES = 40;

	public static void main(String[] args) {
		memberList = new ArrayList<Member>();
		categoryList = new ArrayList<CourseCategory>();
		courseList = new ArrayList<Course>();
		scheduleList = new ArrayList<CourseSchedule>();
		regiList = new ArrayList<Register>();

		// adding info into list
		memberList
				.add(new Member("John", "Male", 12345678, "john123@gmail.com", "23/08/1999", "Singapore", "password"));
		memberList.add(
				new Member("Cherly", "Female", 98765432, "cherly1@gmail.com", "18/11/1995", "Malaysia", "password"));
		memberList.add(new Member("Jack", "Male", 23456789, "jack99@gmail.com", "01/01/2000", "Singapore", "password"));

		categoryList.add(new CourseCategory("Information Technology", "we learn how to use computer"));
		categoryList.add(new CourseCategory("Sport", "we learn how body works"));
		categoryList.add(new CourseCategory("Engineering", "we learn everything"));

		courseList.add(new Course(1, "Mobile Software Development", "IT", "we learn coding", "01/05/2021", "01/11/2021", "o-lvl score min 26"));
		courseList.add(new Course(2, "Sport Science", "Sport", "we learn body health", "01/05/2021", "01/11/2021", "o-lvl score min 26"));
		courseList.add(new Course(3, "Electric Electronic Engineering", "Engineering", "we learn coding", "01/05/2021", "01/11/2021", "o-lvl score min 26"));

		scheduleList.add(new CourseSchedule(1, 1, 50, "19/05/2021", "10:00", "19/05/2020", "16:00", "W64H"));
		scheduleList.add(new CourseSchedule(1, 2, 100, "20/05/2021", "10:00", "20/05/2020", "16:00", "W64H"));
		scheduleList.add(new CourseSchedule(2, 3, 150, "19/05/2021", "10:00", "19/05/2020", "16:00", "W14G"));

		regiList.add(new Register(1, 1, 1, "john123@gmail.com", true, "08/03/2020"));
		regiList.add(new Register(1, 1, 2, "cherly1@gmail.com", true, "08/03/2020"));
		regiList.add(new Register(1, 2, 3, "jack99@gmail.com", false, "23/04/2020"));
		regiList.add(new Register(2, 3, 4, "123@123.com", false, "28/04/2020"));
		regiList.add(new Register(3, 3, 5, "111@111.com", true, "28/04/2020"));

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
					updateCourseCategory();
					break;
				case 4:
					searchCourseCategory();
					break;
				case 5:
					listCourseCategory();
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
					updateCourse();
					break;
				case 4:
					searchCourse();
					break;
				case 5:
					listScheduleCourse();
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
					updateCourseSchedule();
					break;
				case 4:
					searchCourseSchedule();
					break;
				case 5:
					listScheduleMember();
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
					updateRegiStatus();
					break;
				case 4:
					CS_idSearch();
					break;
				case 5:
					searchPartiMember();
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

		System.out.println(addMember(memberList, mb));

	}

	// Hui Wen
	public static String addMember(ArrayList<Member> memberList, Member mb) {
		boolean isAdded = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getEmail() == mb.getEmail())
				isAdded = true;
		}
		if (isAdded) {
			return ("Email must be unique");

		} else {
			memberList.add(mb);
			return ("Member added");
		}
	}

	// Hui Wen
	public static void deleteMember() {
		C206_CaseStudy.setHeader("DELETE MEMBER");
		viewAllMember();
		String email = Helper.readString("Enter the Member's email to delete> ");
		int i = 0;
		
		boolean valid = false;
		for (; i < memberList.size(); i++) {
			if (memberList.get(i).getEmail().contentEquals(email)){
				valid = true;
				break;
			}
		}
		if (valid) {
				System.out.println(dodeleteMember(memberList,regiList, i));	
			
		} else {
			System.out.println("Invalid email");
			System.out.println();
				
		}
	}

	// Hui Wen
	public static String dodeleteMember(ArrayList<Member> memberList, ArrayList<Register> regiList, int i) {
		
		String output ="";
		boolean isValid = false;
		
		for (Register r : regiList) {
			if (r.getMemEmail().contentEquals(memberList.get(i).getEmail())) {
				isValid = true;
			}

		}
		if (!isValid) {
			memberList.remove(i);
			output += "Member " + memberList.get(i).getEmail() + "  deleted";
		}else {
			output += "Member that has registered with a course cannot be deleted";
		}
		return output;
	}
	// Hui Wen
	public static void updateMember() { 
		
		boolean exist = false;
		
		C206_CaseStudy.setHeader("UPDATE MEMBER ACCOUNT");
		viewAllMember();
		String email = Helper.readString("Enter member's email: ");
		for (int i = 0; i<memberList.size(); i++) {
			if (memberList.get(i).getEmail().equals(email)) {
				exist = true;
			}
		}if (!exist) {
			System.out.println("Please enter the correct email");
			System.out.println();
		}else {
			String password = Helper.readString("Enter new password> ");
			String cor = Helper.readString("Enter new country of residence> ");
			int mobile = Helper.readInt("Enter new moblie> ");
			System.out.println(doUpdateMember(memberList, email,password,cor,mobile));
		}
	}
	//Hui Wen
	private static String doUpdateMember(ArrayList<Member> memeberList, String email, String password, String cor,
			int mobile) { 
		
		boolean isUpdated = false;
		String output = "";
		for (int i = 0; i<memberList.size(); i++) {
			if (memberList.get(i).getEmail().equals(email)) {
				memberList.get(i).setPassword(password);
				memberList.get(i).setCountryOfresidence(cor);
				memberList.get(i).setMobile(mobile);
				isUpdated = true;
			}
		}if(isUpdated == true) {
			output += "Member Account updated";
		}
		return output;
	}
	// Hui wen
	private static void searchMember() { 
		
		C206_CaseStudy.setHeader("SERACH MEMBER BY COUNTRY OF RESIDENCE");
		boolean exist = false;
		
		String cor = Helper.readString("Enter country of residence to search> ");
		
		for (int i = 0; i< memberList.size();i++) {
			if (memberList.get(i).getCountryOfresidence().equalsIgnoreCase(cor)) {
				exist = true;
			}
		}if (exist) {
		String output = String.format("%-15s %-10s %-10s %-20s %-10s %-10s\n", "Name", "Gender", "Mobile", "Email",
				"DOB", "Country of Residennce");
		output += doSearchMember(memberList);
		System.out.println(output);
		System.out.println();
		} else {
			System.out.println("Country of residencse searched does not exist");
		}
		
	}public static String doSearchMember(ArrayList<Member> memberList) { // Hui wen
		String output = "";
		for (Member i : memberList) {
			output += String.format("%-15s %-10s %-10d %-20s %-10s %-10s\n", i.getName(), i.getGender(), i.getMobile(),
					i.getEmail(), i.getDateOfbirth(), i.getCountryOfresidence());
		}
		return output;
	}
	// Hui Wen
	public static void listCourseMember() { 
		
		C206_CaseStudy.setHeader("LIST ALL UPCOMING COURSE FOR MEMBER");
		
		String output = "";
		
		output += String.format("%-10s %-35s %-20s %-50s %-15s %s\n", "Course ID", "Course Title", "Course Category",
				"Course Description", "Course Duration", "Pre-requisite Course");
		output += doListCourseMember(courseList);
		System.out.println(output);
		System.out.println();
		
		
	}
	// Hui Wen
	public static String doListCourseMember(ArrayList<Course> courseList) { 

		LocalDateTime regiDate = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = regiDate.format(format);
		int day = Integer.valueOf(formattedDate.substring(0, 2));
		int month = Integer.valueOf(formattedDate.substring(3, 5));
		int year = Integer.valueOf(formattedDate.substring(6, 10));
		
		String output = "";
		int startDateDay = 0;
		int startDateMonth = 0;
		int startDateYear = 0;
		if (!courseList.isEmpty()) {
			for (Course i : courseList) {
				startDateDay = Integer.valueOf(i.getCourseStartDate().substring(0, 2));
				startDateMonth = Integer.valueOf(i.getCourseStartDate().substring(3, 5));
				startDateYear = Integer.valueOf(i.getCourseStartDate().substring(6, 10));
				if ( startDateYear > year ) {
					output += String.format("%-10d %-35s %-20s %-50s %-15s %-15s %s\n", i.getCourseCode(), i.getCourseTitle(),
							i.getCourseCategory(), i.getCourseDescription(), i.getCourseStartDate(), i.getCourseEndDate(),
							i.getPrerequisiteCourse());
					
				}else if ( startDateMonth > month ) {
					output += String.format("%-10d %-35s %-20s %-50s %-15s %-15s %s\n", i.getCourseCode(), i.getCourseTitle(),
							i.getCourseCategory(), i.getCourseDescription(), i.getCourseStartDate(), i.getCourseEndDate(),
							i.getPrerequisiteCourse());
				}else if (startDateDay > day) {
					output += String.format("%-10d %-35s %-20s %-50s %-15s %-15s %s\n", i.getCourseCode(), i.getCourseTitle(),
							i.getCourseCategory(), i.getCourseDescription(), i.getCourseStartDate(), i.getCourseEndDate(),
							i.getPrerequisiteCourse());
				}
			}
		}
		if (output.isEmpty())
			output += "There is no upcoming course available";
		return output;
			
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
	public static String doAddCategory(ArrayList<CourseCategory> categoryList, CourseCategory category) {
		String output = "";
		boolean isunique = true;
		for (CourseCategory i : categoryList) {
			if (i.getCategoryName() == category.getCategoryName()) {
				isunique = false;
			}
		}

		if (isunique) {
			categoryList.add(category);
			output += ("Category added");
		} else {
			output += ("Name must be unique");
		}
		return output;
	}

	// LI SHUFANG
	public static void viewCourseCategory() {
		C206_CaseStudy.setHeader("VIEW CATEGORY");
		System.out.println(String.format("%-50s %s\n", "COURSE CATEGORY", "DESCRIPTION"));
		System.out.println(doViewCourseCategory(categoryList));
		System.out.println();
	}

	// LI SHUFANG
	public static String doViewCourseCategory(ArrayList<CourseCategory> categoryList) {
		String output = "";
		for (var i : categoryList) {
			output += (String.format("%-50s %s\n", i.getCategoryName(), i.getCategoryDescription()));
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
	public static String doDeleteCourseCategory(ArrayList<CourseCategory> categoryList, String categoryName) {
		String output = "";

		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).getCategoryName().equalsIgnoreCase(categoryName)) {
				var deletion = Helper.readString("Are you sure that you want to delete this category? (Y/N) > ");
				if (deletion.equalsIgnoreCase("Y")) {
					categoryList.remove(i);
					output += ("Category have been deleted");
				} else {
					output += ("Error in category deletion.");
				}
			}
		}
		return output;
	}

	//LI SHUFANG
	public static void updateCourseCategory() {
		String name = Helper.readString("Enter Category Name: ");
		boolean proceed = false;
		for (CourseCategory i : categoryList) {
			if (name.equals(i.getCategoryName())) {
				proceed = true;
			}
		}
		if (proceed) {
			String description = Helper.readString("Enter updated description: ");
			CourseCategory category = new CourseCategory(name, description);
			System.out.println(doUpdateCourseCategory(categoryList, category));
		}
	}

	//LI SHUFANG
	public static String doUpdateCourseCategory(ArrayList<CourseCategory> categoryList, CourseCategory category) {
		String output = "";
		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).getCategoryName().equals(category.getCategoryName())) {
				categoryList.set(i, category);
				output += "Category has been updated";
			}
		}
		return output;
	}

	//LI SHUFANG
	public static void searchCourseCategory() {
		String name = Helper.readString("Enter Category Name: ");

		System.out.println(String.format("%-50s %s\n", "COURSE CATEGORY", "DESCRIPTION"));
		System.out.println(doSearchCourseCategory(categoryList, name));
	}

	//LI SHUFANG
	public static String doSearchCourseCategory(ArrayList<CourseCategory> categoryList, String name) {
		String output = "";
		boolean proceed = false;
		CourseCategory category = null;

		for (CourseCategory i : categoryList) {
			if (i.getCategoryName().equals(name)) {
				proceed = true;
				category = new CourseCategory(i.getCategoryName(), i.getCategoryDescription());
			}
		}
		if (proceed) {
			output += (String.format("%-50s %s\n", category.getCategoryName(), category.getCategoryDescription()));
		} else {
			output += "There is no category available";
		}
		return output;
	}

	//LI SHUFANG
	public static void listCourseCategory() {
		String name = Helper.readString("Enter Category Name: ");
		boolean proceed = false;
		String output = "";

		for (CourseCategory i : categoryList) {
			if (i.getCategoryName().equals(name)) {
				proceed = true;
			}
		}

		if (proceed) {
			output += String.format("%-10s %-35s %-20s %-50s %-15s %s\n", "Course ID", "Course Title",
					"Course Category", "Course Description", "Course Duration", "Pre-requisite Course");
			output += doListCourseCategory(courseList, name);
		} else {
			output += "Category does not exist in the category list";
		}
		System.out.println(output);
	}

	//LI SHUFANG
	public static String doListCourseCategory(ArrayList<Course> courseList, String name) {
		String output = "";
		boolean proceed = false;

		for (Course i : courseList) {
			if (i.getCourseCategory().equals(name)) {
				output += String.format("%-10s %-35s %-20s %-50s %-20s %-20s %s\n", i.getCourseCode(), i.getCourseTitle(),
						i.getCourseCategory(), i.getCourseDescription(), i.getCourseStartDate(), i.getCourseEndDate(),
						i.getPrerequisiteCourse());
			}
		}
		return output;
	}

	// Ju Long
	public static void addCourse() {
		C206_CaseStudy.setHeader("ADD COURSE");
		int id = courseList.size() + 1;
		String title = Helper.readString("Enter Course Name: ");
		String category = Helper.readString("Enter Course Category Name: ");
		String description = Helper.readString("Enter Course Description (less than 50 characters): ");
		String startDate = Helper.readString("Enter Course Start Date: ");
		String endDate = Helper.readString("Enter Course End Date: ");
		String prerequisite = Helper.readString("Enter Course Condition: ");

		Course course = new Course(id, title, category, description, startDate, endDate, prerequisite);
		System.out.println(doAddCourse(courseList, course, categoryList));
		;
		System.out.println();
	}

	// Ju Long
	public static String doAddCourse(ArrayList<Course> courseList, Course course,
			ArrayList<CourseCategory> categoryList) {
		boolean isRepeated = false;
		String output = "";

		for (CourseCategory i : categoryList) {
			if (i.getCategoryName().equalsIgnoreCase(course.getCourseCategory())
					&& course.getCourseDescription().length() < 50) {
				isRepeated = true;
			}
		}

		if (isRepeated) {
			courseList.add(course);
			output += ("Course has been added");
		} else
			output += ("The Category Name is not contained in Category list or the description is more than 50 characters.");
		return output;
	}

	// Ju Long
	public static void viewCourse() {
		C206_CaseStudy.setHeader("VIEW COURSE");
		String output = "";
		output += String.format("%-10s %-35s %-20s %-50s %-20s %-20s %s\n", "Course ID", "Course Title", "Course Category",
				"Course Description", "Course Start Date", "Course End Date", "Pre-requisite Course");
		output += doViewCourse(courseList);
		System.out.println(output);
		System.out.println();
	}

	// Ju Long
	public static String doViewCourse(ArrayList<Course> courseList) {
		String output = "";
		if (!courseList.isEmpty()) {
			for (Course i : courseList) {
				output += String.format("%-10s %-35s %-20s %-50s %-20s %-20s %s\n", i.getCourseCode(), i.getCourseTitle(),
						i.getCourseCategory(), i.getCourseDescription(), i.getCourseStartDate(), i.getCourseEndDate(),
						i.getPrerequisiteCourse());
			}
		}
		return output;
	}

	// Ju Long
	public static void deleteCourse() {
		C206_CaseStudy.setHeader("DELETE COURSE");
		viewCourse();
		int id = Helper.readInt("Enter Course ID: ");

		System.out.println(doDeleteCourse(courseList, id, scheduleList));
		System.out.println();
	}

	// Ju Long
	public static String doDeleteCourse(ArrayList<Course> courseList, int courseID,
			ArrayList<CourseSchedule> scheduleList) {
		String output = "";
		boolean isThere = false;
		for (CourseSchedule i : scheduleList) {
			if (courseID == i.getCourseCode()) {
				isThere = true;
			}
		}

		if (isThere) {
			output += "There is schedule inside the course";
		} else {
			for (int i = 0; i < courseList.size(); i++) {
				if (courseList.get(i).getCourseCode() == courseID) {
					char check = Helper.readChar("Are you sure you want to delete?(y/n): ");
					if (check == 'y') {
						courseList.remove(i);
						output += "Course has been removed";
					} 
				} else {
					output += "Error remove course";
				}
			}
		}
		return output;
	}

	// Ju Long
	public static void searchCourse() {
		C206_CaseStudy.setHeader("SEARCH COURSE");
		String search = Helper.readString("Enter course category name: ");
		String output = "";
		output += String.format("%-10s %-35s %-20s %-50s %-20s %-20s %s\n", "Course ID", "Course Title", "Course Category",
				"Course Description", "Course Start Date", "Course End Date", "Pre-requisite Course");
		output += doSearchCourse(courseList, search);
		System.out.println(output);
		System.out.println();
	}

	// Ju Long
	public static String doSearchCourse(ArrayList<Course> courseList, String name) {
		String output = "";

		for (Course i : courseList) {
			if (i.getCourseCategory().equalsIgnoreCase(name))
				output += String.format("%-10d %-35s %-20s %-50s %-20s %-20s %s\n", i.getCourseCode(), i.getCourseTitle(),
						i.getCourseCategory(), i.getCourseDescription(), i.getCourseStartDate(), i.getCourseEndDate(),
						i.getPrerequisiteCourse());
		}
		return output;
	}

	// Ju Long
	public static void updateCourse() {
		C206_CaseStudy.setHeader("UPDATE COURSE");
		viewCourse();
		int id = Helper.readInt("Enter course id: ");
		boolean proceed = false;

		for (Course i : courseList) {
			if (i.getCourseCode() == id) {
				proceed = true;
			}
		}
		if (proceed) {
			String title = Helper.readString("Enter Course Name: ");
			String category = Helper.readString("Enter Course Category Name: ");
			String description = Helper.readString("Enter Course Description (less than 50 characters): ");
			String startDate = Helper.readString("Enter Course Start Date: ");
			String endDate = Helper.readString("Enter Course End Date: ");
			String prerequisite = Helper.readString("Enter Course Condition: ");

			Course course = new Course(id, title, category, description, startDate, endDate, prerequisite);
			System.out.println(doUpdateCourse(courseList, course, categoryList));
		} else
			System.out.println("The entered id does not exist in the course list");
		System.out.println();
	}

	// Ju Long
	public static String doUpdateCourse(ArrayList<Course> courseList, Course course,
			ArrayList<CourseCategory> categoryList) {
		boolean proceed = false;
		String output = "";

		for (CourseCategory i : categoryList) {
			if (i.getCategoryName().equalsIgnoreCase(course.getCourseCategory())
					&& course.getCourseDescription().length() < 50) {
				proceed = true;
			}
		}

		if (proceed) {
			courseList.set(course.getCourseCode() - 1, course);
			output += "Course has been updated";
		} else
			output += "The category name does not match the category list or your description length is more than 50";

		return output;
	}

	// Ju Long
	public static void listScheduleCourse() {
		C206_CaseStudy.setHeader("LIST COURSE SCHEDULE");
		viewCourse();
		int id = Helper.readInt("Enter Course id: ");

		System.out.println(doListScheduleCourse(courseList, id, scheduleList));
		System.out.println();
	}

	// Ju Long
	public static String doListScheduleCourse(ArrayList<Course> courseList, int id,
			ArrayList<CourseSchedule> scheduleList) {
		String output = "";
		boolean proceed = false;

		for (Course i : courseList) {
			if (i.getCourseCode() == id) {
				proceed = true;
			}
		}

		if (proceed) {
			for (CourseSchedule i : scheduleList) {
				if (i.getCourseCode() == id) {
					output += String.format("%-13d %-12s %-11s %-11s %-10s $%-9.2f %-10s\n", i.getCSid(),
							i.getStartDate(), i.getStartTime(), i.getEndDate(), i.getEndTime(), i.getPrice(),
							i.getLocation());
				}
			}
		} else
			output += "The entered id does not exist in the course list";

		return output;
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

	//Alicia
	public static String doAddCourseSchedule(ArrayList<CourseSchedule> scheduleList, CourseSchedule schedule) {
		boolean isRepeat = false;
		String output = "";
		for (CourseSchedule i : scheduleList) {
			if (schedule.getCSid() == i.getCSid())
				isRepeat = true;
		}
		if (!isRepeat) {
			scheduleList.add(schedule);
			output += "Schedule added";
		} else {
			output += "The Schedule id is being repeated. Please try again.";
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

		if (scheduleList.size() == 0) {
			scheduleID = -1;
		} else {

			viewCourseSchedule();
			scheduleID = Helper.readInt("Enter Schedule ID: ");
		}
		String output = doDeleteCourseSchedule(scheduleList, regiList, scheduleID);
		System.out.println(output);
	}

	// Alicia
	public static String doDeleteCourseSchedule(ArrayList<CourseSchedule> scheduleList, ArrayList<Register> regiList,
			int scheduleID) {

		String output = "";

		if (scheduleID == -1) {
			output = "There are no Course Schedules to delete";
		} else {

			int deleteIdx = -1;

			for (int i = 0; i < scheduleList.size(); i++) {
				if (scheduleList.get(i).getCSid() == scheduleID) {
					deleteIdx = i;
				}
			}

			for (Register i : regiList) {
				if (i.getCSid() == scheduleID) {
					deleteIdx = -2;
				}
			}

			if (deleteIdx == -1 || deleteIdx == -2) {
				if (deleteIdx == -1) {
					output += "Invalid Course Schedule ID";
				} else if (deleteIdx == -2) {
					output += "Unable to delete! Course Schedule has registered member!";
				}

			} else {
				scheduleList.remove(deleteIdx);
				output += "Course Schedule has been deleted";
			}
		}

		return output;

	}

	// Alicia
	public static void updateCourseSchedule() {
		C206_CaseStudy.setHeader("UPDATE SCHEDULE");

		int update = -1;
		String output = "";

		if (scheduleList.size() == 0) {
			update = -2;
		} else {
			viewCourseSchedule();
			int scheduleID = Helper.readInt("Enter Schedule ID to update: ");

			for (int i = 0; i < scheduleList.size(); i++) {
				if (scheduleList.get(i).getCSid() == scheduleID) {
					update = i;
				}
			}

			if (update != -1) {
				double price = Helper.readDouble("Enter Price: ");
				String startDate = Helper.readString("Enter Start Date(DD/MM/YYYY): ");
				String startTime = Helper.readString("Enter Start Time(HH:MM)AM/PM: ");
				String endDate = Helper.readString("Enter End Date(DD/MM/YYYY): ");
				String endTime = Helper.readString("Enter End Time(HH:MM)AM/PM: ");
				String location = Helper.readString("Enter Location: ");

				scheduleList.get(update).setPrice(price);
				scheduleList.get(update).setStartDate(startDate);
				scheduleList.get(update).setStartTime(startTime);
				scheduleList.get(update).setEndDate(endDate);
				scheduleList.get(update).setEndTime(endTime);
				scheduleList.get(update).setLocation(location);
			}
		}

		output += doUpdateCourseSchedule(scheduleList, update);
		System.out.println(output);
	}

	// Alicia
	public static String doUpdateCourseSchedule(ArrayList<CourseSchedule> scheduleList, int update) {

		String output = "";

		if (update == -1 || update > scheduleList.size()) {

			output += "Invalid Course Schedule ID";

		} else if (update == -2) {
			output += "There are no course schedules to update";
		} else {
			output += "Course Schedule has been updated";
		}

		return output;

	}

	// Alicia
	public static void searchCourseSchedule() {
		C206_CaseStudy.setHeader("SEARCH SCHEDULE");
		double search = 0.00;

		if (scheduleList.size() != 0) {

			search = Helper.readDouble("Enter Price to Search: ");

		}
		String output = doSearchCourseSchedule(scheduleList, search);
		System.out.println(output);
	}

	// Alicia
	public static String doSearchCourseSchedule(ArrayList<CourseSchedule> scheduleList, double search) {

		String output = "";

		if (search == 0.00) {
			output += "There are no available course schedules";
		} else {
			output += String.format("%-13s %-12s %-11s %-11s %-10s %-9s %-10s\n", "Schedule ID", "Start Date",
					"Start Time", "End Date", "End Time", "Price", "Location");

			for (CourseSchedule i : scheduleList) {
				if (i.getPrice() >= search - 1 && i.getPrice() < (search + 1)) {
					output += String.format("%-13d %-12s %-11s %-11s %-10s $%-9.2f %-10s\n", i.getCSid(),
							i.getStartDate(), i.getStartTime(), i.getEndDate(), i.getEndTime(), i.getPrice(),
							i.getLocation());
					;
				}
			}
		}

		return output;
	}

	// Alicia
	public static void listScheduleMember() {
		C206_CaseStudy.setHeader("LIST MEMBER FOR THE SCHEDULE");

		int check = 0;
		ArrayList<String> email = new ArrayList<String>();

		if (!(regiList.size() == 0 || memberList.size() == 0)) {
			check = 1;

			viewCourse();
			int course = Helper.readInt("Enter Course ID: ");
			int scheduleID = Helper.readInt("Enter Schedule ID: ");

			for (int i = 0; i < regiList.size(); i++) {
				if (regiList.get(i).getCSid() == scheduleID && regiList.get(i).getCourseCode() == course) {
					email.add(regiList.get(i).getMemEmail());
				}
			}
		}

		String output = doListScheduleMember(regiList, memberList, email, check);
		System.out.println(output);
	}

	// Alicia
	public static String doListScheduleMember(ArrayList<Register> regiList, ArrayList<Member> memberList,
			ArrayList<String> email, int check) {

		String output = "";

		if (check == 0) {
			if (regiList.size() == 0) {
				output += "There are no members in the registrants list";
			} else if (memberList.size() == 0) {
				output += "There are no members";
			}
		} else {

			if (email.size() != 0) {

				output += String.format("%-15s %-10s %-10s %-20s %-10s %-10s\n", "Name", "Gender", "Mobile", "Email",
						"DOB", "Country of Residence");

				for (Member m : memberList) {
					for (String e : email) {
						if (m.getEmail().equals(e)) {

							output += String.format("%-15s %-10s %-10d %-20s %-10s %-10s\n", m.getName(), m.getGender(),
									m.getMobile(), m.getEmail(), m.getDateOfbirth(), m.getCountryOfresidence());
						}
					}
				}

			} else {
				output += "There are no registered members for this course schedule";
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

		System.out.println(doDeleRegi(regiList, deleRegi));
		System.out.println();
	}

	// Qi kai
	public static String doDeleRegi(ArrayList<Register> regiList, int deleRegi) {
		String output = "";
		for (int i = 0; i < regiList.size(); i++) {
			if (regiList.get(i).getRegiID() == deleRegi) {
				char dele = Helper.readChar("Confirm deletion?(Y/N)");
				if (dele == 'Y') {
					regiList.remove(i);
					output += ("Registration has been deleted\n");
					output += ("An Email has been sent to your mailbox");
				} else if (dele == 'N') {
					output += ("Unable to delete!");
					output += ("The course schedule has passed today's date!");
				} else {
					output += ("Wrong input!Please try again");
				}

			}
		}
		return output;
	}

	// Qi kai
	public static void updateRegiStatus() {
		int update = Helper.readInt("Enter the registration ID you want to update > ");
		for (int i = 0; i < regiList.size(); i++) {
			if (regiList.get(i).getRegiID() == update) {
				String update22 = Helper.readString("You want to update the Member as?(Accepted/Cancelled) > ");
				if (update22.equals("accepted")) {
					regiList.get(i).setStatuscancel(false);
					System.out.println("Member has successfully updated as " + regiList.get(i).isStatuscancel());
				} else {
					regiList.get(i).setStatus(false);
					System.out.println("Member has successfully updated as " + regiList.get(i).getStatus());
				}
			}
		}
	}

	// Qi kai
	public static void CS_idSearch() {
		C206_CaseStudy.setHeader("SEARCH COURSE SCHEDULE");
		int cSid = 0;
		if (regiList.size() != 0) {
			cSid = Helper.readInt("Enter the course register id >");
		}
		String output = retrieveRegiListID(regiList, cSid);
		System.out.println(output);
	}

	//Qi Kai
	public static String retrieveRegiListID(ArrayList<Register> regiList, int cSid) {
		String output = "";
		String output2 = "";
		output += String.format("%-20s %-20s %-20s %-20s %-20s\n", "Registration ID", "Course Schedule ID",
				"Member Email", "Status", "Registration Date & time");
		for (Register i : regiList) {
			if (i.getRegiID() == cSid) {
				output2 += String.format("%-20s %-20s %-20s %-20s %-20s\n", i.getRegiID(), i.getCSid(), i.getMemEmail(),
						i.getStatus(), i.getRegiDate());
			}
		}
		output += output2;
		if (output2.isEmpty())
			output += "There is no ID exist in the list";
		return output;

	}

	// Qi kai
	public static void searchPartiMember() {
		C206_CaseStudy.setHeader("LIST MEMBERS");
		viewRegister();
		String email = Helper.readString("Enter Member Email address > ");
		System.out.println(doSearchPartiMember(regiList, email));
	}

	//Qi Kai
	public static String doSearchPartiMember(ArrayList<Register> regiList, String search) {
		String output = "";
		boolean go = false;
		for (Register i : regiList) {
			if (i.getMemEmail().equals(search)) {
				go = true;
			}
		}
		if (go) {
			for (Register i : regiList) {
				if (i.getMemEmail().equals(search)) {
					C206_CaseStudy.setHeader("MEMBER REGISTERED COURSE");
					output += String.format("%-20s %-20s %-20s %-20s %-20s\n", "Registration ID", "Course Schedule ID",
							"Member Email", "Status", "Registration Date & time");
					output += String.format("%-20s %-20s %-20s %-20s %-20s\n", i.getRegiID(), i.getCSid(),
							i.getMemEmail(), i.getStatus(), i.getRegiDate());
				}
			}
		} else {
			output += "The Member's E-mail does not exist in the list!";
		}
		return output;
	}

}