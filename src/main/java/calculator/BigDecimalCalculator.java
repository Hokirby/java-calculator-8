package calculator;

import java.math.BigDecimal;
import java.util.List;

public class BigDecimalCalculator implements Calculator<BigDecimal> {
    @Override
    public BigDecimal add(List<BigDecimal> numbers) {
        return numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
