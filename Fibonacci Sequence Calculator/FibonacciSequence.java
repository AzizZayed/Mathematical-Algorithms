public class FibonacciSequence {

	private static final int MAX_NTH_FIBO = 92;

	public static long iterativeFibonacci(int n) {

		if (n <= 2)
			return 1;
		
		if (n > MAX_NTH_FIBO)
			return -1;
		
		long a = 0, b = 1, c = 1;
		
		for (int i = 2; i < n; i++) {
			a = b;
			b = c;
			
			c = a + b;
		}
		
		return c;
	}
	
	public static long recursiveFibonacci(int n) {
		
		if (n <= 2)
			return 1;
		
		return (recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2));
	}

	public static String big(int n) {

		if (n <= MAX_NTH_FIBO)
				return Long.toString(iterativeFibonacci(n));

		String a, b, c = "";
		int aLeft, bLeft;
		int add = 0, carry, base = 10;

		a = big(MAX_NTH_FIBO - 1);
		b = big(MAX_NTH_FIBO);

		for (int i = MAX_NTH_FIBO + 1; i <= n; i++) {
			c = "";
			carry = 0;
			aLeft = a.length() - 1;
			bLeft = b.length() - 1;
			while (aLeft >= 0) {
				int aDigit = Character.getNumericValue(a.charAt(aLeft));
				int bDigit = Character.getNumericValue(b.charAt(bLeft));
				add = aDigit + bDigit + carry;
				c = (add % base) + c;
				carry = Math.floorDiv(add, base);
				aLeft--;
				bLeft--;
			}
			if (bLeft >= 0) {
				String rest = b.substring(0, bLeft + 1);
				int extra = Integer.parseInt(rest) + carry;
				c = Integer.toString(extra) + c;
			} else {
				if (carry > 0)
					c = Integer.toString(carry) + c;
			}

			a = b;
			b = c;
		}

		return c;
	}

	public static void main(String[] args) {
		int n = 45;

		System.out.println(FibonacciSequence.iterativeFibonacci(n));
		System.out.println(FibonacciSequence.recursiveFibonacci(n));
		System.out.println(FibonacciSequence.big(n));
	}

}
