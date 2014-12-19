import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/19.
 */
public class Problem51 {
    private static boolean isPrime(int x) {
        int high = (int) Math.sqrt(x);
        for (int i = 2; i < high + 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static Map<Integer, Integer> produceHashMap(int x) {
        String string = String.valueOf(x);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            int tmp = new Integer(string.substring(i, i + 1)).intValue();
            if (map.get(tmp) != null) {
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        return map;
    }

    private static boolean isProductEightPrime(int x) {
        Map<Integer, Integer> map = produceHashMap(x);
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > 2) {
                for (int i = 0; i < 10; i++) {
                    int result = new Integer(String.valueOf(x).replaceAll(String.valueOf(key), String.valueOf(i))).intValue();
                    if (isPrime(result) && result > 100000) {
                        count++;
                    }
                }
            }
        }
        if (count == 8) {
            return true;
        }
        return false;
    }

    private static boolean isHaveSameDigits(int x) {
        Map<Integer, Integer> map = produceHashMap(x);
        for (Integer key : map.keySet()) {
            if (map.get(key) >= 2) {
                return true;
            }
        }
        return false;
    }

    private static int getSmallestPrime() {
        for (int i = 2; i < 1000000; i++) {
            if (isPrime(i) && isHaveSameDigits(i)) {
                if (isProductEightPrime(i)) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int result = getSmallestPrime();
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
