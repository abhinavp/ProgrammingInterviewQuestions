
//Q: StringToDouble in the next hour (following the end of the interview) and then to email it to the interviewer. This method had to include thorough 
//error checking and a method to test various cases (invalid characters, double too large, ect).

//two strings are anagrams when they contain same characters(not necessarily in the same order) and their length is same

package string;

import java.util.HashSet;
import java.util.Set;

public class Anagram {

	static String word1 = "cat";
	static String word2 = "tac";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isAnagram(word1, word2));
	}

	//time complexity O(n)
	//using hashset
	public static boolean isAnagram(String word1, String word2){
		
		if (word1.length() != word2.length()) return false;
		
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < word2.length(); i++)
			set.add(word2.charAt(i));
		
		for (int i = 0; i < word1.length(); i++){
			if (!set.contains(word1.charAt(i))) return false;
		}
		return true;
	}
}
