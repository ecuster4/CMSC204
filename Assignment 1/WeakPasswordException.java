/**
 * Throws Exception if the password contains 6 to 9 characters which is valid
 *
 * @author Edwin Custer IV
 *
 */
public class WeakPasswordException extends Exception 
{
	/**
	 * Throws Exception if the password contains 6 to 9 characters which is valid
	 */
	public WeakPasswordException() 
	{
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
}
