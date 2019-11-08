package ArraysAndStrings;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AllUniqueCharsTest {
	public ArraysAndStrings test1 = new ArraysAndStrings();
	
	@Test
	void testAllUnique() {
		String uniqueStr = "abc123";
		
		boolean result = test1.allUniqueChars(uniqueStr);
		assertEquals(true, result);
	}
	
	@Test
	void testNotUnique() {
		String notUniqueStr = "abccad";
		
		boolean result = test1.allUniqueChars(notUniqueStr);
		assertEquals(false, result);
	}
	

}
