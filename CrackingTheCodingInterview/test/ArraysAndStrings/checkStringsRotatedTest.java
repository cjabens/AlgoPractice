package ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class checkStringsRotatedTest {
	ArraysAndStrings test1 = new ArraysAndStrings();

	@Test
	void StringsAreRotatedTest() {
		String string1 = "rotated";
		String string2 = "tatedro";
		
		boolean result = test1.checkStringRotation(string1, string2, string1.length());
		assertTrue(result);
	}
	
	@Test
	void StringsNotRotated() {
		String string1 = "notRotated";
		String string2 = "notMatchin";
		
		boolean result = test1.checkStringRotation(string1, string2, string1.length());
		assertFalse(result);
	}

}
