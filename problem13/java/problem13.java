import java.io.*;
import java.math.BigInteger;

/**
 * Created by Administrator on 2014/12/15.
 */
public class Problem13 {
    public static void main(String[] args) throws IOException {
        File file = new File("E:/1.txt");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String lineText = null;
        BigInteger result = new BigInteger("0");
        while((lineText = reader.readLine()) != null) {
            result = result.add(new BigInteger(lineText.replace("\n","")));
        }
        reader.close();
        System.out.println(result.toString().substring(0,10));
    }
}
