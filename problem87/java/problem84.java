import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by firebroo on 2015/3/20.
 */
public class Problem87 {
    private static boolean isPrime(int x) {
        int high = (int) Math.sqrt(x);
        for (int i = 2; i < high + 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getPrimeList(int num) {
        List<Integer> list = new ArrayList<>();
        int tmp = (int)Math.sqrt(num);
        for(int i=2;i<tmp+1;i++) {
           if (isPrime(i)) {
              list.add(i);
           }
        }
        return list;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Integer> list = getPrimeList(50000000);
        Set<Integer> set = new HashSet<>();
        for(Integer i : list) {
            int tmp1 = (int)Math.pow(i,2);
            for(Integer j : list) {
                int tmp2 = (int)Math.pow(j,3);
                int sum1 = tmp1 + tmp2;
                if (sum1 >= 50000000) break;
                for(Integer k : list) {
                  int tmp3 = (int)Math.pow(k,4);
                    int sum2 = sum1 + tmp3;
                    if(sum2>=50000000) break;
                    set.add(sum2);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(set.size());
        System.out.printf("执行时间是%dms", end - start);
    }
}
