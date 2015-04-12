
//A subsequence of a string S, is a set of characters that appear in leftto-right order, 
//but not necessarily consecutively

package string;

public class LongestCommonSubsequence {

	private static String str1 = "ABABC";
	private static String str2 = "BABCA";
	public static void main(String [] args){
		getLongestCommonSubstring(str1, str2);
	}
	
	public static void getLongestCommonSubstring(String str1, String str2){
		if (str1.length() < 1 || str2.length() < 1)
			return;
		
		
	}
}
