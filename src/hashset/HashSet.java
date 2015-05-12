package hashset;

import java.util.HashMap;

/*
 * reference: http://javahungry.blogspot.com/2013/08/how-sets-are-implemented-internally-in.html
 * 
 */
public class HashSet<K> {
	HashMap<K, Object> map;
	private final static Object DUMMY = new Object();
	public HashSet() {
        map = new HashMap<K,Object>();
    }
	
	public boolean add(K key){
		return map.put(key, DUMMY) == null;
	}
}
