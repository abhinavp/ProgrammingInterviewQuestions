package number;

//
////find the next higher number
////eg: 1234 -> next higher number is 1243
////12543 -> 13245
////logic : we scan from tenth digit towards left
////At each iteration we check the right digit of the current digit weÕre at
////and if the value of right is greater than current we stop, otherwise we continue to left.
////when we stop that digit would be pivot digit
////then, from digits to the right, we find the smallest digit higher than 2, which is 3
////We swap this digit and the pivot digit
////the pivot digit changed now 
////We sort all the digits to the right of the pivot digit in increasing order
////this will be the solution
//
//package number;
//
//public class NextHighestInteger {
//
//	static int num = 12543;
//
//	public static void main(String [] args){
//		getNextHighestNumber(num);
//	}
//
//	public static int getNextHighestNumber(int num){
//
//		if (num == 0) return 0;
//		if (num == 1) return 1;
//		char[] chars = String.valueOf(num).toCharArray();
//		int currDigit = 0;
//		int rightDigit = 0;
//		int i = chars.length - 1;
//		while (i >= 0){
//			currDigit = chars[chars.length - (i-1)];
//			rightDigit = chars[chars.length - i];
//			if (currDigit < rightDigit)
//				break;
//			i--;
//		}
//		int index = findLargestIndex(chars, i+1, chars.length - 1);
//		swap(chars, i, index);
//		insertionSort(new int[chars.length]);
//		return num;
//	}
//
////	private static void insertionSort(int[] arr) {
////		int i, j, newValue;
////		for (i = 1; i < arr.length; i++) {
////			newValue = arr[i];
////			j = i;
////			while (j > 0 && arr[j - 1] > newValue){
////				arr[j] = arr[j - 1];
////				j--;
////			}
////			arr[j] = newValue;
////		}
////	}
//	
//	public static int findLargestIndex(char [] chars, int a, int b){
//		int max = chars[a];
//		int index = 0;
//		while(a <= b){
//			if (chars[a+1] > max){
//				max = chars[a+1];
//				index = a;
//				a++;
//			}
//		}
//		return index;
//	}
//
//	public static void swap(char[] chars, int a, int b){
//		char temp = chars[a];
//		chars[a] = chars[b];
//		chars[b] = temp;
//	}
//}