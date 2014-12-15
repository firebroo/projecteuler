import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/12/15.
 */
public class Problem4 {
    private static boolean isPalindrome(int x) {
        if (x == new Integer(new StringBuilder(new Integer(x).toString()).reverse().toString()).intValue()) {
            return true;
        }
        return false;
    }

    private static List<Integer> palindromeList() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 999 * 999; i > 0; i--) {
            if (isPalindrome(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private final static List<Integer> generateList() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 999; i++) {
            for (int j = 1; j < 999; j++) {
                list.add(i * j);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Integer> list = generateList();
        List<Integer> palindromeList = palindromeList();
        for (Integer i : palindromeList) {
            if (list.contains(i)) {
                System.out.println(i);
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("执行时间为: %dms",end - start);
    }
}
