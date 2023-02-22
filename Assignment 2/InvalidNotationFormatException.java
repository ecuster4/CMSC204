/**
 * InvalidNotation class
 * @author Edwin
 */
public class InvalidNotationFormatException extends Exception 
{
	/**
	 * Assigns the correct message if the exception is thrown.
	 */
	InvalidNotationFormatException()
	{
		super("The notation format is not correct");
	}
}
