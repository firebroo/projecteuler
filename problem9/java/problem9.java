/**
 * Created by Administrator on 2014/12/15.
 */
public class Problem9 {
    public static int pythagoreanTriplet() {
        for (int i = 1; i < 2000; i++) {
            for (int j = 1; j < 2000; j++) {
                if ((i + j + Math.hypot(i, j)) == 1000) {      /*此处只能让他自动往精度更细小的方向转换，否则可能不正确*/
                    return i * j * (int)Math.hypot(i, j);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int result = pythagoreanTriplet();
        System.out.println(result);
    }
}
