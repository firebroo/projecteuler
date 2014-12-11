public class Problem12 {
	public static Integer test() {
		Integer tmp = 1;
		for (Integer i = 2; i < 1000000; i++) {
			tmp += i;
			Integer counter = 0;
			for (int j = 1; j < (int) Math.sqrt(tmp) + 1; j++) {
				if (tmp % j == 0) {
					counter += 1;
				}
			}
			if (counter >= 250) {
				return tmp;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(test());
	}
}
