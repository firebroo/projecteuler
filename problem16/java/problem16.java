import java.math.BigInteger;

/**
 * Created by Administrator on 2014/12/16.
 */
public class Problem16 {
    public static  void main(String[] args) {
        BigInteger integer = new BigInteger("2").shiftLeft(999);
        String string = integer.toString();
        int result = 0;
        for (int i=0;i<string.length();i++) {
            result += new Integer(string.substring(i,i+1)).intValue();
        }
        System.out.println(result);
    }
}
