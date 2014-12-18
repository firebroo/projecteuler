**
 * Created by Administrator on 2014/12/18.
 */
/*
这个算法不是重点，这种暴力算法果然和我想的一样，算了几个小时还是没有算出来...
其实仔细思考一下，答案口算都能出来！就是求前n项素数的乘积小于1000000的那个数.
result = 2 * 3 * 5 * 7 * 11 * 17 < 1000000
 */
public class Problem69 {
    private static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x % y);
        }
    }

    private static int totientFunction(int x) {
        int count = 1;
        for (int i = 2; i < x; i++) {
            if (gcd(x, i) == 1) {
                count++;
            }
        }
        return x / count;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int maximum = 0;
        int result = 0;
        for (int i = 1; i <= 100000; i++) {
            int tmp = totientFunction(i);
            if (tmp > result) {
                result = tmp;
                maximum = i;
            }
        }
        System.out.println(maximum);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
