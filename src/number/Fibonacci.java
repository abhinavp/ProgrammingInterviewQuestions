package number;

public class Fibonacci {

	static int n = 5;
	
	public static void main(String [] args){
//		for(int i = 0; i < n; i++)
//			System.out.println(generateFib(i));
		System.out.println(fact(5));
	}
	
	private static int generateFib(int n){
		if(n == 0)
			return 0;
		
		if (n == 1) 
			return 1;
		return generateFib(n-2) + generateFib(n-1);
	}
	
	public static int fact(int n){
		if (n == 0 || n == 1) return 1;
		return n * fact(n-1);
	}
}
