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
  @Before
  public void setUp() throws Exception {
    
    //Course
    course1 = new Course(1, "course1", "Sport", "its good", 30, "2 people min");
    course2 = new Course(2, "course1", "Sport", "its good", 30, "2 people min");
    courseList = new ArrayList<Course>();
    
    //Register for course schedule
    regiCS1=new Register(1,3,4,"123@mail.com",false, "20-08-2020 20:38");
    regiCS2=new Register(2,5,6,"321@mail.com",true, "20-08-2020 21:38");
    regiList=new ArrayList<Register>();
    
    
  }


  @Test
  public void c206_test() {
    //fail("Not yet implemented"); 
    assertTrue("C206_CaseStudy_SampleTest ",true);
  }
  
  //Register
  @Test
  public void ReceiveEmail() {
    
  }
  @Test
  public void viewEntryStatus() {
    //The system shows the entry status for the Member’s chosen as ‘Pending’ 
    //even the Member has not yet to make the payment (Boundary)
    assertNotNull("Test if the entry status for the Member as 'pending'",C206_CaseStudy.viewRegister(regiList));
    //System display all entry status as cancelled (Error)
    for(int i=0;i<regiList.size();i++) {
      assertFalse("Test if the entry status as cancelled"+regiList.get(i).getStatus(),false);
      //When admin select one course and 
      //the Member schedule entry status are display as ‘pending’(Normal)
      assertEquals("Test if the entry status are being display as 'pending'",regiList.get(i).getStatus());
      //System did not display any entry status(Error)
      assertFalse("Test if the entry status display in the system"+regiList.get(i).memEmail,true);
    }
    
    
    
  }
  
  
  //Course
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
  
  @Test
  
  @After
  public void tearDown() throws Exception {
    
    //Course 
    course1 = null;
    course2 = null;
    courseList = null;
    
    //Register
    regiCS1=null;
    regiCS2=null;
    regiList=null;
    
    
  }
}