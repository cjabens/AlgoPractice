package ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class urlifyTest {
	ArraysAndStrings test1 = new ArraysAndStrings();
	
	@Test
	void urlifyTestSimple() {
		String string1 = "Mr 3ohn Smith";
		char[] charArray1 = new char[string1.length() * 3];
		for(int i = 0; i < string1.length(); i++) {
			charArray1[i] = string1.charAt(i);
		}
		
		String expectedString = "Mr%203ohn%20Smith";
		char[] expectedArray = new char[string1.length() * 3];
		for(int i = 0; i < expectedString.length(); i++) {
			expectedArray[i] = expectedString.charAt(i);
		}
		
		char[] charArrayResult = test1.uRLify(charArray1);
		assertTrue(Arrays.equals(expectedArray, charArrayResult));
	}
	
	@Test
	void urlifyTestComplex(){
		String string1 = "  Hi 78 @ be the mat ch ?";
		char[] charArray1 = new char[string1.length() * 3];
		for(int i = 0; i < string1.length(); i++) {
			charArray1[i] = string1.charAt(i);
		}
		
		String expectedString = "%20%20Hi%2078%20@%20be%20the%20mat%20ch%20?";
		char[] expectedArray = new char[string1.length() * 3];
		for(int i = 0; i < expectedString.length(); i++) {
			expectedArray[i] = expectedString.charAt(i);
		}
		
		char[] charArrayResult = test1.uRLify(charArray1);
		for(int i = 0; i < charArrayResult.length; i++) {
			System.out.print(charArrayResult[i]);
		}
		System.out.println();
		for(int i = 0; i < expectedArray.length; i++) {
			System.out.print(expectedArray[i]);
		}
		assertTrue(Arrays.equals(expectedArray, charArrayResult));
	}

}
