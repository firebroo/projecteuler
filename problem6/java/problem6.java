import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/12/15.
 */
public class Problem6 {
    public static List<Integer> generateList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        return list;
    }

    public static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        List<Integer> list = generateList();
        Integer result1 = list.stream().map((x) -> square(x)).reduce((x, y) -> x + y).get();
        Integer result2 = square(list.stream().reduce((x, y) -> x + y).get());
        System.out.println(result2 - result1);
    }
}
