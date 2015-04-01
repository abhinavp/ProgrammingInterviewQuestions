package string;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic{
	public static void main(String[] args) {
		String str1 = "turtle";
		String str2 = "trutel";
		Map<Character,Integer> map1 = getIsomorphicMap(str1);
		Map<Character,Integer> map2 = getIsomorphicMap(str2);
		
		boolean areMapsEqual = areMapsEqual(map1,map2);
		System.out.println("are Maps equal: " + areMapsEqual);
	}
	
	public static Map<Character,Integer> getIsomorphicMap(String str) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		Character character;
		Integer count;
		for(int i=0;i<str.length();i++) {
			character = str.charAt(i);
			count = map.get(character);
			if(count == null) {
				map.put(character,1);
			} else {
				map.put(character,++count);
			}
		}
		return map;
	}
	
	public static boolean areMapsEqual(Map<?,?> map1, Map<?,?> map2) {
		if(map1 == null || map2 == null || map1.size()!=map2.size()){
			return false;
		} 
		
		for(Object key:map1.keySet()) {
			if(!map1.get(key).equals(map2.get(key))){
				return false;
			}
		}
		return true;
	}
}