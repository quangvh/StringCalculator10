import java.util.regex.Pattern;

/**
 * User: quangvh
 * Date: 6/7/13
 */
public class Calculator {
    public static int add(String numbers) throws Exception {
        String strNegative = "";
        String strDelimiter = "";
        String strNumber = "";
        String[] listNumber = null;
        Integer sum = 0;
        if (numbers.isEmpty()) {
            return 0;
        } else {
            if (numbers.startsWith("//[")) {
                String[] beforeDelimiter = numbers.split("\\[");
                String delimiter = beforeDelimiter[1].split("]")[0];
                strDelimiter = "\n" + "|" + Pattern.quote(delimiter);
                strNumber = numbers.split("\n")[1];
            } else if (numbers.startsWith("//")) {
                strDelimiter = numbers.substring(2,3) + "|\n";
                strNumber = numbers.split("\n")[1];
            } else if (numbers.contains(",")){
                strDelimiter = ",|\n";
                strNumber = numbers;
            } else {
                return Integer.parseInt(numbers);
            }
            listNumber = strNumber.split(strDelimiter);
            for (String number : listNumber) {
                if (!number.equals("") && Integer.parseInt(number) <= 1000) {
                    if (Integer.parseInt(number) < 0)
                        strNegative += " " + number;
                    sum += Integer.parseInt(number);
                }
            }
            if (!strNegative.equals(""))
                throw new Exception("negatives not allowed" + strNegative);
            return sum;
        }
    }
}

