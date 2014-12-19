/**
 * Created by Administrator on 2014/12/19.
 */
public class problem40 {
    private static int stringToInteger(String string) {
        return new Integer(string).intValue();
    }

    public static void main(String[] args) {
        /*StringBuffer明显比字符串来拼接省了非常多的内存开销和计算量*/
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < 1000000; i++) {
            sb.append(String.valueOf(i));
            if (sb.length() > 1000000) {
                break;
            }
        }
        String string = sb.toString();
        int result = stringToInteger(string.substring(0, 1)) * stringToInteger(string.substring(9, 10)) * stringToInteger(string.substring(99, 100))
                * stringToInteger(string.substring(999, 1000)) * stringToInteger(string.substring(9999, 10000)) * stringToInteger(string.substring(99999, 100000))
                * stringToInteger(string.substring(999999, 1000000));
        System.out.println(result);
    }
}
