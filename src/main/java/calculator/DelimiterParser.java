package calculator;

public class DelimiterParser {
    // custom 구분자 구하기
    public String concatDelimiter(String input) {
        // 구분자 마지막 인덱스
        int end = input.indexOf("\\n") - 1;
        // 구분자의 글자 수가 1 일때
        if (end == 3) {
            char delimiter = input.charAt(2);
            return Character.toString(delimiter);
        }
        return input.substring(2, end + 1);
    }

    // custom 구분자 제외 문자열 구하기
    public String concatInput(String input, String delimiter) {
        String replace = "//" + delimiter + "\\n";
        return input.replace(replace, "");
    }
}
