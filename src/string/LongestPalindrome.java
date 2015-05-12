package string;

public class LongestPalindrome {
	public static void main(String[] args) {
		//String str = "nittinaade";
		//System.out.println(isPalindrome(str, 0, str.length()));
		longestPalindrome("nittinaade");
		longestPalindrome("nitinaade");
		longestPalindromeNaive("nittinaade");
		longestPalindromeNaive("nitinaade");
	}

	// BBABCBCAB
	// nitin
	// niin
	public static void longestPalindrome(String string) {

		int start = 0, end = 0;
		for (int mid = 0; mid < string.length(); mid++) {
			int left = mid;
			int right = mid;
			while (left >= 0 && right < string.length()) {
				if (string.charAt(left) == string.charAt(right) && (right - left > end - start)) {
					end = right;
					start = left;
				}
				left--;
				right++;
			}
		}

		for (int mid = 0; mid < string.length(); mid++) {
			int left = mid;
			int right = mid+1;
			while (left >= 0 && right < string.length()) {
				if (string.charAt(left) == string.charAt(right) && (right - left > end - start)) {
					end = right;
					start = left;
				}
				left--;
				right++;
			}
		}

		System.out.println("longest palindrome: " + string.substring(start, end + 1));
	}
	
	
	public static void longestPalindromeNaive(String string){
		int right = 0;
		int left = 0;
		for(int i=0;i<string.length();i++){
			for(int j=i+1;j<string.length();j++){
				if(isPalindrome(string,i,j)){
					if(j-i > right-left){
						right = j;
						left = i;
					}
				}
			}
		}
		
		System.out.println("longest palindrome: " + string.substring(left,right+1));
	}

	public static boolean isPalindrome(String string, int start, int end) {
		for (int i = start; i <= (start+end)/2; i++) {
			if (string.charAt(i) != string.charAt((start+end) - i)) {
				return false;
			}
		}
		return true;
	}
}