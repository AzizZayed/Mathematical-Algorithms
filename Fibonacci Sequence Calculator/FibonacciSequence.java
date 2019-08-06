
public class FibonacciSequence {

	public static final int MAX_NTH_FIBO = 92;
	public static final int MAX_STR_FIBO = 1000000;
	private long[] sequence = new long[MAX_NTH_FIBO + 1];
	private String[] strSequence = new String[MAX_STR_FIBO + 1];

	public FibonacciSequence() {
		sequence[0] = 0;
		sequence[1] = 1;
		strSequence[0] = "0";
		strSequence[1] = "1";

		for (int i = 2; i < sequence.length; i++) {
			long res = sequence[i - 1] + sequence[i - 2];
			sequence[i] = res;
			strSequence[i] = Long.toString(res);
		}

	}

	public long term(int n) {

		if (n <= MAX_NTH_FIBO)
			return sequence[n];

		return -1;
	}

	public String strTerm(int n) {

		if (n <= MAX_STR_FIBO) {
			String res = strSequence[n];
			if (res != null)
				return res;
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
			strSequence[n] = c;

		return c;
	}

	public static void main(String[] args) {
		FibonacciSequence seq = new FibonacciSequence();

		int n = 90;

		System.out.println(seq.strTerm(n));
	}

}
