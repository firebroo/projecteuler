import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/12/15.
 */
public class Problem3 {
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
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private static BigInteger maxFactor(BigInteger x) {
        List<Integer> list = generatePrimeList();
        for(Integer i : list) {
            if (x.mod(new BigInteger(i.toString())).equals(new BigInteger("0"))) {
                if (x.equals(new BigInteger(i.toString()))) {
                    return x;
                }
                return maxFactor(x.divide(new BigInteger(i.toString())));
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(maxFactor(new BigInteger("600851475143")));
    }
}
