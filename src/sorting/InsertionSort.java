package sorting;

public class InsertionSort{
	public static void main(String[] args){
		int[] numbers  = {13,54,56,16,34,15,35,23};
		
		insertionSort(numbers);
		for(int i : numbers) {
			System.out.println(i);
		}
	}
	
	public static void insertionSort(int[] numbers){
		int i;
		for(int j=1;j<numbers.length;j++) {
			int temp = numbers[j];
			i=j;
			while(i>0 && numbers[i-1] >= temp) {
				numbers[i] = numbers[i-1];
				i--;
			}
			numbers[i] = temp;
		}
	}
}