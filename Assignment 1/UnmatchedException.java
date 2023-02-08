/**
 * Throws Exception if password and re-typed password inputs are not identical
 * 
 * @author Edwin Custer IV
 *
 */
public class UnmatchedException extends Exception 
{
	/**
	 * Throws Exception if password and re-typed password inputs are not identical
	 */
	 public UnmatchedException() 
	 {
		    super("Passwords do not match");
	 }
}
