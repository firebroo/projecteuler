import java.util.ArrayList;
import java.util.List;

public class problem {
	private static boolean isPrime(Integer x) {
		Integer high = (int) Math.sqrt(x);
		for (Integer i = 2; i < high + 1; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static List<Integer> generate() {
		List<Integer> list = new ArrayList<Integer>();
		Integer primeSum = 0;
		Integer number = 2;
		while (primeSum < 1000000) {
			if (isPrime(number)) {
				primeSum += number;
				list.add(number);
			}
			number += 1;
		}
		return list;
	}

	private static Integer getMaxPrime() {
		Integer limit = generate().toArray().length - 1;
		List<Integer> list = generate();
		for (Integer i = limit; i > 0; i--) {
			for (Integer j = 0; j < limit - i + 1; j++) {
				List<Integer> subList = list.subList(j, j + i);
				Integer primesSum = 0;
				for (Integer tmp : subList) {
					primesSum += tmp;
				}
				if (primesSum > 1000000) {
					break;
				}
				if (isPrime(primesSum)) {
					return primesSum;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getMaxPrime());
	}
}
