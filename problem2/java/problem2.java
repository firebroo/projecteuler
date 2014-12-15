public class Problem2 {
    public static void main(String[] args) {
        int count = 0;
        int a = 1;
        int b = 2;
        while (a < 4000000) {
            if (a % 2 == 0) {
                count += a;
            }
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        System.out.println(count);
    }
}
