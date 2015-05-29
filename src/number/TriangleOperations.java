package number;


public class TriangleOperations implements Triangle{

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		//int[] array = {5,7,9};

		new TriangleOperations().getTriangleSides(array);
	}

	/**
	 * a,b,c 
	 * a+b > c 
	 * c+b > a 
	 * a+c > b
	 * 
	 * 4,5,6,8,12,11 - sort - (4+5 = 9) 4,5,6,8
	 */
	public int[][] getTriangleSides(int[] sides) {
		int[][] triangleSides = new int[sides.length * sides.length][3];
		int[] sortedSides = new int[sides.length];
		// sortedSides = sort(sortedSides);
		sortedSides = sides;
		
		int count = 0;
		int c;
		for (int a = 0; a < sortedSides.length; a++) {
			for (int b = a + 1; b < sortedSides.length; b++) {
				c = b + 1;
				for (; c < sortedSides.length && (sortedSides[a] + sortedSides[b]) > sortedSides[c]; c++) {
					System.out.println("a:" + sortedSides[a] + " b:" + sortedSides[b] + " c:" + sortedSides[c]);
					triangleSides[count][0] = sortedSides[a];
					triangleSides[count][1] = sortedSides[b];
					triangleSides[count][2] = sortedSides[c];
					count++;
				}
			}
		}
		System.out.println("total no. of possible triangles : "+count);
		return triangleSides;
	}
}
