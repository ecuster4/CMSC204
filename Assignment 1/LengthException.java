/**
 * Throws Exception if the length of password is less than 6 characters.
 * @author Edwin Custer IV
 *
 *
 */
public class LengthException extends Exception 
{
	/**
	 * Throws Exception if the length of password is less than 6 characters.
	 */
	public LengthException() 
	{	
		super("The password must be at least 6 characters long");
	}
}
