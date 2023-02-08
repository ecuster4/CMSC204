/**
 * Throws Exception if the password does not contain at least one special character.
 *
 * @author Edwin Custer IV
 *
 */
public class NoSpecialCharacterException extends Exception 
{
	/**
	 * Throws Exception if the password does not contain at least one special character.
	 */
	public NoSpecialCharacterException() 
	{
		super("The password must contain at least one special character");
	}
}
