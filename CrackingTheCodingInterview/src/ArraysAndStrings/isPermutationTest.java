package ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class isPermutationTest {
	ArraysAndStrings test1 = new ArraysAndStrings();
	
	@Test
	void isPermutationTestTrue() {
		String string1 = "abcd1234";
		String string2 = "4321abdc";
		
		boolean result = test1.isPermutation(string1, string2);
		assertEquals(true, result);
	}
	
	@Test
	void isPermutationTestFalse() {
		String string1 = "abcd1234";
		String string2 = "notAperm";
		
		boolean result = test1.isPermutation(string1, string2);
		assertEquals(false, result);
	}

}
