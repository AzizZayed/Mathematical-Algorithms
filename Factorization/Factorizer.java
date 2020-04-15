import java.util.ArrayList;
import java.util.Collections;

/**
 * class with a few factoring tools
 */
public class Factorizer {

	/**
	 * sort array automatically
	 */
	private static boolean autoSort = true;

	/**
	 * compute all factors of a number
	 * 
	 * @param n - number to get factors of
	 * @return arraylist with all the factors
	 */
	public static ArrayList<Long> factorize(long n) {
		ArrayList<Long> factors = new ArrayList<Long>();
		double sqrtNum = Math.sqrt(n);
		int perfSquare = sqrtNum == Math.floor(sqrtNum) ? 1 : 0;
		double bound = sqrtNum + perfSquare;

		factors.add(1L);
		for (long i = 2; i < bound; i++) {
			if ((n % i) == 0)
				factors.add(i);
		}

		bound = factors.size() - perfSquare;

		for (int i = 0; i < bound; i++) {
			factors.add(n / factors.get(i));
		}

		if (autoSort)
			Collections.sort(factors);

		return factors;
	}

	/**
	 * get the greatest common factor of 2 numbers
	 * 
	 * @param a - first number
	 * @param b - second number
	 * @return the greatest common factor of the 2 numbers
	 */
	public static long greatestCommonFactor(long a, long b) {
		if (b == 0)
			return a;
		return greatestCommonFactor(b, a % b);
	}

	/**
	 * get the least common multiple of 2 numbers
	 * 
	 * @param a - first number
	 * @param b - second number
	 * @return the least common multiple of the 2 numbers
	 */
	public static long leastCommonMultiple(long a, long b) {
		return (a * b / greatestCommonFactor(a, b));
	}

	/**
	 * get the common factors of 2 numbers
	 * 
	 * @param a - first number
	 * @param b - second number
	 * @return an arraylist of the common factors
	 */
	public static ArrayList<Long> commonFactors(long a, long b) {
		ArrayList<Long> commonFactors = new ArrayList<Long>();

		autoSort = false;
		ArrayList<Long> allFactors = factorize(a);
		allFactors.addAll(factorize(b));
		Collections.sort(allFactors);
		autoSort = true;

		for (int i = 0; i < allFactors.size() - 1; i++) {
			if (allFactors.get(i) == allFactors.get(i + 1))
				commonFactors.add(allFactors.get(i));
		}

		return commonFactors;
	}

	/**
	 * compute all prime factors of a number
	 * 
	 * @param n - number to get prime factors of
	 * @return arraylist with all the prime factors
	 */
	public static ArrayList<Long> primeFactorize(long n) {
		ArrayList<Long> primeFactors = new ArrayList<Long>();
		double sqrtNum = Math.sqrt(n);

		for (long i = 2; i < sqrtNum; i++) {
			while ((n % i) == 0) {
				primeFactors.add(i);
				n = n / i;
			}
		}

		if (n > 1)
			primeFactors.add(n);

		return primeFactors;
	}

	public static void main(String[] args) {
		System.out.println("Code Testing:");

		long a = 15, b = 30;

		System.out.println("Factors of " + a + " : " + Factorizer.factorize(a));
		System.out.println("Factors of " + b + " : " + Factorizer.factorize(b));

		System.out.println("Prime factors of " + a + " : " + Factorizer.primeFactorize(a));
		System.out.println("Prime factors of " + b + " : " + Factorizer.primeFactorize(b));

		System.out.println("Common factors of " + a + " and " + b + " : " + Factorizer.commonFactors(a, b));

		System.out
				.println("Least common multiple of " + a + " and " + b + " : " + Factorizer.leastCommonMultiple(a, b));

		System.out.println(
				"Greatest common factor of " + a + " and " + b + " : " + Factorizer.greatestCommonFactor(a, b));

	}
}
