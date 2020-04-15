/**
 * convert between bases
 */
public class BaseConverter {

	/**
	 * convert to base 10 a long value
	 * 
	 * @param initialBase - the base to convert from
	 * @param value       - the base to convert from
	 * @return the conversion to base 10
	 */
	public static long toBase10(int initialBase, long value) {

		int sign = (int) Math.signum(value);
		String strValue = Long.toString(sign * value);

		long result = 0;
		for (int i = 0; i < strValue.length(); i++) {
			int digit = Character.getNumericValue(strValue.charAt(i));
			double mult = Math.pow(initialBase, strValue.length() - i - 1);
			result += (digit * mult);
		}

		return (sign * result);
	}

	/**
	 * convert to base 10 a number inside a string, means it can be a very very big
	 * number or a number in a higher base than 10
	 * 
	 * @param initialBase - the base to convert from
	 * @param value       - the base to convert from
	 * @return the conversion to base 10
	 */
	public static long toBase10(int initialBase, String value) {

		boolean negative = false;
		if (value.charAt(0) == '-') {
			value = value.substring(1);
			negative = true;
		}

		long result = 0;
		for (int i = 0; i < value.length(); i++) {
			int digit = Character.getNumericValue(value.charAt(i));
			double mult = Math.pow(initialBase, value.length() - i - 1);
			result += (digit * mult);
		}

		return (negative ? -result : result);
	}

	public static void main(String[] args) {
		System.out.println("Code Testing:");

		long res;
		int base;

		String strIn = "2D"; // hex
		base = 16;
		res = BaseConverter.toBase10(base, strIn);
		System.out.println(strIn + " in base " + base + " is " + res + " in base 10");

		long input = 111111; // binary
		base = 2;
		res = BaseConverter.toBase10(base, input);
		System.out.println(input + " in base " + base + " is " + res + " in base 10");

		input = 22222; // base 3
		base = 3;
		res = BaseConverter.toBase10(base, input);
		System.out.println(input + " in base " + base + " is " + res + " in base 10");
	}

}
