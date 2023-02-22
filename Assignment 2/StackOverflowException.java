/**
 * StackOverFlow class
 * @author Edwin
 */
public class StackOverflowException extends Exception 
{
	/**
	 * Assigns the correct message if the exception is thrown.
	 */
	StackOverflowException()
	{
		super("The Stack is full");
	}
}
