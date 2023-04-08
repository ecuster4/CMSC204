import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface
{
	protected int sizeOfElement = 0;
	protected int sizeOfTable = 0;
	protected LinkedList<CourseDBElement>[] hashTable;
	//protected CourseDBElement LinkedList<>();
	
	//Constructor for testing
	public CourseDBStructure(String string, int size) 
	{
//        double loadFactor = 1.5;
//        int estimated = (int) Math.ceil(size/loadFactor);
//        sizeOfTable = prime(estimated);
        
        System.out.println(size);
        sizeOfTable = size;
		hashTable = new LinkedList[sizeOfTable];
	}
	
	//Constructor that should be callled
	public CourseDBStructure(int size) 
	{
        double loadFactor = 1.5;
        int estimated = (int) Math.ceil(size/loadFactor);
        sizeOfTable = prime(estimated);
    
        System.out.println(estimated);
        hashTable = new LinkedList[sizeOfTable];
    }

	public int getTableSize() 
	{
		//System.out.println(tableSize);
		return sizeOfTable;
	}
	
	public LinkedList<CourseDBElement>[] getHashTable()
	{
		System.out.println(hashTable);
		return hashTable;
	}
	
	
	public CourseDBElement get(int CRN) throws IOException 
	{
		String crnFirst = Integer.toString(CRN);
		int CRNfirst = Math.abs(crnFirst.hashCode()) % sizeOfTable;
		if(hashTable[CRNfirst] == null) 
		{
			throw new IOException();
		}
		
		
		return (CourseDBElement) hashTable[CRNfirst].getLast();
	}
	
	private int prime(int num) 
	{
        num = (int) (num / 0.75); 
        boolean list = false;
        int prime = 0;
        while (list != true) 
        {
            prime = num += 1;
            if (num % 4 == 3) 
            {
            	list = true;
            }
        }
        return prime;
    }

	public void add(CourseDBElement element) 
	{
		boolean doesElementExist = false;
		int initial = (int) Math.ceil(element.hashCode() % hashTable.length);
		System.out.println("initial = " + initial);

		System.out.println("CourseDBStructure Add function" + element.toString());

		
		if (hashTable[initial] == null)
		{
			hashTable[initial] = new LinkedList<>();
			System.out.println("Create linked list " + initial);
		}
	
		
		//For each
		System.out.println("hashTable[initial] = "+ hashTable[initial]);
		
		for (CourseDBElement listElement : hashTable[initial])
		{
			System.out.println("List element = "+ listElement.compareTo(element));
			if (listElement.compareTo(element) == 0)
			{
				System.out.println("True element = " + element.toString());
				doesElementExist = true;
			}
			else if(listElement.compareTo(element)  != 0)
			{
				System.out.println("False element = " + element.toString());
				doesElementExist = false;
			}
		}

		if (doesElementExist == false)
		{
			
			//The element does not exist so add it
			System.out.println("hashTable[initial].add(element) called");
			hashTable[initial].add(element);
		}
		else
		{
			//There should already be one linked list element in the hash biucket
			LinkedList<CourseDBElement> pList = hashTable[initial];
			System.out.println("Head of linked list = " + pList);
			
			//Check to see if the course already exists
			CourseDBElement cdbeExisting = (CourseDBElement) pList.getFirst(); 
			if (cdbeExisting.getID() != element.getID())
			{
				//Course IDs are different so go to end of list and add this course
				System.out.println("The new course ID is different so add it to the end of the list");
				
				pList.addLast(element);
				System.out.println("Add the new element = " + element);
			}
			
			
		}
	}
	
	public ArrayList<String> showAll()
	{
		ArrayList<String> courses = new ArrayList<String>();
		for(int i = 0; i < sizeOfTable; i++) 
		{
			while(hashTable[i] != null) 
			{
				CourseDBElement course = (CourseDBElement) hashTable[i].getLast();
				System.out.println("Add the new last element = " + course);
				courses.add("\n" + course.toString());
				break;
			}
		}
		return courses;
	}
}