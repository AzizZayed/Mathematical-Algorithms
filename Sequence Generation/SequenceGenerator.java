import java.util.ArrayList;

/**
 * arbitrary sequence generator
 */
public class SequenceGenerator {

	/**
	 * generate prime numbers
	 * 
	 * @param n - maximum
	 * @return an arraylist of all prime numbers under n
	 */
	public static ArrayList<Integer> primesUnder(int n) {
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

		boolean[] compositeArray = genCompositeArray(n);

		for (int i = 0; i < compositeArray.length; i++) {
			if (!compositeArray[i])
				primeNumbers.add(i);
		}

		return primeNumbers;
	}

	/**
	 * generate composite numbers
	 * 
	 * @param n - maximum
	 * @return an arraylist of all composite numbers under n
	 */
	public static ArrayList<Integer> compositesUnder(int n) {
		ArrayList<Integer> compositeNumbers = new ArrayList<Integer>();

		boolean[] compositeArray = genCompositeArray(n);

		for (int i = 0; i < compositeArray.length; i++) {
			if (compositeArray[i])
				compositeNumbers.add(i);
		}

		return compositeNumbers;
	}

	/**
	 * generate composite numbers boolean array
	 * 
	 * @param n - maximum
	 * @return a boolean array with true for composite
	 */
	private static boolean[] genCompositeArray(int n) {
		boolean[] compositeNumber = new boolean[n];

		compositeNumber[0] = true;
		compositeNumber[1] = true;

		double sqrtNum = Math.sqrt(n);

		int i = 2;
		while (i <= sqrtNum) {
			if (!compositeNumber[i])
				for (int j = i * 2; j < n; j += i)
					compositeNumber[j] = true;
			i++;
		}

		return compositeNumber;
	}

	/**
	 * triangular number generator
	 * 
	 * @param n - number of triangular number wanted
	 * @return array with triangular number
	 */
	public static long[] triangularNumbers(int n) {
		long[] triangularNums = new long[n];

		for (int i = 0; i < n; i++) {
			int x = i + 1;
			triangularNums[i] = (x * (x + 1)) / 2;
		}

		return triangularNums;

	}

	/**
	 * pythagorean triplets generator
	 * 
	 * @param n - number of triplets
	 * @return array with pythagorean triplets
	 */
	public static long[] pythagoreanTriples(int n) {
		int bound = n * 3;
		long[] triples = new long[bound];

		long a, b, c;
		long u, v;

		for (int i = 2, j = 0; j < bound; i++, j += 3) {
			u = i;
			v = i - 1;

			a = (u * u) - (v * v);
			b = 2 * u * v;
			c = (u * u) + (v * v);

			triples[j] = a;
			triples[j + 1] = b;
			triples[j + 2] = c;
		}

		return triples;
	}

	public static void main(String[] args) {
		int n = 100;

		System.out.println("All prime numbers under " + n + " : " + SequenceGenerator.primesUnder(n));
		System.out.println("All composite numbers under " + n + " : " + SequenceGenerator.compositesUnder(n));

		long[] array;

		n = 5;
		array = SequenceGenerator.triangularNumbers(n);
		System.out.print(n + " first trangular numbers: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}

		array = SequenceGenerator.pythagoreanTriples(n);
		System.out.println("\n" + n + " pythagorean triples:");
		for (int i = 0; i < array.length; i += 3) {
			System.out.println("\t" + array[i] + ", " + array[i + 1] + ", " + array[i + 2]);
		}
	}

}
