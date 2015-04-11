package array;

public class RotateCharacterArray {

	public static void main(String[] args){
		char[] characterArray = {'a','b','c','d','e'};
		int k = 2;
		rotateArray(characterArray,k);
		System.out.println(new String(characterArray));
	}
	
	/**
	 * O(n*k) - k is the number of time we want to rotate. 
	 * 
	 * @param characterArray
	 * @param k
	 */
	public static void rotateArray(char[] characterArray, int k) {
		char temp;
		int j;
		for (int i=0;i<k;i++) {
			temp = characterArray[0];
			for(j = 1;j<characterArray.length;j++) {
				characterArray[j-1] = characterArray[j];
			}
			characterArray[j - 1] = temp; 
		}
	}
}
