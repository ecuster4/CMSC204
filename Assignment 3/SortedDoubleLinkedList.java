import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>
{
	private Comparator<T> comparator;
	
	
	public SortedDoubleLinkedList(Comparator<T> comparator) 
	{
	    this.comparator = comparator;
	}

	public SortedDoubleLinkedList<T> add(T data)
	{
		 Node newN = new Node(data);
		 Node current = first;
		 
		 if (sizeOfList == 0)
		 {
			 super.addToFront(data);
			 return this;
		 }
		 
		 else if(comparator.compare(first.data, data) > 0)
		 {
			 newN.next = first;
			 first.previous = newN;
			 first = newN;
			 sizeOfList++;
			 return this;
		 }
		 
		 else
		 {
			 while(comparator.compare(current.data, data) < 1)
			 {
				 if(current.next == null)
				 {
					 current.next = newN;
					 newN.previous = current;
					 last = newN;
					 sizeOfList++;
					 return this;
				 }
				 else
				 {
					 current = current.next;
				 }
			 }
			 current.previous.next = newN;
			 newN.previous = current.previous;
			 current.previous = newN;
			 newN.next = current;
			 sizeOfList++;
			 return this;
		 }
	}	
	
	
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	@Override
	public ListIterator<T> iterator()
	{
		return super.iterator();
	}
	@Override
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator)
	{
		return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
	}
}
