package calculator;

public class CalculatorFactory   {
    public final static String INTEGER = "Integer";
    public final static String BIG_DECIMAL = "BigDecimal";

    public static <T extends Number> Calculator calculate(String type) {
        return switch (type) {
            case INTEGER -> new IntegerCalculator();
            case BIG_DECIMAL -> new BigDecimalCalculator();
            default -> throw new IllegalArgumentException("Invalid Type");
        };
    }
}
