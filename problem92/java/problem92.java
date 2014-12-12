import java.util.HashMap;

public class Demo32 {
	private static HashMap<Integer, Boolean> hashMap = new HashMap<>();
	private static void table(int x, int y) {
		if (x == 89) {
			hashMap.put(y, true);
			return;
		} else if (x == 1) {
			hashMap.put(y, false);
			return;
		} else {
			int a = convert(x);
			table(a, y);
		}
	}
	private static int convert(int x) {
		String string = new Integer(x).toString();
		int a = 0;
		for (int i = 0; i < string.length(); i++) {
			int b = new Integer(string.substring(i, i + 1)).intValue();
			a += square(b);
		}
		return a;
	}

	private static int square(int x) {
		return x * x;
	}

	static {
		for (int i = 1; i < 568; i++) {
			table(i, i);
		}
	}

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		int count = 0;
		for (int i = 1; i < 10000000; i++) {
			int a = convert(i);
			if (hashMap.get(a)) {
				count += 1;
			}
		}
		System.out.println(count);
		System.out.printf("运行时间为: %dms" , System.currentTimeMillis() - time);
	}
}
