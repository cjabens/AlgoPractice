package ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class isPallindromePermTest {
	ArraysAndStrings test1 = new ArraysAndStrings();
	
	@Test
	void palindromeTruetest() {
		String testString = "kabak";
		
		boolean result = test1.isPalindromePerm(testString);
		assertEquals(true, result);
		
	}
	
	@Test
	void palindromePermFalseTest() {
		String testString = "notapalindrome";
		
		boolean result = test1.isPalindromePerm(testString);
		assertEquals(false,result);
	}

	@Test 
	void palindromeAndPermTrue() {
		String testString = "racarec"; //racecar is palindrome
		
		boolean result = test1.isPalindromePerm(testString);
		assertEquals(true,result);
	}
}
