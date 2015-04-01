package misc;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Example {

	ArrayList<String> products = new ArrayList<String>();
	ArrayList<String> customers = new ArrayList<String>();

	public static void main(String[] args) {

		Example ex = new Example();
		ex.populateInput();
		ex.calculateSS();

	}

	public void populateInput() {

		try {
			String location = "/Users/abpatil1/workspace/test/src/sush/file";
			BufferedReader br = new BufferedReader(new FileReader(location));

			String strLine = "";
			while ((strLine = br.readLine()) != null) {
				String[] line = strLine.split(";");

				String[] names = line[0].split(",");

				System.out.println("names of customers");
				for (String name : names) {
					customers.add(name);
					System.out.println(name);
				}
				System.out.println("----------------");
				System.out.println("names of products");
				String[] items = line[1].split(",");
				for (String item : items) {
					products.add(item);
					System.out.println(item);
				}
				System.out.println("----------------");

			}

		} catch (IOException e) {
			System.out.println("File error");
			e.printStackTrace();
		}

	}

	public void calculateSS() {
		
		StringBuffer score_product = new StringBuffer();
		double[][] array = new double[products.size()][customers.size()];
		int row = 0;
		// for every customer
		for (String product : products)
		{
			int column = 0;
			for (String clientName : customers) 
			 // try every product to find the max
			{
				double score;
				int client_letters = countLetter(clientName);
				int client_vowels = countVowels(clientName);
				int client_consonants = client_letters - client_vowels;

				int product_letters = countLetter(product);

				int gcd = calculateGcd(client_letters, product_letters);

				if (product_letters % 2 == 0) {
					// even case
					score = (client_vowels * 1.5);

				} else {
					score = client_consonants;
				}

				if (gcd > 1) {

					score = score * 1.5;

				}
				array[row][column++] = score;
				score_product.append(score + ",");

			}
			row++;
			score_product.append(";");

		}
		System.out.println("Scores" + score_product);
		for (int a = 0; a < array.length; a++) {
			for (int b = 0; b < array[a].length; b++) {
				System.out.print(array[a][b] + "\t");
			}
			System.out.println();
		}

	}


	public int countLetter(String input) {
		int no_of_letters = 0;
		char[] countLetters = input.toCharArray();
		for (int j = 0; j < countLetters.length; j++) {
			Character a = countLetters[j];
			if (a.isLetter(a)) {
				no_of_letters++;
			}
		}
		return no_of_letters;

	}

	public int countVowels(String input) {
		int vowel = 0;
		char[] name = input.toCharArray();
		for (char letter : name) {
			if (isVowel(letter)) {
				vowel++;

			}
		}
		return vowel;

	}

	public boolean isVowel(char input) {
		if (input == 'a' || input == 'e' || input == 'i' || input == 'o'
				|| input == 'u' || input == 'y' || input == 'A' || input == 'E'
				|| input == 'I' || input == 'O' || input == 'U' || input == 'Y') {
			return true;
		}
		return false;
	}

	public int calculateGcd(int input1, int input2) {
		if (input2 == 0)
			return input1;
		return calculateGcd(input2, input1 % input2);
	}

}