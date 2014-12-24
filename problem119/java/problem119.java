import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2014/12/24.
 */
public class Problem119 {

    private static int digitsSum(BigInteger x) {
        int sum = 0;
        String string = String.valueOf(x);
        for (int i = 0; i < string.length(); i++) {
            String subString = string.substring(i, i + 1);
            sum += Integer.parseInt(subString);
        }
        return sum;
    }

    public static void main(String[] args) {
        Set<BigInteger> set = new HashSet<>();
        for (int i=2;i<200;i++) {
            for (int j=2;j<200;j++) {
                BigInteger tmp = new BigInteger(String.valueOf(i)).pow(j);
                if (i == digitsSum(tmp)) {
                    set.add(tmp);
                }
            }
        }
        List<BigInteger> list = set.stream().sorted().collect(Collectors.toList());
        System.out.println(list.get(29));
    }
}
