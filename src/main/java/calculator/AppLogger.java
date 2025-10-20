package calculator;

import java.util.logging.*;

// 테스트에 적합하지 않아 사용하지 않음
public class AppLogger {
    public static final Logger log = Logger.getLogger(AppLogger.class.getName());

    public static void formatLogger() {
        Logger rootHandler = Logger.getLogger("");
        for(Handler handler: rootHandler.getHandlers()) {
            rootHandler.removeHandler(handler);
        }
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage() + "\n";
            }
        });
        log.addHandler(consoleHandler);
        log.setLevel(Level.ALL);
    }
}
