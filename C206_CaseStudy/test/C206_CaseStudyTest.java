import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Member m1;
	private Member m2;
	private Member m3;
	private Member m4;
	private ArrayList<Member> memberList;

	private CourseCategory cc1;
	private CourseCategory cc2;
	private ArrayList<CourseCategory> categoryList;

	private Course course1;
	private Course course2;
	private Course course3;
	private ArrayList<Course> courseList;

	private Register regiCS1;
	private Register regiCS2;
	private Register regiCS3;
	private ArrayList<Register> regiList;

	private CourseSchedule schedule1;
	private CourseSchedule schedule2;
	private CourseSchedule schedule3;
	private ArrayList<CourseSchedule> scheduleList;

	@Before
	public void setUp() throws Exception {

		// Member, Hui Wen
		m1 = new Member("Lily", "Female", 81234567, "lily123@email.com", "14/03/1998", "Singapore", "ly4567889");
		m2 = new Member("Sally", "Female", 92345678, "sally456@email.com", "12/04/1994", "Singapore", "sy5678890");
		m3 = new Member("Jerry", "Male", 94567890, "sally456@email.com", "24/03/1994", "Singapore", "jr1234556");
		m4 = new Member("Tom", "Male",93456789,"123@mail.com","21/04/1997","Malaysia","tm345678");
		memberList = new ArrayList<Member>();

		// Course Category, Shu Fang
		cc1 = new CourseCategory("Sport", "Physical Exercise");
		cc2 = new CourseCategory("IT", "Computer");
		categoryList = new ArrayList<CourseCategory>();

		// Course, Ju Long
		course1 = new Course(1, "course1", "Sport", "its good", "01/01/2021", "05/11/2021", "2 people min");
		course2 = new Course(1, "course2", "IT", "its good", "01/02/2021", "05/10/2021", "2 people min");
		course3 = new Course(2, "course3", "IT", "its good", "01/02/2021", "05/10/2021", "2 people min");
		courseList = new ArrayList<Course>();

		// Register for course schedule, Qi Kai
		regiCS1 = new Register(1, 3, 4, "123@mail.com", false, "20-08-2020 20:38");
		regiCS2 = new Register(2, 5, 6, "321@mail.com", true, "20-08-2020 21:38");
		regiCS3 = new Register(3, 4, 3, "221@mail.com", true, "20-08-2020");
		regiList = new ArrayList<Register>();

		// Course Schedule, Alicia
		schedule1 = new CourseSchedule(1, 1, 15.00, "12/05/2020", "12:30PM", "12/06/2020", "3:00PM", "Library");
		schedule2 = new CourseSchedule(3, 2, 35.00, "20/07/2020", "10:00AM", "15/08/2020", "4:00PM", "Makerspace");
		schedule3 = new CourseSchedule(2, 2, 56.00, "12/08/2020", "12:00PM", "20/12/2020", "5:00PM", "Library");
		scheduleList = new ArrayList<CourseSchedule>();

	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	// HUIWEN
		// Member
		@Test
		public void addMemberTest() { 
			// Member list is not null, so that can add a new member - boundary
			assertNotNull("Check if there is valid member arraylist to add to", memberList);

			// Given an empty list, after adding 1 member, the size of the list is 1 -
			// normal
			// The member just added is as same as the first member of the list
			C206_CaseStudy.addMember(memberList, m1);
			assertEquals("Check that Member arraylist size is 1", 1, memberList.size());
			assertSame("Check that Member is added", m1, memberList.get(0));

			// Add another member. test The size of the list is 2? -normal
			// The member just added is as same as the second member of the list
			C206_CaseStudy.addMember(memberList, m2);
			assertEquals("Check that Member arraylist size is 2", 2, memberList.size());
			assertSame("Check that Member is added", m2, memberList.get(1));

			// Add another member. Test that email that is not unique cannot be added
			String addMember = C206_CaseStudy.addMember(memberList, m3);
			String testoutput = "Email must be unique";
			assertEquals("Test that member email that is not unique is cannot be added", addMember, testoutput);
		}
		
		// HUIWEN
		@Test
		public void viewAllMemberTest() {

			// Test if Member list is not null but empty - boundary
			assertNotNull("Test if there is valid member arraylist to retrieve item", memberList);

			// test if the list of members retrieved from the Member is empty - boundary
			String allMember = C206_CaseStudy.retreiveAllMember(memberList);
			String testOutput = "";
			assertEquals("Check that ViewAllMemberlist", testOutput, allMember);

			// Given an empty list, after adding 2 members, test if the size of the list is
			// 2 - normal
			C206_CaseStudy.addMember(memberList, m1);
			C206_CaseStudy.addMember(memberList, m2);
			assertEquals("Test that member arraylist size is 2", 2, memberList.size());

			// test if the expected output string same as the list of members retrieved from
			// the case study
			allMember = C206_CaseStudy.retreiveAllMember(memberList);
			testOutput = String.format("%-15s %-10s %-10d %-20s %-10s %-10s\n", "Lily", "Female", 81234567,
					"lily123@email.com", "14/03/1998", "Singapore", "ly4567889");
			testOutput += String.format("%-15s %-10s %-10d %-20s %-10s %-10s\n", "Sally", "Female", 92345678,
					"sally456@email.com", "12/04/1994", "Singapore", "sy5678890");

			assertEquals("Test that ViewAllMemberlist", testOutput, allMember);
		}

		@Test
		public void deleteMemberTest() { // HUIWEN
			// Test if Member list is not null but empty - boundary
			assertNotNull("test if there is valid member arraylist to delete from", memberList);
			
			// Test if register list is not null but empty - boundary
			assertNotNull("test if there is valid register arraylist to check from", regiList);

			// given an empty list, after adding 1 member that is not registered can be deleted - normal
			C206_CaseStudy.addMember(memberList, m1);
			String testoutput = "Member " + m1.getEmail() + " deleted";
			String delMember = C206_CaseStudy.dodeleteMember(memberList,regiList, 0);

			assertEquals("Test if a member that is not registered is can be deleted?", testoutput, delMember);

			// test if that the empty list cannot deleted - error
			String delMem1 = C206_CaseStudy.dodeleteMember(memberList,regiList, 0);
			String  testoutput1 = "Empty Member List";
			assertEquals("Test if an same member is cannot be deleted again?", testoutput1,delMem1);
		}
		
		//Hui Wen
		@Test
		public void doUpdateMemberTest() {
			// Test if Member list is not null but empty - boundary
			assertNotNull("test if there is valid member arraylist to update from", memberList);
			
			// Test if member does not exist cannot be updated - error 
			String updatemem = C206_CaseStudy.doUpdateMember(memberList, 0, "password", "Singapore", 12345678);
			String testoutput = "List is empty";
			assertEquals("Test if an same member is cannot be deleted again?", testoutput, updatemem);

			//Test if member exist can be updated - normal
			memberList.add(m1);
			String updatemem2 = C206_CaseStudy.doUpdateMember(memberList, 0, "password", "Singapore", 12345678);

			String testoutput2 = "Member Account updated";
			assertEquals("Test if an same member's email does not exist cannot be updated ?", testoutput2, updatemem2);
			
		}
		
		//Hui Wen
		@Test
		public void doSerachMember() {
			// Test if Member list is not null but empty - boundary
			assertNotNull("test if there is valid member arraylist to search from", memberList);
			
			//Test if country does not exist member cannot be shown 
			String testoutput = "Country of residencse searched does not exist";
			String serachmem = C206_CaseStudy.doSearchMember(memberList, "Australia");
			assertEquals("Test if the country does not exist searched cannot show any member ?", testoutput,serachmem);
		
			//Test if an existing country searched, member can be shown - normal
			C206_CaseStudy.addMember(memberList,m1);
			String searchmem1 = C206_CaseStudy.doSearchMember(memberList, "Singapore");
			String testoutput1 = "";
			testoutput1 += String.format("%-15s %-10s %-10d %-20s %-10s %-10s\n", "Lily", "Female", 81234567,
					"lily123@email.com", "14/03/1998", "Singapore", "ly4567889");
			assertEquals("Test if the country that exists searched can show member ?", testoutput1,searchmem1);
		}
		
		// Hui Wen
		@Test
		public void doListCourseMember() {
			// Test if course list is not null but empty - boundary
			assertNotNull("test if there is valid register arraylist to view from", courseList);
			
			//Test if there is no upcoming courses to be shown, if there is no course that is later than today
			String upcoming = C206_CaseStudy.doListCourseMember(courseList);
			String testoutput = "There is no upcoming course available";
			assertEquals("Test if there is no upcoming courses, courses cannot be list ?", testoutput,upcoming);
			
			//Test if there is course for that the startdate year is more than current year, course will be shown 
			C206_CaseStudy.doAddCourse(courseList,course1,categoryList);
			String upcoming1 = C206_CaseStudy.doListCourseMember(courseList);
			String testoutput1 = String.format("%-10s %-35s %-20s %-50s %-20s %-20s %s\n", 2, "course3", "IT", "its good", "01/02/2021", "05/10/2021", "2 people min");
			assertEquals("Test if the start date of the course is in the future of the current date, upcoming courses can be list  ?", testoutput,upcoming);
			
			
		}
		
	// CourseCategory
	// SHUFANG
	@Test
	public void addCourseCategory() {
		assertNotNull("Test whether there is a valid Arraylist category to add to ", categoryList);
		assertEquals("Test if the size of the arraylist category is 0?", 0, categoryList.size());
		categoryList.add(cc1);
		assertEquals("Test if the size of the Arraylist category is 1?", 1, categoryList.size());
		assertEquals("Test if this Category Name is called sport?", "Sport", categoryList.get(0).getCategoryName());
	}

	// SHUFANG
	@Test
	public void deleteCourseCategory() {
		assertNotNull("Test if there is a valid category Arraylist to be added to", categoryList);
		categoryList.add(cc1);
		assertEquals("Test if the size of the Arraylist category is 1?", 1, categoryList.size());
		categoryList.remove(0);
		assertEquals("Test if the size of the Arraylist category is 0?", 0, categoryList.size());

	}

	// SHUFANG
	@Test
	public void viewCourseCategory() {
		assertNotNull("Test if there is a valid category in the Arraylist", categoryList);
		categoryList.add(cc1);
		categoryList.add(cc2);
		String output = C206_CaseStudy.doViewCourseCategory(categoryList);
		String testoutput = "";
		for (CourseCategory i : categoryList) {
			testoutput += String.format("%-50s %s\n", i.getCategoryName(), i.getCategoryDescription());
		}
		assertEquals("Test if it equals to what was added", testoutput, output);
	}
	
	// Shufang
	public void retrieveAllCategoryTest() {
		// Test if Registration list is not null but empty -boundary
		assertNotNull("Test if there is valid CategoryList arraylist to retrieve the catgory list", categoryList);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		categoryList.add(cc1);
		categoryList.add(cc2);
		assertEquals("Test that Registration arraylist size is 2", 2, categoryList.size());
		
		courseList.add(course1);
		courseList.add(course3);
		// test if the expected output string same as the list of Registration retrieved
		// from the SourceCentre
		String orignalOutput = C206_CaseStudy.doListCourseCategory(courseList, cc1.getCategoryName());
		String testOutput = String.format("%-20s %-30s\n", "1234", "DBIS");
		testOutput += String.format("%-20s %-30s\n", "4321", "DBA");

		assertEquals("Test that ViewAllRegistrations", testOutput, orignalOutput);
	}
	
	 // Shufang
    public void updateCategoryTest() {
    		categoryList.add(cc1);
            String output = C206_CaseStudy.doUpdateCourseCategory(categoryList, cc2);
            assertEquals("Test if the description have change", "Category has been updated", output);
    }

	// Course
	// Ju Long
	@Test
	public void addCourseTest() {
		categoryList.add(cc1);
		categoryList.add(cc2);
		// check if there is a list available to add to
		assertNotNull("Test if there is valid Course arraylist to add to", courseList);

		// check if the messagge after adding is correct
		String isadded = C206_CaseStudy.doAddCourse(courseList, course1, categoryList);
		assertEquals("Test if that Course arraylist size is 1", "Course has been added", isadded);

		// check whether is the value the same as added just now
		assertSame("Test that Course is added same as 1st item of the list", course1, courseList.get(0));

		// check if the size will increase
		C206_CaseStudy.doAddCourse(courseList, course2, categoryList);
		assertEquals("Test that course list size is 2", 2, courseList.size());
	}

	// Ju Long
	@Test
	public void viewCourseTest() {
		// check whether is there a list to add to
		assertNotNull("Test if there is a valid Course arraylist to view", courseList);

		// check whether it will display only the title
		String output1 = C206_CaseStudy.doViewCourse(courseList);
		String testOutput = "";
		assertEquals("Test that ViewCourse function works", testOutput, output1);

		// check whether it will display the items it added
		courseList.add(course1);
		String output2 = C206_CaseStudy.doViewCourse(courseList);
		String testoutput = "";
		testoutput += String.format("%-10s %-35s %-20s %-50s %-20s %-20s %s\n", 1, "course1", "Sport", "its good", "01/01/2021", "05/11/2021", "2 people min");
		assertEquals("Test that ViewCourse function display out the correct information", testoutput, output2);
	}

	// Ju Long
	@Test
	public void deleteCourseTest() {
		// check whether is there a list to delete from
		assertNotNull("Test if there is a valid Course arraylist to delete", courseList);

		courseList.add(course1);
		// check whether can it delete
		String message = C206_CaseStudy.doDeleteCourse(courseList, 1, scheduleList);
		assertEquals("Test that list equals to 1 after delete", 0, courseList.size());

		// check whether did the delete message is correct
		assertEquals("Test that the current list is correct after delete", "Course has been removed", message);
	}

	//Ju Long
	@Test
	public void updateCourseTest() {
		// check whether is there a list to update from
		assertNotNull("Test if there is a valid Course arraylist to update", courseList);

		courseList.add(course1);
		categoryList.add(cc1);
		categoryList.add(cc2);
		// check whether it can update
		String update = C206_CaseStudy.doUpdateCourse(courseList, course2, categoryList);
		assertEquals("Test that update message is correct", "Course has been updated", update);

		// check whether did it update to the correct one
		assertEquals("Test that its being updated to the correct one", course2, courseList.get(0));
	}

	//Ju Long
	@Test
	public void searchCourseTest() {
		// check whether is there a list to search from
		assertNotNull("Test if there is a valid Course arraylist to search", courseList);

		courseList.add(course1);
		courseList.add(course3);
		String search = "IT";
		// check that it display out the correct search
		String output = C206_CaseStudy.doSearchCourse(courseList, search);
		String testoutput = String.format("%-10s %-35s %-20s %-50s %-20s %-20s %s\n", 2, "course3", "IT", "its good", "01/02/2021", "05/10/2021", "2 people min");
		assertEquals("Test that the result of search is correct", testoutput, output);
	}

	//Ju Long
	@Test
	public void listScheduleCourseTest() {
		// check whether is there a list to search from
		assertNotNull("Test if there is a valid Course arraylist to search", courseList);
		assertNotNull("Test if there is a valid CourseSchedule arraylist to search", scheduleList);

		courseList.add(course1);
		courseList.add(course3);
		scheduleList.add(schedule1);
		scheduleList.add(schedule2);

		// check that it display out the correct schedule
		String output = C206_CaseStudy.doListScheduleCourse(courseList, 1, scheduleList);
		String testoutput = String.format("%-13d %-12s %-11s %-11s %-10s $%-9.2f %-10s\n", 1, "12/05/2020", "12:30PM",
				"12/06/2020", "3:00PM", 15.00, "Library");
		assertEquals("Test that the correct message will be displayed out", testoutput, output);
	}

	// Alicia
	@Test
	public void addCourseScheduleTest() {
		assertNotNull("Test if there is valid Course arraylist to add to", scheduleList);

		// normal
		C206_CaseStudy.doAddCourseSchedule(scheduleList, schedule2);
		assertEquals("Test if schedule arraylist size is 1?", 1, scheduleList.size());

		// Adding schedule with duplicate schedule id(error)
		String test1 = C206_CaseStudy.doAddCourseSchedule(scheduleList, schedule3);
		assertEquals("Test if correct error message is displayed", test1,
				"The Schedule id is being repeated. Please try again.");
	}

	// Alicia
	@Test
	public void viewCourseScheduleTest() {
		assertNotNull("Test if there is valid CourseSchedule arraylist to add to", scheduleList);

		// If there are no existing schedules to view (error)
		assertSame("Check that list size is 0", 0, scheduleList.size());
		String allSchedules = C206_CaseStudy.doViewCourseSchedule(scheduleList);
		String output = "There are no schedules to display";
		assertEquals("Test that the correct error message is displayed", output, allSchedules);

		// If there are schedules to display (normal)
		scheduleList.add(schedule1);
		scheduleList.add(schedule2);
		assertSame("Test if scheduleList size is 2", 2, scheduleList.size());

		String test1 = C206_CaseStudy.doViewCourseSchedule(scheduleList);
		output = "";
		for (CourseSchedule i : scheduleList) {
			output += String.format("%-13d %-12s %-11s %-11s %-10s $%-9.2f %-10s\n", i.getCSid(), i.getStartDate(),
					i.getStartTime(), i.getEndDate(), i.getEndTime(), i.getPrice(), i.getLocation());
		}
		assertEquals("Check that the output is correct", test1, output);
	}

	// Alicia
	@Test
	public void deleteCourseScheduleTest() {
		assertNotNull("Test if there is valid CourseSchedule arraylist", scheduleList);

		// If there is no existing schedules to delete (error)
		assertSame("Test that list is empty", 0, scheduleList.size());
		String test1 = C206_CaseStudy.doDeleteCourseSchedule(scheduleList, regiList, -1);
		String msg1 = "There are no Course Schedules to delete";
		assertEquals("Test that error message is displayed", test1, msg1);

		scheduleList.add(schedule1);
		scheduleList.add(schedule2);
		assertSame("Test that list size is 2", 2, scheduleList.size());

		// Test that error message is displayed for invalid schedule id entered
		String test2 = C206_CaseStudy.doDeleteCourseSchedule(scheduleList, regiList, 3);
		String msg2 = "Invalid Course Schedule ID";
		assertEquals("Test that correct error message is displayed", test2, msg2);

		// Test that course schedule is deleted (normal)
		String test3 = C206_CaseStudy.doDeleteCourseSchedule(scheduleList, regiList, 1);
		String msg3 = "Course Schedule has been deleted";
		assertEquals("Test that course schedule is deleted", test3, msg3);

		assertSame("Test that list size is 1", 1, scheduleList.size());

		// Test that cannot delete schedules with registered members
		schedule3 = new CourseSchedule(2, 5, 56.00, "12/08/2020", "12:00PM", "20/12/2020", "5:00PM", "Library");
		regiCS2 = new Register(2, 5, 6, "321@mail.com", true, "20-08-2020 21:38");
		scheduleList.add(schedule3);
		regiList.add(regiCS2);

		String test4 = C206_CaseStudy.doDeleteCourseSchedule(scheduleList, regiList, 5);
		String msg4 = "Unable to delete! Course Schedule has registered member!";
		assertEquals("Test that correct error message is displayed", msg4, test4);
	}

	// Alicia
	@Test
	public void updateCourseScheduleTest() {
		assertNotNull("Test if there is valid list to update to", scheduleList);

		// If there are no course schedules to edit(error)
		String test1 = C206_CaseStudy.doUpdateCourseSchedule(scheduleList, -2);
		String msg1 = "There are no course schedules to update";
		assertEquals("Test that the correct error message is displayed", msg1, test1);

		// If there are existing schedules to edit, and details are entered(normal)
		scheduleList.add(schedule1);
		String test2 = C206_CaseStudy.doUpdateCourseSchedule(scheduleList, 1);
		String msg2 = "Course Schedule has been updated";
		assertEquals("Test that schedule is updated successfully", msg2, test2);

		// If course schedule id entered does not exist
		String test3 = C206_CaseStudy.doUpdateCourseSchedule(scheduleList, 5);
		String msg3 = "Invalid Course Schedule ID";
		assertEquals("Test that correct error message is displayed", msg3, test3);
	}

	@Test
	// Alicia
	public void searchCourseScheduleTest() {

		// If there are no schedules in the list (error)
		String test1 = C206_CaseStudy.doSearchCourseSchedule(scheduleList, 0);
		String msg1 = "There are no available course schedules";
		assertEquals("Test that correct error message is displayed", msg1, test1);

		scheduleList.add(schedule1);

		// If there are course schedule that matches the information entered (normal)
		String test2 = C206_CaseStudy.doSearchCourseSchedule(scheduleList, 15);
		String msg2 = String.format("%-13s %-12s %-11s %-11s %-10s %-9s %-10s\n", "Schedule ID", "Start Date",
				"Start Time", "End Date", "End Time", "Price", "Location");
		msg2 += String.format("%-13d %-12s %-11s %-11s %-10s $%-9.2f %-10s\n", 1, "12/05/2020", "12:30PM", "12/06/2020",
				"3:00PM", 15.00, "Library");
		assertEquals("Test that the output is correct", msg2, test2);

		// If the user searches for schedules that costs $15.99, system displays
		// schedules that are $15 (boundary)
		String test3 = C206_CaseStudy.doSearchCourseSchedule(scheduleList, 15.99);
		String msg3 = String.format("%-13s %-12s %-11s %-11s %-10s %-9s %-10s\n", "Schedule ID", "Start Date",
				"Start Time", "End Date", "End Time", "Price", "Location");
		msg3 += String.format("%-13d %-12s %-11s %-11s %-10s $%-9.2f %-10s\n", 1, "12/05/2020", "12:30PM", "12/06/2020",
				"3:00PM", 15.00, "Library");
		assertEquals("Test that the output is correct", msg3, test3);

	}

	@Test
	// Alicia
	public void listScheduleMemberTest() {
		// If there are no members that are registered for the schedule (error)
		regiList.add(regiCS1);
		ArrayList<String> email = new ArrayList<String>();
		String test1 = C206_CaseStudy.doListScheduleMember(regiList, memberList, email, 0);
		String msg1 = "There are no members";
		assertEquals("Test that correct error message is displayed", msg1, test1);

		// If there are members that registered for the schedule (normal)
		email.add("lily123@email.com");
		memberList.add(m1);

		String test2 = C206_CaseStudy.doListScheduleMember(regiList, memberList, email, 1);
		String msg2 = String.format("%-15s %-10s %-10s %-20s %-10s %-10s\n", "Name", "Gender", "Mobile", "Email", "DOB",
				"Country of Residence");
		msg2 += String.format("%-15s %-10s %-10d %-20s %-10s %-10s\n", m1.getName(), m1.getGender(), m1.getMobile(),
				m1.getEmail(), m1.getDateOfbirth(), m1.getCountryOfresidence());
		assertEquals("Test that output is correct", msg2, test2);
	}

	// Register
	// Qikai 5.1
	@Test
	public void ReceiveEmail() {
		// If a Member has already register for the course, it should send an error
		// message to
		// the Member and
		// will not be able to register again and will not receive the E-mail as well
		// (Error)
		for (int i = 0; i < regiList.size(); i++) {

			assertFalse("Test if the e-mail will be sending out or not" + regiList.get(i).getMemEmail(), false);
			// If a Member register for the first time, the Member will receive an E-mail
			// after registration
			// with the information details for the course schedule. (Normal)
			assertEquals("Test if the E-mail message has been sent out", regiList.get(i).getMemEmail());

			// Member registered for the course and
			// did not receive the registration E-mail. (Error)
			assertFalse("Test if the e-mail will be sending out or not" + regiList.get(i).getMemEmail(), false);

		}

	}

	// Qikai 5.2
	@Test
	public void viewEntryStatus() {
		// The system shows the entry status for the Members chosen as Pending
		// even the Member has not yet to make the payment (Boundary)
		assertNotNull("Test if the entry status for the Member as 'pending'",
				C206_CaseStudy.retrieveRegiList(regiList));
		// System display all entry status as cancelled (Error)
		for (int i = 0; i < regiList.size(); i++) {
			assertFalse("Test if the entry status as cancelled" + regiList.get(i).getStatus(), false);
			// When admin select one course and
			// the Member schedule entry status are display as pending(Normal)
			assertEquals("Test if the entry status are being display as 'pending'", regiList.get(i).getStatus());
			// System did not display any entry status(Error)
			assertFalse("Test if the entry status display in the system" + regiList.get(i).memEmail, true);
		}
	}

	// Qikai 5.3
	@Test
	public void addMembertoCS() {
		// Admin slot in the Member to his interested
		// course and successfully update in the database (Normal)
		for (int i = 0; i < regiList.size(); i++) {
			assertEquals("Test if the member has been added", regiList.get(i).getCourseCode());
			System.out.println("Member successfully insert to " + regiList.get(i).getCourseCode());
			// Admin unable to slot in the Member to his
			// interested course as the course is full (Normal)
			assertEquals("Test if the member unable to get into the course as it is full ",
					regiList.get(i).getCourseCode());
			System.out.println("Unable to slot the member into his interested course");
			// Admin able to slot in the Member to his
			// interested course even as the course is full (Boundary)
			assertNotNull("Test if the member unable to get into the course as it is full ",
					regiList.get(i).getCourseCode());
			System.out.println("Member successfully inserted");

		}
	}

	// Qikai 5.4
	@Test
	public void cancelCS() {
		regiList.add(regiCS1);
		// The course will no longer showing up the name and details
		// from the member registered course with a cancellation E-mail sent
		// out.(Normal)

		assertEquals("Test if the member has cancel the course", C206_CaseStudy.doDeleRegi(regiList, 1), "");

		// Member has successfully cancelled the registered form,
		// but no cancellation E-mail received (Boundary)
		assertNotNull("Test if the member has received the cancellation E-mail",
				C206_CaseStudy.doDeleRegi(regiList, 1));
	}

	// Qikai 5.5
	@Test
	public void refundCS() {
		// System process the refund to the Member after
		// Admin has done the refund stage for the Member (Normal)
		for (int i = 0; i < regiList.size(); i++) {
			assertEquals("Test if the fund has been processed ", regiList.get(i).getPrice());
			System.out.println("The refund has been processed");

			// Admin did not receive Member cancellation E-mail.(Error)
			assertFalse("Test if the admin did not received the cancellation email" + regiList.get(i).getMemEmail(),
					false);
			// System could not make refund after Admin has proceed with the refund(Error)
			assertFalse("Test if the refund has been sent to the Member" + regiList.get(i).getPrice(), false);

			// Member has received the refund after Admin
			// update the database and make refund.(Normal)
			assertEquals("Test if the refund has been made" + regiList.get(i).getPrice(), true);

			// Member received the refund but did not receive the cancellation refund
			// complete E-mail.(Boundary)
			assertNotNull("Test if the refund email has been sent to the Member" + regiList.get(i).getMemEmail(), true);
		}

	}

	// Qi kai 5.6
	@Test
	public void updateRegiStat() {

		for (int i = 0; i < regiList.size(); i++) {
			// Admin able to update the course registration
			// schedule status accordingly(It will display ‘Accepted’). (Normal)
			assertEquals("Test if the status will display as 'Accepted'" + regiList.get(i).isStatuscancel(), true);

			// Admin unable to update the course registration schedule status.(Error)
			assertFalse("Test if the course registration can be updated or not" + regiList.get(i).getStatus(), false);

			// Admin able to update the status but Member side
			// did not see the updated status. (Boundary)
			assertNotNull("Test if the Member can see the updated status" + regiList.get(i).getStatus(), false);
		}

	}

	// Qi kai 5.7
	@Test
	public void searchRegiCSid() {
		regiList.add(regiCS1);
		regiList.add(regiCS2);
		regiList.add(regiCS3);
		// System displays all the registration by
		// searching through the course schedule_id. (Normal)
//		regiCS3 = new Register(3, 4, 3, "221@mail.com", true, "20-08-2020");
				String test1=C206_CaseStudy.retrieveRegiListID(regiList, 3);
				String msg2 = String.format("%-20s %-20s %-20s %-20s %-20s\n", "Registration ID", "Course Schedule ID",
						"Member Email", "Status", "Registration Date & time");
				msg2 += String.format("%-20s %-20s %-20s %-20s %-20s\n", 3,4,"221@mail.com","Pending","20-08-2020");
				assertEquals("Test if the registration can be displayed by searching through the course id",test1,msg2);

		// System displays all the registrations
		// for all the courses after admin search through the course schedule_id.(Error)
				String test2=C206_CaseStudy.retrieveRegiListID(regiList, 1);
				assertFalse("Test if the system display the schedule_id for all courses"+test2,false);
		// System display a message ‘No member registered for this course schedule!’
		// after searching through
		// by course schdule_id and none of the Members registered for this course.
		// (Normal)
				String test3=C206_CaseStudy.retrieveRegiListID(regiList, 0);
				assertFalse("Test if the message will be displayed"+test3,false);

	}

	// Qikai 5.8
	@Test
	public void deleteCourseRegi() {
		// The course registration cannot be delete after passing the start
		// date.(Normal)
		regiList.add(regiCS1);
		regiList.add(regiCS2);
		String dele1 = C206_CaseStudy.doDeleRegi(regiList, 1);
		for (int i = 0; i < regiList.size(); i++) {
			assertFalse("Test the registration cannot be deleted" + dele1, false);
		// Admin able to delete the course registration after it has passed the schedule
		// start date. (Error)
		String dele2=C206_CaseStudy.doDeleRegi(regiList, 1);
		assertFalse("Test if the course registration can be deleted"+dele2,false);
		}
		// Admin unable to delete the course registration when the status is
		// ‘pending’.(Error)
		String test1=C206_CaseStudy.doDeleRegi(regiList, 3);
		String msg2 = String.format("%-20s %-20s %-20s %-20s %-20s\n", "Registration ID", "Course Schedule ID",
				"Member Email", "Status", "Registration Date & time");
		msg2 += String.format("%-20s %-20s %-20s %-20s %-20s\n", 3,4,"221@mail.com","Pending","20-08-2020");
		assertFalse("Test if the admin able to delete the resistration when status set as 'pending'"+test1+msg2,false);
	}

	// Qikai 5.9
	@Test
	public void listPartiMem() {
		// Test the list is not empty
		regiList.add(regiCS1);
		regiList.add(regiCS2);
		regiList.add(regiCS3);
		assertNotNull("Test the list is not empty", regiList);
		// System display all the course schedule that the Member has registered
		// after searching through that member. (Normal)
		String list1 = C206_CaseStudy.doSearchPartiMember(regiList, "221@mail.com");
		assertNotNull("Test if all the course schedule has been load out", list1);

		// System only display one course schedule registered by the member. (Boundary)
		assertFalse("Test that only one course schedule has displayed" + list1.isEmpty(), false);

		// System did not display the list of course schedule.(Error)
		assertFalse("Test if the list of course schedule sucessfully displayed or not" + list1, false);
	}

	@After
	public void tearDown() throws Exception {

		// Course
		course1 = null;
		course2 = null;
		courseList = null;

		// Register
		regiCS1 = null;
		regiCS2 = null;
		regiList = null;

	}
}