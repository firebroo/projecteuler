import java.math.BigInteger;

/**
 * Created by Administrator on 2014/12/15.
 */
public class Problem10 {
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
        BigInteger sum = new BigInteger("0");
        for (Integer i = 2; i < 2000000; i++) {
            if (isPrime(i)) {
                sum = sum.add(new BigInteger(i.toString()));
            }
        }
        System.out.println(sum);
    }
}
