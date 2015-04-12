package array;

public class MaximumProductSubarray {

	public int maxProduct(int[] A) {
		if (A == null || A.length == 0){
			return 0;
		}
		int max_here = 1;
		int min_here = 1;
		int max_so_far = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++){
			if (A[i] > 0) {
				max_here *= A[i];
				min_here *= A[i];
				max_so_far = Math.max(max_so_far, max_here);
			} else if (A[i] < 0){
				max_so_far = Math.max(max_so_far, min_here * A[i]);
				int temp = max_here;
				max_here = Math.max(1, min_here * A[i]);
				min_here = temp * A[i];
			} else {
				max_so_far = Math.max(max_so_far, 0);
				max_here = 1;
				min_here = 1;
			}
		}
		return max_so_far;
	}
}