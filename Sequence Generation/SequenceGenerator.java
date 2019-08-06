
import java.util.ArrayList;

public class SequenceGenerator {

	public static ArrayList<Integer> primesUnder(int n) {
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

		boolean[] compositeArray = genCompositeArray(n);

		for (int i = 0; i < compositeArray.length; i++) {
			if (!compositeArray[i])
				primeNumbers.add(i);
		}

		return primeNumbers;
	}

	public static ArrayList<Integer> compositesUnder(int n) {
		ArrayList<Integer> compositeNumbers = new ArrayList<Integer>();

		boolean[] compositeArray = genCompositeArray(n);

		for (int i = 0; i < compositeArray.length; i++) {
			if (compositeArray[i])
				compositeNumbers.add(i);
		}

		return compositeNumbers;
	}

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

	public static long[] triangularNumbersUntil(int n) {
		long[] triangularNums = new long[n + 1];

		for (int i = 0; i < triangularNums.length; i++) {
			triangularNums[i] = (i * (i + 1)) / 2;
		}

		return triangularNums;

	}

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

		long[] x = pythagoreanTriples(n);

		for (int i = 0; i < x.length; i += 3) {
			System.out.println(x[i] + ", " + x[i + 1] + ", " + x[i + 2]);
		}
	}

}
