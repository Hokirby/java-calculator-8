package calculator;

import java.util.List;

public class IntegerCalculator implements Calculator<Integer> {
    @Override
    public Integer add(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
