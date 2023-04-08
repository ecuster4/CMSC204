public class CourseDBElement implements Comparable 
{
	private String ID;
	private int crn;
	private int credits;
	private String room;
	private String instructor;
	
	public CourseDBElement() 
	{
		this.ID = "";
		this.crn = 000000;
		this.credits = 0;
		this.room = "";
		this.instructor = "";
	}
	
	public CourseDBElement(String id, int crn, int credits, String roomNumber, String instructorName) 
	{
		ID = id;
		this.crn = crn;
		this.credits = credits;
		room = roomNumber;
		instructor = instructorName;
	}

	public void setInstructor(String professor) 
	{
		this.instructor = professor;
	}
	
	public String getInstructor() 
	{
		return instructor;
	}
	
	public void setCRN(int CRN) 
	{
		this.crn = CRN;
	}

	public int getCRN() 
	{
		return crn;
	}
	public void setID(String id) 
	{
		this.ID = id;
	}
	
	public String getID() 
	{
		return ID;
	}
	
    public void setRoomNum(String roomNumber) 
    {              
    	this.room = roomNumber;
    }
	
	public String getRoomNum() 
	{
		return room;
	}
	
	public void setCredit(int credits)
	{
		this.credits = credits;
	}
	
	public int getCredits()
	{
		return credits;
	}
	
	public int compareTo(CourseDBElement element) 
	{
		return hashCode() - element.hashCode();
		
	}

	public int hashCode() 
	{
		String string = Integer.toString(crn);
		int hashcodevalue = string.hashCode();
 
		System.out.println("Hash code value = " + hashcodevalue);
        return hashcodevalue;
	}
	
	public String toString() 
	{
		return "Course:"+ ID +" CRN:"+ crn +" Credits:"+ credits +" Instructor:"+ instructor +" Room:"+ room;
	}
}