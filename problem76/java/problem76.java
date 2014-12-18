/**
 * Created by Administrator on 2014/12/18.
 */
public class Coin {

    /*
    等同于给你100元面额，有1-99这样的99种面额零钱，求组合方式.
     */
    private static int count_change(int amount) {
        return cc(amount, 99);
    }

    private static int cc(int amount, int kinds_of_coins) {
        if (amount == 0) {
            return 1;
        } else if (amount < 0 || kinds_of_coins == 0) {
            return 0;
        } else {
            return cc(amount, kinds_of_coins - 1)
                    + cc(amount - first_denomination(kinds_of_coins),
                    kinds_of_coins);
        }
    }

    private static int first_denomination(int kinds_of_coins) {
        return kinds_of_coins;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int result = count_change(100);
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
