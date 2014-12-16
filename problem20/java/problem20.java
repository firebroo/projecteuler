import java.math.BigInteger;

/**
 * Created by Administrator on 2014/12/16.
 */
public class Problem20 {
    private static BigInteger fact(int x) {
        BigInteger result = new BigInteger("1");
        int count = 1;
        while (count <= x) {
           result = result.multiply(new BigInteger(String.valueOf(count)));
            count += 1;
        }
        return result;
    }
    public static  void main(String[] args) {
        String result = fact(100).toString();
        int sum = 0;
        for (int i = 0;i < result.length(); i++) {
           sum += new Integer(result.substring(i,i+1)).intValue();
        }
        System.out.println(sum);
    }
}
