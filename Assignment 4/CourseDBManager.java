import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface
{
	CourseDBStructure cds = new CourseDBStructure(101);
	
	public void add(String ID, int CRN, int credits, String roomNumber, String instructor) 
	{
		CourseDBElement cde = new CourseDBElement(ID, CRN, credits, roomNumber, instructor);
		cds.add(cde);
	}
	
	public CourseDBElement get(int crn) 
	{
		try 
		{
			return cds.get(crn);
		}
		catch(IOException i) 
		{
			System.out.print(i.getMessage());
			return null;
		}
	}
	
		
	public void readFile(File input) throws FileNotFoundException
	{
		try (Scanner in = new Scanner(input)) {
			while(in.hasNextLine()) 
			{
				String course = in.nextLine();
				String[] courses = course.split(" ", 5);
				int CRN = Integer.parseInt(courses[1]);
				int credits = Integer.parseInt(courses[1]);
				CourseDBElement info = new CourseDBElement(courses[0], CRN, credits, courses[3], courses[3]);
				cds.add(info);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> showAll() 
	{
		return cds.showAll();
	}
}