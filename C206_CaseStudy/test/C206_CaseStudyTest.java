import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Course course1;
	private Course course2;
	private ArrayList<Course> courseList;
	
	@Before
	public void setUp() throws Exception {
		
		
		//Course
		course1 = new Course(1, "course1", "Sport", "its good", 30, "2 people min");
		course2 = new Course(2, "course1", "Sport", "its good", 30, "2 people min");
		courseList = new ArrayList<Course>();
		
		
	}


	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	
	//Course
	@Test
	public void addCourseTest() {
		assertNotNull("Test if there is valid Course arraylist to add to", courseList);
		
		courseList.add(course1);
		assertNotEquals("Test if that Course arraylist size is 1", 1, courseList.size());
		
		assertSame("Test that Course is added same as 1st item of the list", course1, courseList.get(0));
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		//Course 
		course1 = null;
		course2 = null;
		courseList = null;
		
		
	}
}
