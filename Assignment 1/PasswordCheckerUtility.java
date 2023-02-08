import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;
/**
 * Class to see if input password is valid or not.
 * @author Edwin Custer IV
 *
 */
public class PasswordCheckerUtility 
{
	/**
	 * Compares password for both inputs to see if identical
	 * @param password - password string to be checked for
	 * @param passwordConfirm - passwordConfirm string to be checked against password for
	 * @throws UnmatchedException - thrown if not same (case sensitive)
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		if(password != passwordConfirm)
		{
			throw new UnmatchedException();
		}
	}
	/**
	 * Compare equality of two passwords
	 * @param password - password string to be checked for
	 * @param passwordConfirm  - passwordConfirm string to be checked against password for
	 * @return true if both same (case sensitive), false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
	{
		boolean isSame = password.equals(passwordConfirm);
		if (isSame == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	* Accept arraylist of passwords with the status of any invalid passwords. The list will print with the correct format.
	* @param passwords - password string to be checked for length
	* @return - ArrayList of invalid passwords in the correct format
	*/
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> inPasswords = new ArrayList<>();
		for (String a : passwords)
		{
			try
			{
				isValidPassword(a);
			}
			catch (Exception e)
			{
				inPasswords.add(a +" "+e.getMessage());
			}
		}
			return inPasswords;
	}
	/**
	* checks if the password contains 6 to 9 characters
	* @param password - password string to be checked for
	* @return -true if password contains 6 to 9 characters, false otherwise
	*/
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		if(password.length()>=6 && password.length()<=9)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	* Checks the password Digit requirement - Password must contain a numeric character
	* @param password - password string to be checked for Digit requirement
	* @return - true if meet Digit requirement
	* @throws NoDigitException - thrown if does not meet Digit requirement
	*/
	public static boolean hasDigit(String password) throws NoDigitException
	{
		for (Character character : password.toCharArray()) 
		{
			if (Character.isDigit(character))
			{
				return true;
			}
		}
		throw new NoDigitException();
	}
	/**
	* Checks the password lowercase requirement - Password must contain at least one lowercase alpha character
	* @param password  - password string to be checked for lowercase requirement
    * @return - true if meets lowercase requirement
	* @throws NoLowerAlphaException - thrown if does not meet lowercase requirement
	*/
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		for (Character character : password.toCharArray())
		{
			if (Character.isLowerCase(character))
			{
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	/**
	* Checks the password SpecialCharacter requirement - Password must contain a Special Character
	* @param password - password string to be checked for SpecialCharacter requirement
	* @return - true if meets SpecialCharacter requirement
	* @throws NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
	*/
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
	{
		Pattern pattern = Pattern.compile("[A-Za-z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if(matcher.matches())
		{
			throw new NoSpecialCharacterException();
		}
		else
		{
			return true;
		}
	}
	/**
	* Checks the password alpha character requirement - Password must contain an uppercase alpha character
	* @param password - password string to be checked for alpha character requirement
	* @return - true if meet alpha character requirement
	* @throws NoUpperAlphaException - thrown if does not meet alpha character requirement
	*/
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		if(password.equals(password.toLowerCase()))
		{
			throw new NoUpperAlphaException();
		}
		else
		{
			return true;
		}
	}
	/**
	* Checks the password length requirement - The password must be at least 6 characters long
	* @param password - password string to be checked for length
	* @return - true if meets minimum length requirement
	* @throws LengthException - thrown if does not meet minimum length requirement
	*/
	public static boolean isValidLength(String password) throws LengthException
	{
		if(password.length() >= 6)
		{
			return true;
		}
		else
		{
			throw new LengthException();
		}
	}
	/**
	* Return true if valid password (meets all the necessary requirements)
	* @param password- string to be checked for validity
	* @return - true if valid password (follows all rules from above), false if an invalid password
	* @throws LengthException - thrown if length is less than 6 characters
	* @throws NoUpperAlphaException - thrown if no uppercase alphabetic
	* @throws NoLowerAlphaException - thrown if no lowercase alphabetic
	* @throws NoDigitException - thrown if no digit
	* @throws NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
	* @throws InvalidSequenceException - thrown if more than 2 of same character.
	*/
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
		NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		return isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password)
				&& hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password);
	}
	/**
	* Checks if password is VALID and the length is NOT between 6-9 characters
	* @param password - string to be checked if weak password
	* @return - false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
	* @throws WeakPasswordException - if length of password is between 6 and 9 (inclusive), ALTHOUGH the password may be VALID.
	*/
	public static boolean isWeakPassword(String password) throws WeakPasswordException
	{
		boolean weak = false;
		if(password.length()>6 && password.length()<9)
		{
			weak = true;
			throw new WeakPasswordException();
		}
		return weak;
	}
	/**
	* Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	* @param password - password string to be checked for Sequence requirement
	* @return - false if does NOT meet Sequence requirement
	* @throws InvalidSequenceException - thrown if meets Sequence requirement
	*/
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
	{
		boolean valid = true;
		for(int i=0; i < password.length() - 2; i++)
		{
			if (password.charAt(i) == password.charAt(i+1))
			{
				if (password.charAt(i) == password.charAt(i+2))
				{
					valid = false;
					throw new InvalidSequenceException();
				}
			}
		}
		return valid;
	}
}