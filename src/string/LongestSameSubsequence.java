
//if there is string "aabbbcc" then o/p will be bbb
//if there is string "abcd" then o/p will be abcd

package string;

public class LongestSameSubsequence {
	private static String str = "aaabbcccccdd";

	public static void main(String [] args){
		getLongestSameSubsequence(str);
	}

	public static void getLongestSameSubsequence(String str){
		StringBuilder output = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		int tempLength = 1;
		int outputLength = 1;
		if (str.length() < 1) return;
		if (str.length() == 1) 
			System.out.println(str);
		else if (str.length() > 1){
			output.append(str.charAt(0));
			temp.append(str.charAt(0));

			for (int i = 1; i <= str.length();i++){
				
				if (i == str.length() && tempLength > outputLength){
					output.setLength(0);
					output.append(temp);
					break;
				}else if (i == str.length() && tempLength == 1 && outputLength == 1){
					break;
				}
					
				if (str.charAt(i) == str.charAt(i-1)){
					temp.append(str.charAt(i));
					tempLength++;
				}else {
					if (tempLength > outputLength){
						output.setLength(0);
						output.append(temp);
						outputLength = tempLength;
						tempLength = 1;
						temp.setLength(0);//clear temp string buffer
						temp.append(str.charAt(i));
					}
				}
			}
		}
		if (tempLength == outputLength)
			System.out.println(str.toString());
		else
			System.out.println(output.toString());
	}

}
