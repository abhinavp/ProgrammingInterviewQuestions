package array;

public class BinarySearchModifiied {
	/** 
	 * Return the smallest character that is strictly larger than the search character,
	 * otherwise return the first character in the array.
	 * @param sortedArr : sorted list of letters, sorted in ascending order.
	 * @param c : character for which we are searching.
	 * Given the following inputs we expect the corresponding output:
	 * ['c', 'f', 'j', 'p', 'v'], 'a' => 'c'
	 * ['c', 'f', 'j', 'p', 'v'], 'c' => 'f'
	 * ['c', 'f', 'j', 'p', 'v'], 'k' => 'p'
	 * ['c', 'f', 'j', 'p', 'v'], 'z' => 'c' // The wrap around case
	 
	 
	 null,c //exception
	 "",c //exception
	 "",char not from a to z
	  * ['c', 'f', 'j', 'p', 'v'], 'v' => 'c'
	 [z,z,z],z // 
	 
	 
	 */
	 
	 

	char findInsPoint(String sortedArr, char c)
	{

	    if(!isChar(c)){
	        throw new IllegalArgumentException("");
	    }
	    
	    if(sortedArr == null || sortedArr.isEmpty()){
	        throw new IllegalArgumentException("");
	    }
	    
	    if(c >= sortedArr.charAt(sortedArr.length()-1)){
	        return sortedArr.charAt(0);
	    }
	       
	    return binarySearch(sortedArr.toCharArray(),0,sortedArr.length() - 1,c);
	}

	public char binarySearch(char[] sortedArr,int start, int end, char c){
	    
	       
	       if(start>=end){
	           return sortedArr[start];
	       } 
	       
	       int mid = (start + end) / 2;
	       if(sortedArr[mid] == c){
	           return sortedArr[mid + 1];
	       } else if(sortedArr[mid] > c){
	           return binarySearch(sortedArr,start,mid-1,c); 
	       } else {
	           return binarySearch(sortedArr,mid+1,end,c);
	       }
	}

	boolean isChar(char c){
	    if(c > 'a' || c < 'z'){
	        return true;
	    }
	    return false;
	}
}
