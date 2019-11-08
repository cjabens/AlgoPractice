package ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class urlifyTest {
	ArraysAndStrings test1 = new ArraysAndStrings();
	
	@Test
	void urlifyTest() {
		String string1 = "Mr 3ohn Smith";
		String expectedString = "Mr%203ohn%20Smith";
		
		String result = test1.uRLify(string1);
		assertEquals(expectedString, result);
	}

}
