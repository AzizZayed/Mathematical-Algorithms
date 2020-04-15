/**
 * generate fibonacci sequence
 */
public class FibonacciSequencePlus {

	/**
	 * max fibonacci number that can fit in a long data type
	 */
	public static final int MAX_NTH_FIBO = 92;

	/**
	 * max fibonacci number for string
	 */
	public static final int MAX_STR_FIBO = 1000000;

	/**
	 * arrays to contain fibonacci numbers
	 */
	private long[] sequence = new long[MAX_NTH_FIBO + 1];
	private String[] strSequence = new String[MAX_STR_FIBO - MAX_NTH_FIBO];

	/**
	 * Constructor: generate MAX_NTH_FIBO (92) first fibo numbers
	 */
	public FibonacciSequencePlus() {
		sequence[0] = 0;
		sequence[1] = 1;

		for (int i = 2; i < sequence.length; i++) {
			sequence[i] = sequence[i - 1] + sequence[i - 2];
		}

	}

	/**
	 * get the fibo number from the long sequence
	 * 
	 * @param n - fibo number from the sequnce
	 * @return nth fibo number
	 */
	public long term(int n) {

		if (n <= MAX_NTH_FIBO)
			return sequence[n];

		return -1;
	}

	/**
	 * get the fibo number from the string sequence
	 * 
	 * @param n - fibo number from the sequnce
	 * @return nth fibo number
	 */
	public String strTerm(int n) {

		int index = n - MAX_NTH_FIBO - 1;

		if (n <= MAX_NTH_FIBO) {
			long res = sequence[n];
			return Long.toString(res);
		} else if (n <= MAX_STR_FIBO) {
			String res = strSequence[index];
			if (res != null)
				return res;
		} else {
			return null;
		}

		String a, b, c = "";
		int aLeft, bLeft;
		int add = 0, carry, base = 10;

		a = strTerm(MAX_NTH_FIBO - 1);
		b = strTerm(MAX_NTH_FIBO);

		for (int i = MAX_NTH_FIBO + 1; i <= n; i++) {
			c = "";
			carry = 0;
			aLeft = a.length() - 1;
			bLeft = b.length() - 1;
			while (aLeft >= 0) {
				add = Character.getNumericValue(a.charAt(aLeft)) + Character.getNumericValue(b.charAt(bLeft)) + carry;
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

		if (n <= MAX_STR_FIBO)
			strSequence[index] = c;

		return c;
	}

	public static void main(String[] args) {
		FibonacciSequencePlus seq = new FibonacciSequencePlus();

		int n = 45;
		System.out.println(n + "th fibo: " + seq.term(n));

		n = 245;
		long t, dt;

		t = System.nanoTime();
		System.out.print(n + "th big fibo: " + seq.strTerm(n));
		dt = System.nanoTime() - t;
		System.out.println(",   In " + dt + " nanoseconds");

		t = System.nanoTime();
		System.out.print(n + "th big fibo: " + seq.strTerm(n));
		dt = System.nanoTime() - t;
		System.out.println(",   In " + dt + " nanoseconds");

	}

}
