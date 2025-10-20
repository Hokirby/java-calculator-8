package calculator;

import java.util.List;

public interface Calculator <T extends Number> {
    T add(List<T> numbers);
}
