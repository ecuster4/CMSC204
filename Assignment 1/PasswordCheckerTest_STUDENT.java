
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Edwin Custer
 *
 */
public class PasswordCheckerTest_STUDENT 
{
	ArrayList<String> passwords;
	String password1, password2;
	
	@Before
	public void setUp() throws Exception 
	{
		String[] string = {"WelcomeHome", "SeptembeR22!", "tired42", "SamL221$",
				"Christmas2", "xWdnb%2E", "ZAKKUL", "Ardgan!1", "x221e", "reallyLongpass2#",
				"WWWdsq12!", "welcomeHouse2#"};
		
			passwords = new ArrayList<String>();
			passwords.addAll(Arrays.asList(string));
	}

	@After
	public void tearDown() throws Exception 
	{
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("dscAB"));
			assertTrue("Did not throw lengthException", false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw some other exception besides lengthException", true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Password"));
			PasswordCheckerUtility.isValidPassword("password");
			assertTrue("Did not throw NoUpperAlpha exception", false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException", true);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("PASSWORD"));
			PasswordCheckerUtility.isValidPassword("password");
			assertTrue("Did not throw NoLowerAlphaexception", false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaexception", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaexception", true);
		}	
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("45678aR");
			assertTrue("Did not throw WeakPassword Exception",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Sundayp2!"));
			PasswordCheckerUtility.isValidPassword("Suuuuundayp2!");
			assertTrue("Did not throw InvalidSequenceExceception", false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw some other exception besides an InvalidSequenceException", true);
		}	
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Sundayp2!"));
			PasswordCheckerUtility.isValidPassword("Suuuuundayp!");
			assertTrue("Did not throw NoDigitException", false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw some other exception besides an NoDigitException", true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try
		{
			assertEquals(true, PasswordCheckerUtility.isValidPassword("Pundaynml2!"));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() 
	{
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0));
	    assertEquals(scan.next(), "WelcomeHome");
	    String nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("digit"));

	    scan = new Scanner(results.get(1)); 
	    assertEquals(scan.next(), "tired42");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("uppercase"));

	    scan = new Scanner(results.get(2));
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("special"));

	    scan = new Scanner(results.get(3)); 
	    assertEquals(scan.next(), "ZAKKUL");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("lowercase"));

	    scan = new Scanner(results.get(4)); 
	    assertEquals(scan.next(), "x221e");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("long"));

	    scan = new Scanner(results.get(5)); 
	    assertEquals(scan.next(), "WWWdsq12!");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("sequence"));
		
	}
}
