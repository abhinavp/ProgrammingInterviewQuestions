package binarySearch;

public class SquareRoot{
	public static void main(String[] args) {
		System.out.println("squareRoot(16): "+squareRoot(16));
		System.out.println("squareRoot(5): "+squareRoot(5));
		System.out.println("squareRoot(25): "+squareRoot(25));
		System.out.println("squareRoot(40): "+squareRoot(40));
	}
	
	public static double squareRoot(int num){
		if(num < 0) {
			num = -num;
		}
		
		if(num == 0 || num == 1) {
			return num;
		}
		
		double precision = 0.00001;
		double start = 0;
		double end = num;
		double mid,midsqr;
		
		while(end-start > precision) {
			mid = ( start + end ) / 2;
			midsqr = mid*mid;
			if(num == (midsqr)) {
				return mid;
			} else if(num > midsqr) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		return ( start + end ) / 2;
	}
}