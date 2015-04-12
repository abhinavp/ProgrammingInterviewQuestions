package number;

public class Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(pow(-2, 2));
		System.out.println(efficientPowerAlgorithm(2, 3));

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
	
	public static double efficientPowerAlgorithm(double base, int power){
		if (base == 0) return 0;
		if (power == 0) return 1;
		if(power == 1) return base;
		if (power == -1) return (1/base);
		
		double value = 1;
		
		while(true){
			
			double t = power % 2;
			power = (int) Math.floor(power/2);//floor - nearest largest integer of the argument 40.1 -> 40, -42.5 > -43, 40 > 40
			
			if (t == 1){
				value = value * base;
			}
			
			if(power == 0){
				break;
			}
			
			base = base * base;
		}
		
		return value;
	}

}