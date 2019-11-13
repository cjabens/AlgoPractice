package ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class isOneAwayTest {
	ArraysAndStrings test1 = new ArraysAndStrings();
	
	@Test
	void testIsOneAwayTwoReplaces() {
		String string1 = "nanl";
		String string2 = "fail";
		
		boolean result = test1.isOneAway(string1, string2);
		assertEquals(false, result);
	}
	
	@Test
	void testIsOneAwaySame() {
		String string1 = "matching";
		
		boolean result = test1.isOneAway(string1, string1);
		assertEquals(true, result);
	}
	
	@Test
	void testIsOneAwayInsert() {
		String string1 = "fau";
		String string2 = "fail";
		
		boolean result = test1.isOneAway(string1, string2);
		assertEquals(false, result);
	}
	
	@Test
	void testIsOneAwayInsertMiddle() {
		String string1 = "fal";
		String string2 = "fail";
		
		boolean result = test1.isOneAway(string1, string2);
		assertEquals(true, result);
	}

	@Test
	void testIsOneAwayTwoInserts() {
		String string1 = "failure";
		String string2 = "failr";
		
		boolean result = test1.isOneAway(string1, string2);
		assertEquals(false, result);
	}
	
}
