import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.platform.engine.support.hierarchical.Node;

public class BasicDoubleLinkedList<T> implements Iterable<T>
{
	protected Node first , last;
	protected int sizeOfList;
	
	public BasicDoubleLinkedList() 
	{
		this.sizeOfList = 0;
		this.first = null;
		this.last = null;
	}
	
	public BasicDoubleLinkedList<T> addToEnd(T data)
	{
		Node tempNode = new Node(data);
		if (sizeOfList == 0)
		{
			first = tempNode;
			last = first;
		}
		else
		{
			last.next = tempNode;
			tempNode.previous = last;
			last = tempNode;
		}
		sizeOfList++;
		return this;
	}
	
	public BasicDoubleLinkedList<T> addToFront(T data)
	{
		Node tempNode = new Node(data);
		if (sizeOfList == 0)
		{
			first = tempNode;
			last = first;
		}
		else
		{
			first.previous = tempNode;
			tempNode.next = first;
			first = tempNode;
		}
		sizeOfList++;
		return this;
	}
	
	public T getFirst() 
	{
		if(first == null)
		{
			return null;
		}
		return first.data;
	}
	public T getLast() 
	{
		if(last == null)
		{
			return null;
		}
		return last.data;
	}
	
	public int getSize()
	{
		return sizeOfList;
	}
	
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException
	{
		return new Iterator();
	}
	
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator)
	{
		Node tempNode = first;
		
		if (sizeOfList == 0)
		{
			return this;
		}
		
		if(sizeOfList == 1)
		{
			if(comparator.compare(targetData, first.data) == 0)
			{
				first = null;
				last = null;
				sizeOfList --;
			}
		}
		
		while (tempNode != null)
		{
			if(comparator.compare(targetData, tempNode.data) == 0)
			{
				if(tempNode.equals(first))
				{
					first = first.next;
				}
				else if (tempNode.equals(last))
				{
					last = last.previous;
				}
				else
				{
					tempNode.previous.next = tempNode.next;
				}
				sizeOfList--;
				return this;
			}
			tempNode = tempNode.next;
		}
		return this;
	}
	
	public T retrieveFirstElement()
	{
		if ( first == null)
		{
			return null;
		}
		
		T t = first.data;
		
		if(sizeOfList == 1)
		{
			first = null;
			last = null;
			return t;
		}
		
		else
		{
			first = first.next;
			first.previous = null;
		}
		sizeOfList--;
		return t;
	}
	
	public T retrieveLastElement()
	{
		if (last == null)
		{
			return null;
		}
		
		T t = last.data;
		
		if(sizeOfList == 1)
		{
			first = null;
			last = null;
			return t;
		}
		
		
		last = last.previous;
		last.next = null;
		sizeOfList--;
		return t;
	}
	
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> tempList = new ArrayList<T>();
		Node tempNode = first;
		
		while (tempNode != null)
		{
			tempList.add(tempNode.data);
			tempNode = tempNode.next;
		}
		return tempList;
	}
	
	public class Node
	{
		protected T data;
		protected Node next, previous;
		
		public Node(T data)
		{
			this.next = null;
			this.previous = null;
			this.data = data;
		}
	}
	
	public class Iterator implements ListIterator<T>
	{
		protected Node last;
		protected Node tempNode = first;
		
		@Override
		public boolean hasNext()
		{
			return tempNode != null;
		}
		
		@Override
		public boolean hasPrevious()
		{
			return last != null;
		}
		
		@Override
		public T next() throws NoSuchElementException
		{
			if(hasNext())
			{
				last = tempNode;
				tempNode = tempNode.next;
				return last.data;
			}
			throw new NoSuchElementException("No next elements available in list");
		}
		
		@Override
		public T previous() throws NoSuchElementException
		{
			if(hasPrevious())
			{
				tempNode = last;
				last = last.previous;
				return tempNode.data;
			}
			throw new NoSuchElementException("No previous elements available in list");
		}
		
		@Override
		public int nextIndex() 
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public int previousIndex() 
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public void remove() 
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public void set(T data) 
		{
			throw new UnsupportedOperationException();
		}
		@Override
		public void add(T data) 
		{
			throw new UnsupportedOperationException();
		}
	}
}