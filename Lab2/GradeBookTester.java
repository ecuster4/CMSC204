import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester 
{
	GradeBook g1, g2;
	
	@Before
	public void setUp() 
	{
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		g1.addScore(50);
		g1.addScore(75);
		
		g2.addScore(25);
		g2.addScore(10);
		g2.addScore(32);
	}

	@After
	public void tearDown()
	{
		g1 = null;
		g2 = null;
	}

	@Test
	public void testAddScore() 
	{
		assertTrue(g1.toString().equals("50.0 75.0 "));
		assertTrue(g2.toString().equals("25.0 10.0 32.0 "));
	}

	@Test
	public void testSum() 
	{
		assertEquals(125, g1.sum(), .0001);
		assertEquals(67, g2.sum(), .0001);
	}

	@Test
	public void testMinimum() 
	{
		assertEquals(50, g1.minimum(), .001);
		assertEquals(10, g2.minimum(), .001);
	}

	@Test
	public void testFinalScore() 
	{
		assertEquals(75, g1.finalScore(), .001);
		assertEquals(57, g2.finalScore(), .001);
	}

}
