import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/22.
 */
public class Problem74 {

    /*
    计算digits的阶乘和
     */
    private static Integer digitsFact(int x) {
        Integer sum = 0;
        String string = new Integer(x).toString();
        for (int i = 0; i < string.length(); i++) {
            String tmp = string.substring(i, i + 1);
            sum += fact(new Integer(tmp).intValue());
        }
        return sum;
    }

    /*
    dynamic programming 999999的digits阶乘是2177281,维护一个2177281大小的hash表
     */
    private static Map<Integer, Integer> getHashMap() {
        int largest = digitsFact(999999);
        Map<Integer, Integer> map = new HashMap<>(largest);
        for (Integer i = 0; i <= largest; i++) {
            Integer tmp = digitsFact(i);
            map.put(i, tmp);
        }
        return map;
    }

    /*
    阶乘
     */
    private static int fact(int x) {
        if (x == 0) {
            return 1;
        } else {
            return x * fact(x - 1);
        }
    }

    /*
    统计单条链的长度,使用LinkedHashMap为了使得Map有顺序，方便输出观察
     */
    private static int countNumber(int x, Map<Integer,Integer> dict) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(x, 1);
        int count = 1;
        while (true) {
            Integer tmp = dict.get(x);
            if (map.get(tmp) != null) {
                break;
            } else {
                map.put(tmp, 1);
            }
            count++;
            x = tmp;
        }
        return count;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> dict = getHashMap();
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            if (countNumber(i,dict) == 60) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
