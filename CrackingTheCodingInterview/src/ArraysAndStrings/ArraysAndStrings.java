package ArraysAndStrings;

public class ArraysAndStrings {
	/*
	 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
	 * cannot use additional data structures?
	 * Hints: #44, #117, #132 
	 * all unique return true
	 * not all unique return false 
	*/
	public boolean allUniqueChars(String checkStr) {
		int n = checkStr.length();
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(checkStr.charAt(i) == checkStr.charAt(j))
					return false;
			}
		}
		//string is unique
		return true;

	}
	
	
	/* 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the
	 * other.
	 * Hints: ft , #84, #122, #131 
	*/
	public boolean isPermutation(String string1, String string2) {
		/*
		 * count the number of each char in each string, starting with the first then check if it matches
		 */
		int n1 = string1.length();
		int n2 = string2.length();
		int count1 = 0;
		int count2 = 0;
		
		if(n1 == n2) {
			for(int i = 0; i < n1; i++) {
				count1 = 0;
				count2 = 0;
				for(int j=0; j < n1; j++) {
					if (string1.charAt(i) == string1.charAt(j)) count1++;
					if(string1.charAt(i) == string2.charAt(j)) count2++;
				}
				if (count1 != count2) return false;
			}
		}
		return true;
		
	}
	
	
	/*
	 * 1.3 URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
		has sufficient space at the end to hold the additional characters, and that you are given the "true"
		length of the string. (Note: If implementing in Java, please use a character array so that you can
		perform this operation in place.)
		EXAMPLE
		Input: "Mr 3ohn Smit h 13
	 	Output: "Mr%203ohn%20Smith" 
	 */
	public String uRLify(String string1) {
		char[] charArrIn = string1.toCharArray();
		//new char array needs to be 3 times the length in case all chars were spaces
		char[] charArrOut = new char[charArrIn.length * 3];
		int currentCharIndex = 0;
		
		for(int i = 0; i < charArrIn.length; i++) {
			if(charArrIn[i] == ' ') {
				charArrOut[currentCharIndex] = '%';
				currentCharIndex++;
				charArrOut[currentCharIndex] = '2';
				currentCharIndex++;
				charArrOut[currentCharIndex] = '0';
				currentCharIndex++;
			}else {
				charArrOut[currentCharIndex] = charArrIn[i];
				currentCharIndex++;
			}
		}
		String stringOut = new String(charArrOut);
		//trim off whitespace so that strings matched in length.
		return stringOut.trim();
	}
	

}
