import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2014/12/16.
 */
public class Problem21 {
    private static int getCount(int x) {
        int count = 0;
        int average = x / 2;
        for (int j = 1; j <= average; j++) {
            if (x % j == 0) {
                count += j;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 3; i < 10000; i++) {
            int count = getCount(i);
            if (count <= 10000) {
                map.put(i, count);
            }
        }
        for (int key : map.keySet()) {
            int value = map.get(key);
            int count = getCount(value);
            if (key == count && key != value) {
                set.add(key);
                set.add(value);
            }
        }
        System.out.println(set.stream().mapToInt((x) -> x).sum());
        long end = System.currentTimeMillis();
        System.out.printf("程序执行时间为: %dms", end - start);
    }
}
