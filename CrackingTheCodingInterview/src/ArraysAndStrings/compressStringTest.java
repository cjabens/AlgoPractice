package ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class compressStringTest {
	ArraysAndStrings test1 = new ArraysAndStrings();
	
	@Test
	void compressStringSingleCharTest() {
		String testString = "a";
		
		String result = test1.compressString(testString);
		String expected = "a";
		assertEquals(expected, result);
		
	}

	
	@Test
	void compressStringLongTest() {
		String testString = "aabbccccaaaaab";
		String result = test1.compressString(testString);
		String expected = "a2b2c4a5b1";
		assertEquals(expected, result);
	}
	
	@Test
	void compressStringSameLength() {
		String testString = "zzbbccddffkkaccc";
		String result = test1.compressString(testString);
		String expected = testString;
		assertEquals(expected, result);
	}
}
