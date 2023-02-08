/**
 * Throws Exception if the password does not contain an uppercase alpha character 
 * 
 * @author Edwin Custer IV
 *
 */
public class NoUpperAlphaException extends Exception 
{
	/**
	 * Throws Exception if the password does not contain an uppercase alpha character 
	 */
	public NoUpperAlphaException() 
	{
		super("The password must contain at least one uppercase alphabetic character");
	}
}
