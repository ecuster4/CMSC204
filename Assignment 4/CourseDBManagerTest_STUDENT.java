

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class CourseDBManagerTest_STUDENT {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204",34991,4,"SC253","Monshi");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC204",34991,4,"SC253","Monshi");
		dataMgr.add("CMSC203",32132,4,"SC121","Random");
		dataMgr.add("CMSC207",34219,4,"SC451","TBA");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:34991 Credits:4 Instructor:Monshi Room:SC253");
	 	assertEquals(list.get(1),"\nCourse:CMSC207 CRN:34219 Credits:4 Instructor:TBA Room:SC451");
		assertEquals(list.get(2),"\nCourse:CMSC203 CRN:32132 Credits:4 Instructor:Random Room:SC121");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 34991 4 SC253 Monshi");
			inFile.print("CMSC207 34219 4 SC451 TBA");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC204",dataMgr.get(34991).getID());
			assertEquals("CMSC207",dataMgr.get(34219).getID());
			assertEquals("SC253",dataMgr.get(34991).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
