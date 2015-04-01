package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Anagram variations:
 * 1. isAnagram - check if given two strings are anagrams or not.
 * 2. groupAnagrams - align anagrams next to each other.
 * 3. printAnagrams - print all possible anagrams for a given string.
 * 
 * @author abpatil1
 */
public class AnagramVariations {
	public static void main(String[] args) {
		//System.out.println(isAnagram("cat", "tac"));
		//System.out.println(isAnagram("cate", "taci"));
		
		//permute("abh");
		
		printPermutations("abh".toCharArray(),0);
	}

	/**
	 * complexity: O(n)
	 * @param word1
	 * @param word2
	 * @return
	 */
	private static boolean isAnagram(String word1, String word2) {
		if (word1.length() != word2.length())
			return false;

		// this set is used to remove duplicates.
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < word1.length(); i++) {
			set.add(word1.charAt(i));
		}

		for (int i = 0; i < word2.length(); i++) {

			// if a character is found is which is not present in the other word, then return false.  
			if(!set.contains(word2.charAt(i))){
				return false;
			}
		}
		return true;
	}

	public static void permute(String input) {
		int inputLength = input.length();
		boolean[] used = new boolean[inputLength];
		StringBuffer outputString = new StringBuffer();
		char[] in = input.toCharArray();
		doPermute(in, outputString, used, inputLength, 0);

	}

	public static void doPermute(char[] in, StringBuffer outputString, boolean[] used, int inputLength, int level) {
		if (level == inputLength) {
			System.out.println(outputString.toString());
			return;
		}

		for (int i = 0; i < inputLength; ++i) {

			if (used[i])
				continue;

			outputString.append(in[i]);
			used[i] = true;
			doPermute(in, outputString, used, inputLength, level + 1);
			used[i] = false;
			outputString.setLength(outputString.length() - 1);
		}
	}
	
	private static void printPermutations(char[] cArr, int currentFocus) {
        if(currentFocus == cArr.length-1){
            System.out.println(new String(cArr));
            return;
        }
        printPermutations(cArr, currentFocus+1);
        
        for(int i= currentFocus+1; i< cArr.length;++i){
            if(cArr[i] != cArr[currentFocus]){
                char t = cArr[currentFocus];
                cArr[currentFocus] = cArr[i];
                cArr[i] = t;

                printPermutations(cArr, currentFocus+1);
                
                t = cArr[currentFocus];
                cArr[currentFocus] = cArr[i];
                cArr[i] = t;
            }
        }
    }
	    
}
