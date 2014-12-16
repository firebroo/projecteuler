/**
 * Created by Administrator on 2014/12/16.
 */
class EnglishNumberFormatter {
    private final String[] BITS = {"ONE", "TWO", "THREE", "FOUR", "FIVE",
            "SIX", "SEVEN", "EIGHT", "NINE", "TEN"};
    private final String[] TEENS = {"ELEVEN", "TWELVE", "THIRTEEN",
            "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
    private final String[] TIES = {"TWENTY", "THIRTY", "FORTY", "FIFTY",
            "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};


    public String toEnglish(int num) {
        StringBuffer buffer = new StringBuffer();
        if (num == 1000) {
            buffer.append("ONE THOUSAND");
            return buffer.toString();
        }
        if (num >= 100) {
            buffer.append(pickHunder(num));
            if (num % 100 != 0) {
                buffer.append(" AND ");
            }
            num -= (num / 100) * 100;
        }
        boolean largerThan20 = false;
        if (num >= 20) {
            largerThan20 = true;
            buffer.append(pickTies(num));
            num -= (num / 10) * 10;
        }
        if (!largerThan20 && num > 10) {
            buffer.append(pickTeens(num));
            num = 0;
        }
        if (num > 0) {
            String bit = pickBits(num);
            if (largerThan20) {
                buffer.append(" ");
            }
            buffer.append(bit);
        }
        return buffer.toString();
    }

    private String pickHunder(int num) {
        int hundred = num / 100;
        return BITS[hundred - 1] + " HUNDRED";
    }

    private String pickTies(int num) {
        int ties = num / 10;
        return TIES[ties - 2];
    }

    private String pickTeens(int num) {
        return TEENS[num - 11];
    }

    private String pickBits(int num) {
        return BITS[num - 1];
    }
}

public class Problem17 {
    public static void main(String[] args) {
        EnglishNumberFormatter englishNumberFormatter = new EnglishNumberFormatter();
        String result = "";
        for (int i = 1; i <= 1000; i++) {
            result += englishNumberFormatter.toEnglish(i).replace(" ", "");
        }
        System.out.println(result.length());
    }
}
