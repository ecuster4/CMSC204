import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class PasswordCheckerUtility 
{
	public static void comparePasswords​(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException
	{
		
		if (password != passwordConfirm)
		{
			throw new UnmatchedException();
		}
		
	}
	public static boolean comparePasswordsWithReturn​(java.lang.String password, java.lang.String passwordConfirm)
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
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords)
	{
		 ArrayList<String> inPasswords = new ArrayList<>();
		 for (String a : passwords) 
		 {
			try 
			{
				isValidPassword​(a);
			}
			catch(Exception e)
			{
				inPasswords.add(a+ " ->" +" "+e.getMessage());
			}
		 }
		 return inPasswords;
	}
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
	public static boolean hasDigit(java.lang.String password) throws NoDigitException 
	{
		 for (Character c : password.toCharArray()) 
		 {
		      if (Character.isDigit(c)) 
		      {
		        return true;
		      }
		 }
		 throw new NoDigitException();
		
	}
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException
	{
		for (Character ch : password.toCharArray()) 
		{
			if (Character.isLowerCase(ch)) 
			{
				return true;
			}			
		}
		throw new NoLowerAlphaException();
	}
	public static boolean hasSpecialChar​(java.lang.String password) throws NoSpecialCharacterException
	{
		Pattern pat = Pattern.compile("[a-zA-Z0-9]*");
		Matcher mat = pat.matcher(password);
		if(mat.matches())
		{
			throw new NoSpecialCharacterException();
		}
		else
		{
			return true;
		}
	}
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
	public static boolean isValidLength​(java.lang.String password) throws LengthException
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
	public static boolean isValidPassword​(java.lang.String password) throws LengthException, 
	NoUpperAlphaException, NoLowerAlphaException, NoDigitException, 
	NoSpecialCharacterException, InvalidSequenceException
	{
		return isValidLength​(password) && hasUpperAlpha(password)
		        && hasLowerAlpha(password) && hasDigit(password)
		        && hasSpecialChar​(password) && NoSameCharInSequence​(password);
	}
	public static boolean isWeakPassword​(java.lang.String password) throws WeakPasswordException
	{

		if(password.length() <= 10) 
		{
			throw new WeakPasswordException();
		}
		else 
		{
			return true;
		}
	}
	public static boolean NoSameCharInSequence​(java.lang.String password) throws InvalidSequenceException
	{
		for (int i = 0; i < password.length() - 2; i++) 
		{
			if (password.charAt(i) == password.charAt(i + 1))
			{
				if (password.charAt(i) == password.charAt(i + 2)) 
				{
					throw new InvalidSequenceException();
				}
			}
		}
		return true;
	}
}
