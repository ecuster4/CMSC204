import java.util.ArrayList;
/**
 * Class to implemnt the stack
 * @author Edwin Custer
 *
 * @param <T> Data type that stores itself in Stack
 */
public class MyStack<T> implements StackInterface<T>
{
	private ArrayList<T> items;
	private int stackSize;
	int capacity = 0;
	/**
	 * Puts the size to 20 as the default
	 */
	public MyStack()
	{
		stackSize = 20;
		items = new ArrayList<T>(stackSize);
	}
	/**
	 * Specified number of elements
	 * @param size number of max elements
	 */
	public MyStack(int size)
	{
		this.stackSize = size;
		items = new ArrayList<T>(stackSize);
	}
	/**
	 * Checks if it is empty or not
	 * @return true if empty, false if not
	 */
	@Override
	public boolean isEmpty() 
	{
		if (capacity == 0) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Checks if it is full or not
	 * @return true if full, false if not
	 */
	@Override
	public boolean isFull() 
	{
		if (capacity == stackSize)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Removes and returns the element at the top of the stack
	 * @return the element deleted at the top
	 */
	@Override
	public T pop() throws StackUnderflowException 
	{
		T pop = null;
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			pop = items.get(capacity - 1);
			items.remove(capacity - 1);
			capacity--;
			return pop;
		}
	}
	/**
	 * Returns the element at the top but does not pop it
	 * @return the element at the top of the stack
	 */
	@Override
	public T top() throws StackUnderflowException 
	{
		T top = null;
		if (isEmpty()) 
		{
			throw new StackUnderflowException();
		}
		else
		{
			top = items.get(capacity -1);
			return top;
		}
	}
	/**
	 * The size of the stack
	 * @return the capacity of the stack
	 */
	@Override
	public int size() 
	{
		return capacity;
	}
	/**
	 * Creates an element at the top of the stack
	 * @param e the element at the top
	 * @return true if sucesfull
	 * @throws StackOverflowException if full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException 
	{
		if (isFull())
		{
			throw new StackOverflowException();
		}
		else
		{
			items.add(e);
			capacity++;
			return true;
		}
	}
	/**
	 * Returns the elements in the stack from the correct order
	 * @return sb a string of the elements
	 */
	@Override
	public String toString() 
	{
		String sb = "";
		for (T i:items)
		{
			sb += i ;
		}
		return sb;
	}
	/**
	 * Returns the elements in the stack from the correct order using delmimiter
	 * @param delimiter the data you wanted moved by
	 * @return the string returned with the delimiter used in the process
	 */
	@Override
	public String toString(String delimiter) 
	{
		String sb = "";
		for (int i = 0; i < items.size(); i++)
		{
			if (i!=items.size()-1)
			{
				sb += items.get(i) + delimiter;
			}
			else
			{
				sb += items.get(i);
			}
		}
		return sb;
	}
	/**
	 * Creats a new arraylist copy and fills it with the stack
	 * @param list the list of items in the stack
	 */
	@Override
	public void fill(ArrayList<T> list) 
	{
		ArrayList<T> copy = new ArrayList<T>(list);
		items.addAll(copy);
		capacity = items.size();		
	}
}
