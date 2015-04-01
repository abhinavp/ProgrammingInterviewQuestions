package arrays;
public class MaximumSubArray{

	public static void main(String[] args) {
		int[] array = {-13,-2,-3,-5,-2,-12};
		
		printMaximumSubArray(array);
	}
	
	
	/**
	 * bugs in this code: if all numbers are negative then this program will return maxSum:0 maxStart:0 minStart:0
	 * if all numbers are negative, then either - 
	 * 	1. print the maximum number from the array.
	 *  2. keep a track of max number while going through the loop, have a flag areAllNumbersNegative. At the end check for the flag and print the maxNumber
	 * @param array
	 */
	public static void printMaximumSubArray(int[] array) {
		int maxSum = 0;
		int maxSumStart = 0;
		int maxSumEnd = 0;
		int tempSum = 0;
		int tempSumStart = 0;
		boolean areAllNumbersNegative = true;
		int maxNum = -1;
		
		
		for(int i=0;i<array.length;i++) {
			int futureSum = tempSum + array[i];
			if(futureSum>0) {
				areAllNumbersNegative = false;
				tempSum = futureSum;
				if(tempSum>maxSum) {
					maxSum = tempSum;
					maxSumStart = tempSumStart;
					maxSumEnd = i;
				} else {
				tempSum = 0;
				tempSumStart = i + 1;
				}
			}
			if(areAllNumbersNegative && maxNum <= array[i]) {
				maxSum = array[i];
				maxNum = array[i];
				maxSumStart = i;
				maxSumEnd = i;
			}
		}
		
		System.out.println(" Max sumL: " + maxSum + " Max start: " + maxSumStart + " Max End: " +maxSumEnd);
	}
}