/**
 * Created by Administrator on 2014/12/23.
 */
public class Problem73 {
    /*
    欧几里得算法求最大公约数
     */
    private static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = 0;
        float low = (float) 1 / (float) 3;
        float high = (float) 1 / (float) 2;
        for (int i = 1; i < 12000; i++) {
            for (int j = i + 1; j <= 12000; j++) {
                if (gcd(i, j) == 1) {
                    float tmp = (float) i / (float) j;
                    if (tmp > low && tmp < high) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        long end = System.currentTimeMillis();
        System.out.printf("执行时间为: %dms.",end - start);
    }
}
