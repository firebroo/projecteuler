import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo4 {
	private static boolean isPrime(int x) {
		int j = (int) (Math.sqrt(x) + 1);
		for (int i = 2; i < j; i++) {
			if (x % i == 0) {
				return false;
			} else {
				continue;
			}
		}
		return true;
	}

	private static boolean isPandigital(String x) {
		byte[] result = x.getBytes();
		Arrays.sort(result);
		byte[] a = { 49, 50, 51, 52, 53, 54, 55 };
		return Arrays.equals(result, a);
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1000000; i < 9999999; i++) {
			if (isPrime(i) && isPandigital(String.valueOf(i))) {
				list.add(i);
			}
		}
		System.out.println(Collections.max(list));
	}
}
