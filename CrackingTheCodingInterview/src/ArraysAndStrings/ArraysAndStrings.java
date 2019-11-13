package ArraysAndStrings;

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
	public String uRLify(String string1) {
		char[] charArrIn = string1.toCharArray();
		// new char array needs to be 3 times the length in case all chars were spaces
		char[] charArrOut = new char[charArrIn.length * 3];
		int currentCharIndex = 0;

		for (int i = 0; i < charArrIn.length; i++) {
			if (charArrIn[i] == ' ') {
				charArrOut[currentCharIndex] = '%';
				currentCharIndex++;
				charArrOut[currentCharIndex] = '2';
				currentCharIndex++;
				charArrOut[currentCharIndex] = '0';
				currentCharIndex++;
			} else {
				charArrOut[currentCharIndex] = charArrIn[i];
				currentCharIndex++;
			}
		}
		String stringOut = new String(charArrOut);
		// trim off whitespace so that strings matched in length.
		return stringOut.trim();
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
	 *  check if chars are same one by one, if chars don't match, 
	 *  up the edit count,
	 *  index forward in one string to find if there is a match next, do other,
	 * if niether have a match then index both forward
	 * 
	 *  return false if editCount is more than one
	 *  less than one return true
	 */

	public boolean isOneAway(String string1, String string2) {
		int editCount = 0, index1 = 0, index2 = 0;

		// return false right away if length difference greater than 1
		if (Math.abs(string1.length() - string2.length()) > 1) {
			return false;
		}

		//keep checking until more than one edit or string length reached
		while ((editCount < 2) && (index1 < string1.length()) && (index2 < string2.length())) {
			// compare the individual letters
			if (string1.charAt(index1) != string2.charAt(index2)) {
				editCount++;
				//
				//account for string length here
				if (string1.length() < string2.length()) {
					index1--;
				} else if(string1.length() > string2.length()) {
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

}
