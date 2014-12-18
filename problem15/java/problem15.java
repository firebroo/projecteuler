import java.math.BigInteger;

/**
 * Created by Administrator on 2014/12/18.
 */
public class Problem15 {
    /*
    组合数学，在m*n，规定只能向左或者右的话，就一定有m步向左，n步向右，所以答案是C(m+n,m)=C(m+n,n).
     */
    private  static BigInteger fact(BigInteger x) {
        if (x.equals(new BigInteger("0"))) {
            return new BigInteger("1");
        }else{
            return x.multiply(fact(x.subtract(new BigInteger("1"))));
        }
    }

    public static void main(String[] args) {
        BigInteger result = fact(new BigInteger("40")).divide((fact(new BigInteger("20")).pow(2)));
        System.out.println(result);
    }
}
