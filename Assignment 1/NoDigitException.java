/**
 * 
 * Throws Exception if the password does not contain a numeric character
 * @author Edwin Custer IV
 *
 */
public class NoDigitException extends Exception 
{
	/**
	 * Throws Exception if the password does not contain a numeric character
	 */
	public NoDigitException() 
	{
		super("The password must contain at least one digit");
	}
}
