package array;

public class MissingNumber {

	public static void main(String [] args){
		int[] arr = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 ,19, 20};
//		int[] arr = new int []{1, 2, 3, 5, 6};
//		findMissingNumber(arr);
//		System.out.println(findMissingNumber(arr));
		System.out.println(findMissingNumber(arr,arr.length));
	}

	
	//using xor operator
	//1. xor all the elements in the array
	//2. xor the array again with result with 1st step
	//3. remaining will be the result
	public static int findMissingNumber(int [] num){
		int xor = 0;
		for (int i = 0 ; i < num.length; i++)
			xor = xor ^ num[i];
		
		for (int i = 0; i < num.length; i++)
			xor = xor ^ num[i];
		
		return xor;
	}

	//using binary search 
	//log n
	public static int findMissingNumber(int [] a, int n)
	{
		int low = 0, mid = 0, high = n-1;
		while (low <= high)
		{
			mid = (low+high)/2;
			if( mid == 0 || a[mid] - a[mid - 1] > 1 ) // order of logic must be preserved as shown.
				return a[mid] - 1;

			if (a[mid] > mid)
				high = mid - 1;
			else //(a[mid] - mid == 1)
				low = mid + 1;
		}

		return 0;
	}
}
