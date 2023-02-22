import java.util.ArrayList;
/**
 * Takes any data inputed from user and puts it in a queue
 * Also deals with order and shuffling of items
 * @author Edwin Custer
 * @param <T> Data type that stores itself in Queue
 */
public class MyQueue<T> implements QueueInterface<T>
{
	private ArrayList<T> items;
	private int stackSize;
	int capacity = 0;
	int first;
	int last;
	/**
	 * Puts the size to 20 as the default
	 */
	public MyQueue()
	{
		stackSize = 20;
		items = new ArrayList<T>(stackSize);
	}
	/**
	 * Specified number of elements
	 * @param size number of max elements
	 */
	public MyQueue(int size)
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
	 * Adds an item at the end of the queue
	 * @param e The element enqueued
	 * @throws QueueOverflowException if the queue is full
	 * @return true is it was enqueued
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException
	{
		if (isFull()) 
		{
			throw new QueueOverflowException();
		}
		else
		{
			items.add(last , e);
			last++;
			capacity++;
			return true;
		}
	}
	/**
	 * Remvoes the first item in the queue
	 * @throws  QueueUnderflowException if you dequeue and is empty
	 * @return the item removed 
	 */
	@Override
	public T dequeue() throws QueueUnderflowException
	{
		T dequeue;
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		else
		{
			dequeue = items.get(first);
			first++;
			capacity--;
		}
		return dequeue;
	}
	/**
	 * Checks the size of the queue
	 * @return the number of things in the queue
	 */
	@Override
	public int size() 
	{
		return capacity;
	}
	/**
	 * Displays the items in the queue
	 * @return a String of the data in the queue
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
	 * Gets the items in queue with use of delmiter
	 * @param delimiter the data you wanted moved by
	 * @return the string of data in the queue that was used with delimiter
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
	 * Creats a new arraylist copy
	 * @param list the list of items in the queue
	 */
	@Override
	public void fill(ArrayList<T> list) 
	{
		ArrayList<T> copy = new ArrayList<T>(list);
		items.addAll(copy);
		capacity = items.size();		
	}
}
