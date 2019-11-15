package ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class zeroMatrixTest {
	ArraysAndStrings test1 = new ArraysAndStrings();

	@Test
	void zeroMatrixTestTwoBy() {
		int[][] testMatrix = {{1,33},{2,0}};
		int[][] result = test1.zeroMatrix(testMatrix);
		int[][] expected = {{1,0},{0,0}};
		assertTrue(Arrays.deepEquals(expected, result));
}
	
	@Test 
	void zeroMatrixTextFiveBy() {
		int[][] testMatrix = {	{1 ,2 ,3 ,4 ,5},
								{6 ,0 ,8 ,0 ,10},
								{11,12,13,14,15},
								{16,17,18,19,20},
								{21,0 ,23,24,0 }};
		int[][] result = test1.zeroMatrix(testMatrix);
		int[][] expected = {	{1 ,0 ,3 ,0 ,0 },
								{0 ,0 ,0 ,0 ,0 },
								{11,0 ,13,0 ,0 },
								{16,0 ,18,0 ,0 },
								{0 ,0 ,0 ,0 ,0 }};
		assertTrue(Arrays.deepEquals(expected, result));
		}
	}


