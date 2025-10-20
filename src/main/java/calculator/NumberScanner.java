package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class NumberScanner {
    private final Scanner scanner;

    NumberScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setDelimiter(String delimiter) {
        // delimiter 변경(, 또는 : 또는 custom)
        if (delimiter.equals(".")) {
            this.scanner.useDelimiter("[,.:]");
            return;
        }
        this.scanner.useDelimiter(",|:|" + delimiter);
    }

    public void setDelimiter() {
        // delimiter 변경(, 또는 :)
        this.scanner.useDelimiter("[,:]");
    }

    public <T extends Number> List<T> parseList(Function<String, T> mapper) {
        ArrayList<T> list = new ArrayList<>();
        try {
            while (this.scanner.hasNext()) {
                String num = this.scanner.next();
                list.add(mapper.apply(num));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid Input");
        }
        return list;
    }
}
