package array;

public class SelfExcludingProduct {

	public static void main(String [] args){
		int [] num = new int []{2, 6, 4, 8};
		getProductArray(num, 4);
	}
	
	public static void getProductArray(int arr[], int n){
	 int temp = 1;
	 
	  int [] prod = new int[arr.length];
	 
	  /* In this loop, temp variable contains product of
	    elements on left side excluding arr[i] */
	  for(int i = 0; i < n; i++){
	    prod[i] = temp;	
	    temp *= arr[i];
	  }
	 
	  /* Initialize temp to 1 for product on right side */
	  temp = 1;
	 
	  /* In this loop, temp variable contains product of
	    elements on right side excluding arr[i] */
	  for(int i = n-1; i >= 0; i--){
	    prod[i] *= temp;
	    temp *= arr[i];
	  }
	 
	  /* print the constructed prod array */
	  for (int i = 0; i < n; i++){
	    System.out.print(prod[i]+",");
	  }
	}
}
