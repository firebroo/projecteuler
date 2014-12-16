import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2014/12/16.
 */
public class Problem22 {
    private static String[] handleFile() throws IOException {
        File file = new File("E:/1.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuffer result = new StringBuffer();
        String lineText;
        while (!((lineText = bufferedReader.readLine()) == null)) {
            result.append(lineText);
        }
        return result.toString().replace("\n", "").replace("\"", "").split(",");
    }

    private static Map<Character, Integer> generateDict() {
        Map<Character, Integer> map = new HashMap<>();
        char englishNumber = 'A';
        for (int i = 1; i <= 26; i++) {
            map.put(englishNumber++, i);
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
        Map<Character, Integer> dict = generateDict();
        String[] strings = handleFile();
        List<String> list = Arrays.asList(strings);
        List<Integer> rankList = list.stream().sorted().map((x) -> {
            int sum = 0;
            for (int i = 0; i < x.length(); i++) {
                sum += dict.get(x.substring(i, i + 1).charAt(0));
            }
            return sum;
        }).collect(Collectors.toList());
        Integer sum = 0;
        for (int i = 0; i < strings.length; i++) {
            sum += (i + 1) * rankList.get(i);
        }
        System.out.println(sum);
    }
}
