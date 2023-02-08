/**
 * Throws Exception if the password does not contain a lowercase alpha character
 * 
 * @author Edwin Custer IV
 *
 */
public class NoLowerAlphaException extends Exception 
{
	/**
	 * Throws Exception if the password does not contain a lowercase alpha character
	 */
	public NoLowerAlphaException() 
	{
		super("The password must contain at least one lowercase alphabetic character");
	}
}
