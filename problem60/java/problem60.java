import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2014/12/23.
 */
public class Problem60 {
    private static boolean concatenateIsPrime(BigInteger x, BigInteger y) {
        String st = String.valueOf(x) + String.valueOf(y);
        return isPrime(new BigInteger(st).intValue());
    }

    private static boolean isPrime(int x) {
        int high = (int) Math.sqrt(x);
        for (int i = 2; i < high + 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<BigInteger> generatePrimeList() {
        List<BigInteger> list = new LinkedList<>();
        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)) {
                list.add(new BigInteger(String.valueOf(i)));
            }
        }
        return list;
    }

    private static boolean inject1(BigInteger a, BigInteger b) {
        if (!concatenateIsPrime(a, b) || !concatenateIsPrime(b, a)) {
            return false;
        }
        return true;
    }

    private static boolean inject2(BigInteger a, BigInteger b, BigInteger c) {
        if (!concatenateIsPrime(a, c) || !concatenateIsPrime(c, a) ||
                !concatenateIsPrime(b, c) || !concatenateIsPrime(c, b)) {
            return false;
        }
        return true;
    }

    private static boolean inject3(BigInteger a, BigInteger b, BigInteger c, BigInteger d) {
        if (!concatenateIsPrime(a, d)
                || !concatenateIsPrime(b, d)
                || !concatenateIsPrime(c, d)
                || !concatenateIsPrime(d, a)
                || !concatenateIsPrime(d, b)
                || !concatenateIsPrime(d, c)) {
            return false;
        }
        return true;
    }

    private static boolean inject4(BigInteger a, BigInteger b, BigInteger c, BigInteger d, BigInteger e) {
        if (!concatenateIsPrime(a, e)
                || !concatenateIsPrime(b, e)
                || !concatenateIsPrime(c, e)
                || !concatenateIsPrime(d, e)
                || !concatenateIsPrime(e, a)
                || !concatenateIsPrime(e, b)
                || !concatenateIsPrime(e, c)
                || !concatenateIsPrime(e, d)) {
            return false;
        }
        return true;
    }

    private static Set<BigInteger> generate() {
        List<BigInteger> list = generatePrimeList();
        Set<BigInteger> set = new HashSet<>();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            BigInteger tmp1 = list.get(i);
            for (int j = i + 1; j < len; j++) {
                BigInteger tmp2 = list.get(j);
                if (!inject1(tmp1, tmp2)) {
                    continue;
                }
                for (int k = j + 1; k < len; k++) {
                    BigInteger tmp3 = list.get(k);
                    if (!inject2(tmp1, tmp2, tmp3)) {
                        continue;
                    }
                    for (int l = k + 1; l < len; l++) {
                        BigInteger tmp4 = list.get(l);
                        if (!inject3(tmp1, tmp2, tmp3, tmp4)) {
                            continue;
                        }
                        for (int m = l + 1; m < len; m++) {
                            BigInteger tmp5 = list.get(m);
                            if (!inject4(tmp1, tmp2, tmp3, tmp4, tmp5)) {
                                continue;
                            } else {
                                set.add(list.get(i));
                                set.add(list.get(j));
                                set.add(list.get(k));
                                set.add(list.get(l));
                                set.add(list.get(m));
                                return set;
                            }
                        }

                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Set<BigInteger> set = generate();
        BigInteger result = new BigInteger("0");
        for (BigInteger j : set) {
            result = result.add(j);
        }
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.printf("执行时间为: %dms.", end - start);
    }
}
