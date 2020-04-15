/**
 * calculate the factorial
 */
public class FactorialCalculator {

	/**
	 * Calculate the factorial of an integer input iteratively
	 * 
	 * @param n - integer input
	 * @return factorial of the integer input
	 */
	public static long iterativeFactorial(int n) {

		long result = 1;

		for (int i = 2; i <= n; i++) {
			result = result * i;
		}

		return result;

	}

	/**
	 * Calculate the factorial of an integer input recursively
	 * 
	 * @param n - integer input
	 * @return factorial of the integer input
	 */
	public static long recursiveFactorial(int n) {

		if (n <= 1) // 0! = 1! = 1
			return 1;
		else
			return n * recursiveFactorial(n - 1);

	}

	/**
	 * Calculate the factorial of a big integer input made for result that a long is
	 * unable to carry in memory
	 * 
	 * @param n - integer input
	 * @return factorial of a big integer input
	 */
	public static String bigFactorial(int n) {

		final int MAX_IN = 20;
		String result = "";

		if (n < 0)
			return null;
		if (n <= MAX_IN) {
			return Long.toString(recursiveFactorial(n));
		} else {

			result = Long.toString(recursiveFactorial(MAX_IN));

			for (int i = MAX_IN + 1; i <= n; i++) {
				result = stringMultiply(result, i);
			}

		}

		return result;

	}

	/**
	 * Multiply an integer stored in a string to an integer stored in an Integer
	 * data type. This function works because multiplication is basically glorified
	 * addition. example: 3 * 4 = 3 + 3 + 3 + 3, So we just add the string to itself
	 * a fixed amount of times, in this case the parameter "multiplier" tells you
	 * how many times to add the string to itself. Basically what you used to do in
	 * elementary school... but on steroids...
	 * 
	 * @param str:        String storing a very big integer too big for the Long
	 *                    data type
	 * @param multiplier: multiplier of type Integer
	 * @return the product of the 2 parameters
	 */
	private static String stringMultiply(String str, int multiplier) {

		String result = "";
		short carry = 0;
		int length = str.length();

		for (int i = 0; i < length; i++) { // Iterate through the string
			short digit = Short.parseShort(Character.toString(str.charAt(length - i - 1)));
			int partialProduct = digit * multiplier + carry;
			carry = (short) (partialProduct / 10);
			short partialresult = (short) (partialProduct % 10);

			result = Short.toString(partialresult) + result;
		}

		result = Short.toString(carry) + result; // add the last digit that we neglected, MUST do

		return result;

	}

	public static void main(String[] args) {
		System.out.println("Code Testing:");

		Long fact;

		fact = FactorialCalculator.iterativeFactorial(5);
		System.out.println("5! = " + fact);

		fact = FactorialCalculator.recursiveFactorial(5);
		System.out.println("5! = " + fact);

		String strFact = FactorialCalculator.bigFactorial(1000);
		System.out.println("1000! = " + strFact);
	}

}
