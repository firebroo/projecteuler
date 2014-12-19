import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/12/18.
 */
public class Test {
    private static boolean isPrime(int x) {
        int high = (int) Math.sqrt(x);
        for (int i = 2; i < high + 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> generatePrimeList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            list.add(i);
        }
        return list;
    }

    private static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        List<Integer> list = generatePrimeList();
        int result = 0;                                  /*统计最大可以产生多少个素数.*/
        int a = 0;                                       /*系数a的值.*/
        int b = 0;                                       /*系数b的值.*/
        for (int i = -1000; i <= 1000; i++) {
            for (int prime : list) {
                int count = 0;
                for (int j = 0; j < 100; j++) {           /*猜想了下，应该不会超过100，改成1000也是可以的.*/
                    int tmp = square(j) + i * j + prime;
                    if (tmp < 0) {
                        break;
                    }else if (isPrime(tmp)) {
                        count++;
                        continue;
                    } else {                              /*题目说要连续的素数，所以遇到不是素数直接break循环.*/
                        break;
                    }
                }
                if (count > result) {
                    result = count;
                    a = i;
                    b = prime;
                }
            }
        }
        System.out.println(a * b);
    }
}
