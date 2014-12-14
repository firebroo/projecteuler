import java.math.BigInteger;

public class Problem55 {

	private static BigInteger reverseString(BigInteger x) {
		String reversedString = new StringBuilder(x.toString()).reverse()
				.toString();
		return new BigInteger(reversedString);
	}

	private static boolean isPalindrome(BigInteger x) {
		if (reverseString(x).equals(x)) {
			return true;
		}
		return false;
	}

	private static boolean iterator(BigInteger x) {
		int count = 0;
		while (count < 50) {
			BigInteger sum = reverseString(x).add(x);
			count += 1;
			if (isPalindrome(sum)) {
				return true;
			}
			x = sum;
		}
		return false;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 10000; i++) {
			if (!iterator(new BigInteger(String.valueOf(i)))) {
				count += 1;
			}
		}
		System.out.println(count);
		long end = System.currentTimeMillis();
		System.out.printf("执行时间为: %dms." , (end - start));
	}
}
