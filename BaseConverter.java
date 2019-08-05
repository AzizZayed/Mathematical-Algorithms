public class BaseConverter {

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
		long input;
		String strIn = "2D";
		int base = 16;

		input = 111111;

		res = BaseConverter.toBase10(base, strIn);
		System.out.println(strIn + " in base " + base + " is " + res + " in base 10");
	}

}
