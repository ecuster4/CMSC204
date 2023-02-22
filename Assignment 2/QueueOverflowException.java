/**
 * QueueOverFlow class
 * @author Edwin
 */
public class QueueOverflowException extends Exception 
{
	/**
	 * Assigns the correct message if the exception is thrown.
	 */
	QueueOverflowException()
	{
		super("The queue is full");
	}
}
