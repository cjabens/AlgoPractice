package ArraysAndStrings;

import java.util.Arrays;

public class ArraysAndStrings {
	/*
	 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique
	 * characters. What if you cannot use additional data structures? Hints: #44,
	 * #117, #132 all unique return true not all unique return false
	 */
	public boolean allUniqueChars(String checkStr) {
		int n = checkStr.length();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (checkStr.charAt(i) == checkStr.charAt(j))
					return false;
			}
		}
		// string is unique
		return true;

	}

	/*
	 * 1.2 Check Permutation: Given two strings, write a method to decide if one is
	 * a permutation of the other. Hints: ft , #84, #122, #131
	 */
	public boolean isPermutation(String string1, String string2) {
		/*
		 * count the number of each char in each string, starting with the first then
		 * check if it matches
		 */
		int n1 = string1.length();
		int n2 = string2.length();
		int count1 = 0;
		int count2 = 0;

		if (n1 == n2) {
			for (int i = 0; i < n1; i++) {
				count1 = 0;
				count2 = 0;
				for (int j = 0; j < n1; j++) {
					if (string1.charAt(i) == string1.charAt(j))
						count1++;
					if (string1.charAt(i) == string2.charAt(j))
						count2++;
				}
				if (count1 != count2)
					return false;
			}
		}
		return true;

	}

	/*
	 * 1.3 URLify: Write a method to replace all spaces in a string with '%20'. You
	 * may assume that the string has sufficient space at the end to hold the
	 * additional characters, and that you are given the "true" length of the
	 * string. (Note: If implementing in Java, please use a character array so that
	 * you can perform this operation in place.) EXAMPLE Input: "Mr 3ohn Smit h 13
	 * Output: "Mr%203ohn%20Smith"
	 */
	
	public char[] uRLify(char[] string1) {
		// char array passed in must be large enough to handle the urlified version
		// no error handling in place for that assumption
		for (int i = 0; i < string1.length; i++) {
			if (string1[i] == ' ') {
				//create space for new chars
				shiftRightFromIndex(string1, i+1);
				shiftRightFromIndex(string1, i+2);
				
				//insert chars below
				string1[i] = '%';
				i++;
				string1[i] = '2';
				i++;
				string1[i] = '0';
				//eliminate i++ here because test was 
				//missing the second of two consecutive spaces
			}
		}
		return string1;
	}
	
	private char[] shiftRightFromIndex(char[] array, int index) {
		//shifts all chars right of index one char slot
		//last character will be lost, not rotated
		for(int i = array.length - 1; i > index; i--) {
			array[i] = array[i-1];
		}
		return array;
	}

	/*
	 * 1.4 Palindrome Permutation: Given a string, write a function to check if it
	 * is a permutation of a palindrome. A palindrome is a word or phrase that is
	 * the same forwards and backwards. A permutation is a rearrangement of letters.
	 * The palindrome does not need to be limited to just dictionary words. EXAMPLE
	 * Input: Tac t Coa Output: Tru e (permutations : "tac o cat" , "atc o eta" ,
	 * etc. )
	 * 
	 */

	public boolean isPalindromePerm(String string1) {
		// need to count the characters. only one character count can be odd (modulus 2
		// = 1)
		// count spaces as part of the palindrome to reduce complexity.
		// use an array of values of all ascii chars 0-128. how to find numerical value
		// of a char in java? cast to integer

		// NOTES:
		// 45 minutes until passing all tests for palindrome problem.
		// Tried to initialize a count array with index values as if the index numbers
		// weren't inherently part of the array of size 128.

		// OPTIMIZATIONS:
		// Could sort string first then count chars but not even keep track of them for
		// which char it is, only that its different
		// this would save space and time

		// BRUTE FORCE:

		// declare vars here
		final int TOTAL_CHARS = 128;
		int[] charCount = new int[TOTAL_CHARS];
		int oddCount = 0;

		// made the following thought mistake until printing out the counts....
		// the array indexes are already numbered idiot
		/*
		 * //initialize character array numbers to keep char count for(int i = 0; i <
		 * charCount.length; i++) { charCount[i] = i; }
		 */

		// count chars
		for (int i = 0; i < string1.length(); i++) {
			// index thru each character in string1, cast to int, the increment charcount
			// array
			System.out.print(((int) string1.charAt(i)));
			System.out.println(" " + string1.charAt(i));
			charCount[((int) string1.charAt(i))]++;
		}

		// calculate how many charCounts are odd
		for (int i = 0; i < charCount.length; i++) {
			if ((charCount[i] % 2) == 1)
				oddCount++;
			System.out.println(oddCount);
			// escapes at first sign of non-palindrome capability
			if (oddCount > 1)
				return false;
		}

		// string1 is a permutation of a palindrome
		return true;
	}

	/*
	 * One Away: There are three types of edits that can be performed on strings:
	 * insert a character, remove a character, or replace a character. Given two
	 * strings, write a function to check if they are one edit (or zero edits) away.
	 * EXAMPLE pale , pae - > tru e pales , pale - > tru e pale , bale - > tru e
	 * pale , bake - > fals e
	 */

	/*
	 * 
	 * check number of length of each string, if greater the 1 char difference,
	 * return false
	 * 
	 * check if chars are same one by one, if chars don't match, up the edit count,
	 * index forward in one string to find if there is a match next, do other, if
	 * niether have a match then index both forward
	 * 
	 * return false if editCount is more than one less than one return true
	 */

	public boolean isOneAway(String string1, String string2) {
		int editCount = 0, index1 = 0, index2 = 0;

		// return false right away if length difference greater than 1
		if (Math.abs(string1.length() - string2.length()) > 1) {
			return false;
		}

		// keep checking until more than one edit or string length reached
		while ((editCount < 2) && (index1 < string1.length()) && (index2 < string2.length())) {
			// compare the individual letters
			if (string1.charAt(index1) != string2.charAt(index2)) {
				editCount++;
				// account for string length here
				if (string1.length() < string2.length()) {
					index1--;
				} else if (string1.length() > string2.length()) {
					index2--;
				}
			}
			index2++;
			index1++;

		}

		if (editCount < 2) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 1.6 String Compression: Implement a method to perform basic string
	 * compression using the counts of repeated characters. For example, the string
	 * aabcccccaaa would become a2blc5a3, If the "compressed" string would not
	 * become smaller than the original string, your method should return the
	 * original string. You can assume the string has only uppercase and lowercase
	 * letters (a - z).
	 * 
	 * psuedocode: letters saved can be counted by subtracting 1 when a single char
	 * is found, and adding n when n = number of repeats > 2 as we index thru
	 * counting add letter to the "compressed string", when a new letter is found
	 * add the letter count to the "compressed string" when the string end is found,
	 * print the number for the last letter return original string if saved letters
	 * is not > 0
	 * 
	 */

	public String compressString(String string1) {
		if (string1.length() < 3)
			return string1;

		int letterCount = 1, i = 1;
		String compressed = "";
		char letter, lastLetterConcat = string1.charAt(0);

		// use while loop
		while ((i < string1.length()) && (compressed.length() < string1.length())) {
			letter = string1.charAt(i);
			if (letter != lastLetterConcat) {
				compressed += lastLetterConcat;
				compressed += letterCount;
				letterCount = 1; // reset letter count for new letter
				lastLetterConcat = letter;
			} else {
				letterCount++;
			}
			i++;
		}
		// concat the last letter counted
		// This code is used twice, could make a method
		compressed += lastLetterConcat;
		compressed += letterCount;

		if (string1.length() <= compressed.length()) {
			return string1;
		} else
			return compressed;
	}

	
	/*
	 * 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel
	 * in the image is 4 bytes, write a method to rotate the image by 90 degrees.
	 * Can you do this in place? Hints: «51,0100
	 * 
	 */

	public int[][] rotateMatrixNinetyDegrees(int[][] matrix) {
		//NOTE: This method purposely only handles NxN matrices
		//chose to rotate clockwise
		//ignored the 4 byte pixel size and used integer values for now. 
		//Could be refactored accordingly.
		
		
		int holder;
		int N = matrix.length;

		// handle rotation here
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < (N-1 - 2 * i); j++) {
				//If i could reference the array slots with a, b, c, d,
					//it would save rewritten code
				
				//a to b
				holder = matrix[j+i][N - 1 - i];
				matrix[j+i][N - 1 - i]= matrix[i][j+i];
				matrix[i][j+i] = holder;
				
				//b to c
				holder = matrix[N - 1 - i][N - 1 - j - i];
				matrix[N - 1 - i][N - 1 - j - i] = matrix[i][j+i];
				matrix[i][j+i] = holder;
				
				//c  to d, d to a
				holder = matrix[N - 1 - j - i][i];
				matrix[N - 1 - j - i][i] = matrix[i][j+i];
				matrix[i][j+i] = holder;


			}

		}

		return matrix;
	}
	
	
	
/*
 * 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
 *  its entire row and column are set to 0. 
 */
public int[][] zeroMatrix(int[][] matrix){
	boolean[] rowsToZero = new boolean[matrix.length];
	Arrays.fill(rowsToZero, false);
	boolean[] colsToZero = new boolean[matrix[0].length];
	Arrays.fill(colsToZero, false);
	
	for(int i = 0; i < matrix.length; i++) {
		for(int j = 0; j < matrix[0].length; j++) {
			if(matrix[i][j] == 0) {
				rowsToZero[i] = true;
				colsToZero[j] = true;
			}
		}
	}
		
	for(int i = 0; i < matrix.length; i++) {
		for(int j = 0; j < matrix[0].length; j++) {
			if(rowsToZero[i] || colsToZero[j]) {
				matrix[i][j] = 0;
			}
		}
	}
	return matrix;
	}
	
}
	
	
