package ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;


class rotateMatrixTest {
ArraysAndStrings test1 = new ArraysAndStrings();

	@Test
	void rotateMatrixTestFive() {
		int[][] testMatrix = {{1,2,3,4,5},
								{6,7,8,9,10},
								{11,12,13,14,15},
								{16,17,18,19,20},
								{21,22,23,24,25}};
		int[][] result = test1.rotateMatrixNinetyDegrees(testMatrix);
		int[][] expected = {{21,16,11,6,1},
							{22,17,12,7,2},
							{23,18,13,8,3},
							{24,19,14,9,4},
							{25,20,15,10,5}};
		
		assertTrue(Arrays.deepEquals(expected, result));
		}
	
	@Test
	void rotateMatrixTestTwo() {
		int[][] testMatrix = {{1,2},
								{3,4}};
		int[][] result = test1.rotateMatrixNinetyDegrees(testMatrix);
		int[][] expected = {{3,1},
							{4,2}};
		
		
		assertTrue(Arrays.deepEquals(expected, result));
		}
	
	@Test
	void rotateMatrixTestSix() {
		int[][] testMatrix = {{1,2,3,4,5,6},
								{7,8,9,10,11,12},
								{13,14,15,16,17,18},
								{19,20,21,22,23,24},
								{25,26,27,28,29,30},
								{31,32,33,34,35,36}};
		int[][] expected = test1.rotateMatrixNinetyDegrees(testMatrix);
		
		int result[][] = {{31,25,19,13,7,1},
							{32,26,20,14,8,2},
							{33,27,21,15,9,3},
							{34,28,22,16,10,4},
							{35,29,23,17,11,5},
							{36,30,24,18,12,6}};
		
		assertTrue(Arrays.deepEquals(result, expected));
		}
	
	@Test
	void rotateMatrixTestSingle() {
		int[][] testMatrix = {{2}};
		int[][] result = test1.rotateMatrixNinetyDegrees(testMatrix);
		assertTrue(Arrays.deepEquals(testMatrix, result));
	}
	}


