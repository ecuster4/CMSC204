/**
 * StackUnderFlow class
 * @author Edwin
 */
public class StackUnderflowException extends Exception 
{
	/**
	 * Assigns the correct message if the exception is thrown.
	 */
	StackUnderflowException()
	{
		super("The stack is empty");
	}
}
