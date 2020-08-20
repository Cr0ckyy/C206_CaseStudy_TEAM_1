import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Course course1;
	private Course course2;
	private ArrayList<Course> courseList;

	private Register regiCS1;
	private Register regiCS2;
	private ArrayList<Register> regiList;

	private CourseSchedule schedule1;
	private CourseSchedule schedule2;
	private ArrayList<CourseSchedule> scheduleList;

	@Before
	public void setUp() throws Exception {

		// Course
		course1 = new Course(1, "course1", "Sport", "its good", 30, "2 people min");
		course2 = new Course(2, "course1", "Sport", "its good", 30, "2 people min");
		courseList = new ArrayList<Course>();

		// Register for course schedule
		regiCS1 = new Register(1, 3, 4, "123@mail.com", false, "20-08-2020 20:38");
		regiCS2 = new Register(2, 5, 6, "321@mail.com", true, "20-08-2020 21:38");
		regiList = new ArrayList<Register>();

		// Course Schedule
		schedule1 = new CourseSchedule(1, 1, 15.00, "12/05/2020", "12:30PM", "12/06/2020", "3:00PM", "Library");
		schedule2 = new CourseSchedule(3, 2, 35.00, "20/07/2020", "10:00AM", "15/08/2020", "4:00PM", "Makerspace");
//		schedule3 = new CourseSchedule(2, 3, 40.00, "20/07/2020", "10:00AM", "15/08/2020", "4:00PM", "Stadium");
		scheduleList = new ArrayList<CourseSchedule>();

	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	// Register
	@Test
	public void ReceiveEmail() {

	}

	@Test
	public void viewEntryStatus() {
		// The system shows the entry status for the Member’s chosen as ‘Pending’
		// even the Member has not yet to make the payment (Boundary)
		assertNotNull("Test if the entry status for the Member as 'pending'", C206_CaseStudy.viewRegister(regiList));
		// System display all entry status as cancelled (Error)
		for (int i = 0; i < regiList.size(); i++) {
			assertFalse("Test if the entry status as cancelled" + regiList.get(i).getStatus(), false);
			// When admin select one course and
			// the Member schedule entry status are display as ‘pending’(Normal)
			assertEquals("Test if the entry status are being display as 'pending'", regiList.get(i).getStatus());
			// System did not display any entry status(Error)
			assertFalse("Test if the entry status display in the system" + regiList.get(i).memEmail, true);
		}

	}

	// Course
	@Test
	public void addCourseTest() {
		assertNotNull("Test if there is valid Course arraylist to add to", courseList);

		courseList.add(course1);
		assertNotEquals("Test if that Course arraylist size is 1", 1, courseList.size());

		assertSame("Test that Course is added same as 1st item of the list", course1, courseList.get(0));

		courseList.add(course2);
		assertEquals("Test that course list size is 2", 2, courseList.size());
	}

	@Test
	public void viewCourseTest() {
		assertNotNull("Test if there is a valid Course arraylist to add to", courseList);

		String output = C206_CaseStudy.viewCourse();
		String testOutput = "";
		assertEquals("Check that ViewCourse function works", testOutput, output);
		C206_CaseStudy.addCourse();
	}

//	@Test
//	public void addCourseScheduleTest() {
//		assertNotNull("Test if there is valid Course arraylist to add to", scheduleList);
//		
//		//normal
//		scheduleList.add(schedule1);
//		assertEquals("Test if schedule arraylist size is 1?", 1, scheduleList.size());
//		
//		//error
//		scheduleList.add(schedule2);
//	}

	@Test
	public void viewCourseScheduleTest() {
		assertNotNull("Test if there is valid CourseSchedule arraylist to add to", scheduleList);

		String allSchedules = C206_CaseStudy.viewCourseSchedule(scheduleList);
		String output = "There are no schedules to display";
		assertEquals("Check that the list is empty", output, allSchedules);
		
		//normal
		scheduleList.add(schedule1);
		String test1 = C206_CaseStudy.viewCourseSchedule(scheduleList);
		output = String.format("%-13s %-12s %-11s %-11s %-10s %-9s %-10s", "Schedule ID",
				"Start Date", "Start Time", "End Date", "End Time", "Price", "Location");
		output += String.format("\n%5d %18s %11s %12s %8s %7.2f %14s", schedule1.getCSid(), schedule1.getStartDate(),
				schedule1.getStartTime(), schedule1.getEndDate(), schedule1.getEndTime(), schedule1.getPrice(), schedule1.getLocation());
		assertEquals("Check that the output is correct", test1, output);
		assertEquals("Test if scheduleList size is 1", 1, scheduleList.size());
		
	}
	
	@Test
//	public void deleteCourseScheduleTest() {
//		assertNotNull("Test if there is valid CourseSchedule arraylist", scheduleList);
//		
//		assertSame("Test that list is empty", 0, scheduleList.size());
//		
//		scheduleList.add(schedule1);
//		assertSame("Test that list size is 1", 1, scheduleList.size());
//		
//		scheduleList.remove(0);
//		assertSame("Test that list size is 0", 0, scheduleList.size());
//	}

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