import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {
	
	private static ArrayList<CourseCategory> categoryList = new ArrayList<CourseCategory>();
	private static ArrayList<Course> courseList = new ArrayList<Course>();
	private static ArrayList<Member> memberList = new ArrayList<Member>();
	private static ArrayList<Register> regiList = new ArrayList<Register>();

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
	
	//Qi Kai
	public static void registerCS() {
		int regiID = Helper.readInt("Enter your Course Schedule ID > ");
		for (int i = 0; i < regiList.size(); i++) {
			if (regiID == regiList.get(i).getCSid()) {
				Random rand = new Random();
				int rand_1 = rand.nextInt(200);
				System.out.println("Your registration ID is > " + regiList.get(i) + 1 + rand_1);
				String memEmail = Helper.readString("Enter your email > ");
				while (!memEmail.contains("@")) {
					System.out.println("Invalid format!");
				}
			}

		}

	}

	{
		System.out.println("Please enter the correct regitration ID!");
	}

	//Qi Kai
	public static void viewRegister() {

	}

	//Qi Kai
	public static void deleRegi() {

	}

}
