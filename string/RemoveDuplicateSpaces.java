package string;

import java.util.StringTokenizer;

public class RemoveDuplicateSpaces {
	public static void main(String a[]){
		String str = "String    With Multiple      Spaces";
		int count = 0;
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuffer sb = new StringBuffer();
		while(st.hasMoreElements()){
			String nextToken = st.nextToken();
			System.out.println(nextToken);
			count++;
			sb.append(nextToken).append(" ");
		}
		System.out.println(sb.toString().trim());
		System.out.print(count);
	}
}