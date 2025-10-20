package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    private PatternMatcher() {
    }

    public static boolean hasCustomDelimiter(String input) {
        return (input.contains("//") && input.contains("\\n"));
    }

    public static boolean hasDecimalPoint(String input) {
        String regex = "[0-9]*\\.[0-9]*";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        return matcher.find();
    }

    // ",", ":", 숫자 외에 다른 문자열이 있는가
    public static void checkInvalidCharacter(String input) {
        String regex = "[^,:0-9]";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException("Invalid Delimiter");
        }
    }
}
