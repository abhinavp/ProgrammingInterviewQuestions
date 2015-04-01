package number;

public class Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(-2, 2));

	}

	public static double pow(double base, int power) {

		if(base == 0) return 0;
		if (power == 0) return 1;
		
		if (power == 1) return base;
		if (power == -1) return (1 / base);
		
		double value = 1;
		int powerVal = Math.abs(power);
		while(powerVal > 0){
				value *= base;
				powerVal--;
		}
		return (power > 0) ? value : 1 / value;
	}
//		return Math.pow(base, power);
}
