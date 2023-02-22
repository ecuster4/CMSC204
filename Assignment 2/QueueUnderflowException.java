/**
 * QueueUnderFlow class
 * @author Edwin
 */
public class QueueUnderflowException extends Exception 
{
	/**
	 * Assigns the correct message if the exception is thrown.
	 */
	QueueUnderflowException()
	{
		super("The queue is empty");
	}
}
