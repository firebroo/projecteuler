import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2014/12/16.
 */
public class Problem23 {
    private static boolean isAbundant(int x) {
        int sum = 0;
        for (int i = 1; i < x / 2 + 1; i++) {
            if (x % i == 0) {
                sum += i;
            }
        }
        if (sum > x) {
            return true;
        }
        return false;
    }

    private static Set<Integer> twoAbundantNumbersList() {
        Set<Integer> set = new HashSet<>(28000);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 28123; i++) {
            if (isAbundant(i)) {
                list.add(i);
            }
        }
        for (Integer i : list) {
            for (Integer j : list) {
                int tmp = i + j;
                if (tmp > 28123) break;
                set.add(tmp);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Set<Integer> set = twoAbundantNumbersList();
        int sum = 0;
        for (int i = 1; i <= 28123; i++) {
            sum += i;
        }
        int result = sum - set.stream().reduce((x, y) -> x + y).get();
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
