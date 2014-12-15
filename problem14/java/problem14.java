import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/15.
 */
public class Problem15 {
    public static long getCount(long n) {
        long length = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (3 * n) + 1;
            }
            length++;
        }
        return length;
    }

    public static Map<Long, Integer> getHashMap() {
        Map<Long, Integer> map = new HashMap<>();
        for (Integer i = 1; i < 1000000; i++) {
            Long count = getCount(i);
            map.put(count, i);
        }
        return map;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Map<Long, Integer> map = getHashMap();
        Long maxKey = map.keySet().stream().max((x, y) -> x.compareTo(y)).get();
        System.out.println(map.get(maxKey));
        long end = System.currentTimeMillis();
        System.out.printf("执行的时间为: %dms", end - start);
    }
}
