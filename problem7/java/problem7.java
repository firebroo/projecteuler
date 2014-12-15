/**
 * Created by Administrator on 2014/12/15.
 */
public class Problem7 {
    private static boolean isPrime(int x) {
        int high = (int) Math.sqrt(x);
        for (int i = 2; i < high + 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; ; i++) {
            if (isPrime(i)) {
                count += 1;
            }
            if (count == 10001) {
                System.out.println(i);
                break;
            }
        }
    }
}
