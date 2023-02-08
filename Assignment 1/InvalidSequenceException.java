/**
 * 
 * Throws Exception if the password contains more than 2 of the same character in sequence
 * @author Edwin Custer IV
 */
public class InvalidSequenceException extends Exception 
{
	/**
	 * Throws Exception if the password contains more than 2 of the same character in sequence
	 */
	public InvalidSequenceException() 
	{
		super("The password cannot contain more than two of the same character in sequence");
	}
}
