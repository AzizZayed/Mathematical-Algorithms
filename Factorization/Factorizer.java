
import java.util.ArrayList;
import java.util.Collections;

public class Factorizer {

	private static boolean autoSort = true;

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

	public static long greatestCommonFactor(long a, long b) {
		if (b == 0)
			return a;
		return greatestCommonFactor(b, a % b);
	}

	public static long leastCommonMultiple(long a, long b) {
		return ( a * b / greatestCommonFactor(a, b));
	}
	
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

		long n = 145;
		long a = 55;

		long b = Factorizer.leastCommonMultiple(n, a);

		System.out.print(b);

	}
}
