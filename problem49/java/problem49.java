import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
写完才发现原来另一个sequence的增量也是3330。。
 */

/**
 * Created by Administrator on 2014/12/19.
 */
public class Problem49 {
    private static boolean isPrime(int x) {
        int high = (int) Math.sqrt(x);
        for (int i = 2; i < high + 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPermutations(int x, int y) {
        String string1 = String.valueOf(x);
        String string2 = String.valueOf(y);
        int[] a = new int[string1.length()];
        int[] b = new int[string2.length()];
        for (int i = 0; i < string1.length(); i++) {
            a[i] = new Integer(string1.substring(i, i + 1)).intValue();
        }
        for (int j = 0; j < string2.length(); j++) {
            b[j] = new Integer(string2.substring(j, j + 1)).intValue();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            sb1.append(String.valueOf(a[i]));
        }
        for (int i = 0; i < b.length; i++) {
            sb2.append(String.valueOf(b[i]));
        }
        if (sb1.toString().equals(sb2.toString())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1000; i < 9999; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        for (Integer i : list) {
            list.forEach((j) -> {
                if (isPermutations(i, j) && i != j && i > j) {
                    int tmp = i - j;
                    int third = i + tmp;
                    if (isPrime(third) && isPermutations(third, j)) {
                        System.out.println(String.valueOf(j) + String.valueOf(i) + String.valueOf(third));
                    }
                }
            });
        }
    }
}
