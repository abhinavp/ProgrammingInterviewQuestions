

//in place quick sort algorithm which means that no extra memory will be used while sorting
//space complexity is O(1) 
//

package sorting;

public class QuickSort {

	static int [] num = new int []{-10, -20, -5, -2, -3};
	public static void main(String [] args) {
		try {
			sort(num, 0, num.length-1);
		} catch (ArrayEmptyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getError());
		}
		display(num);
	}
	
	public static void display(int [] num){
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i]+",");
	}
	
	public static void sort(int [] num, int start, int end) throws ArrayEmptyException {
		if(num.length < 1)
			throw new ArrayEmptyException("array is empty");
		int partition = partition(num, start, end);
		if (start < partition)
			sort(num, 0, partition);
		if (partition < end)
			sort(num, partition+1, end);
	}
	
	public static int partition(int [] num, int start, int end) {
		int pivot = num[(start+end)/2];
		int i = start;
		int j = end;
		while (i < j) {
			while(num[i] < pivot)
				i++;
			while(num[j] > pivot)
				j--;
			if(i < j) {
				swap(num, i, j);
			}
		}
		return i;
	}
	public static void swap(int [] num, int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
}

class ArrayEmptyException extends Exception {
	String error;
	public ArrayEmptyException(String error) {
		this.error = error;
	}
	public String getError() {
		return error;
	}
}