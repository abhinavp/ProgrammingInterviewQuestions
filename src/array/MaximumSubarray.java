
//find the contiguous sub array which has the largest sum

//it is based on Kadane's algorithm
//http://en.wikipedia.org/wiki/Maximum_subarray_problem
//good example of dynamic programming
//time complexity: O(n)

package array;

public class MaximumSubarray {
	
	static int [] num = new int[]{-5, 7, 2, -4, 12};
	
	public static void main(String[] args) {
		getMaximumSubsequence(num);
	}
	
	//time complexity : O(n)
	public static void getMaximumSubsequence(int [] num){
		
		if (num.length < 1) return ;
		if (num.length == 1) return;
		
		int tempSum = num[0];
		int maxSum = num[0];
		int beginTemp = 0;
		int begin = 0;
		int end = 0;
		
		for (int i = 1; i < num.length; i++){
			
			tempSum = tempSum + num[i];
			
			if (num[i] > tempSum){
				tempSum = num[i];
				beginTemp = i;
			}
			
			if (tempSum > maxSum){
				maxSum = tempSum;
				begin = beginTemp;
				end = i;
			}
			
		}
		System.out.println("begin index : "+begin);
		System.out.println("end index : "+end);
		System.out.print("subarray : ");
		for (int i = begin; i <= end; i++)
			System.out.print(+num[i]+",");
		System.out.println("");
		System.out.println("maximum subarray sum : "+maxSum);
	}

}
