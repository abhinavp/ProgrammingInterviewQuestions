package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IsomorphismNWords{
	
	private static java.util.List<String> list =  new ArrayList<String>();
	
	public static void main(String [] args){
		list.add("turtle");
		list.add("tletur");
		String first = getIsomorohicCode(list.get(0));
		System.out.println(isListIsomorphic(list, first));	
	}
	
	private static boolean isListIsomorphic(java.util.List<String> list, String first){
		for (int i = 1; i < list.size(); i++){
			if (!getIsomorohicCode(list.get(i)).equals(first)){
				return false;
			}
		}
		return true;
	}

	// for 2 strings
	public static boolean isIsomorphic(String word1, String word2){
		String first = getIsomorohicCode(word1);
		String second = getIsomorohicCode(word2);
		if (first.equals(second)){
			return true;
		}
		return false;
	}

	public static String getIsomorohicCode(String word1){
		StringBuffer buffer = new StringBuffer();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < word1.length(); i++){
			if (!map.containsKey(word1.charAt(i))){
				map.put(word1.charAt(i), i);
				buffer.append(map.get(word1.charAt(i)));
			}else{
				buffer.append(buffer.append(map.get(word1.charAt(i))));
			}
		}
		return buffer.toString();
	}
}
