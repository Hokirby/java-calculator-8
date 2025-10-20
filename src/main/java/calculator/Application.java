package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static calculator.CalculatorFactory.BIG_DECIMAL;
import static calculator.CalculatorFactory.INTEGER;

public class Application {
    public static final String DEFAULT = "default";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        // "" 값이 입력된 경우
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        if (PatternMatcher.hasCustomDelimiter(input)) {
            handleCustomDelimiter(input);
        } else {
            handleDefaultDelimiter(input);
        }
    }

    // custom
    static void handleCustomDelimiter(String input) {
        DelimiterParser delimiterParser = new DelimiterParser();
        String delimiter = delimiterParser.concatDelimiter(input);
        // substring 문자열 자르기
        String concat = delimiterParser.concatInput(input, delimiter);
        // 구분자 값이 "."
        if (delimiter.equals(".")) {
            calculateAndPrint(concat, delimiter, INTEGER);
            return;
        }
        // 나머지 구분자 처리
        if (PatternMatcher.hasDecimalPoint(concat)) {
            calculateAndPrint(concat, delimiter, BIG_DECIMAL);
        } else {
            calculateAndPrint(concat, delimiter, INTEGER);
        }
    }

    // default
    private static void handleDefaultDelimiter(String input) {
        // 실수 계산
        if (PatternMatcher.hasDecimalPoint(input)) {
            calculateAndPrint(input, DEFAULT, BIG_DECIMAL);
        }
        // 정수 계산
        else {
            calculateAndPrint(input, DEFAULT, INTEGER);
        }
    }

    // 계산 출력
    private static void calculateAndPrint(String input, String delimiter, String type) {
        PatternMatcher.checkInvalidCharacter(input);

        Calculator calculator = CalculatorFactory.calculate(type);
        NumberScanner scanner = new NumberScanner(new Scanner(input));
        // 기본 구분자
        if (DEFAULT.equals(delimiter)) {
            scanner.setDelimiter();
        }
        // custom 구분자
        else {
            scanner.setDelimiter(delimiter);
        }
        // 실수
        if (BIG_DECIMAL.equals(type)) {
            List<BigDecimal> list = scanner.parseList(BigDecimal::new);
            BigDecimal result = ((BigDecimalCalculator) calculator).add(list);
            System.out.println("결과 : " + result);
        }
        // 정수
        else {
            List<Integer> list = scanner.parseList(Integer::parseInt);
            Integer result = ((IntegerCalculator) calculator).add(list);
            System.out.println("결과 : " + result);
        }
    }
}
