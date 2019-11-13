package ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class urlifyTest {
	ArraysAndStrings test1 = new ArraysAndStrings();
	
	@Test
	void urlifyTestSimple() {
		String string1 = "Mr 3ohn Smith";
		String expectedString = "Mr%203ohn%20Smith";
		
		String result = test1.uRLify(string1);
		assertEquals(expectedString, result);
	}
	
	@Test
	void urlifyTestComplex(){
		String string1 = "  Hi 78 @ be the mat ch ?";
		String expectedString = "%20%20Hi%2078%20@%20be%20the%20mat%20ch%20?";
		
		String result = test1.uRLify(string1);
		assertEquals(expectedString, result);
	}

}
