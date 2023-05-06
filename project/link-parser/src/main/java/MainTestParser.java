import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.tinkoff.edu.java.parser.Parser;

public class MainTestParser {
    private static final Logger LOGGER = Logger.getLogger(MainTestParser.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
            new AnnotationConfigApplicationContext("ru.tinkoff.edu.java.parser");
        Parser parser = (Parser) ctx.getBean("parser");
        LOGGER.info("Result: %s".formatted(parser.parse("1231313")));
        LOGGER.info("Result: %s".formatted(parser.parse("https://github.com/sanyarnd/tinkoff-java-course-2022/")));
        LOGGER.info("Result: %s".formatted(parser.parse(
            "https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c")));
        LOGGER.info("Result: %s".formatted(parser.parse("https://stackoverflow.com/search?q=unsupported%20link")));
        LOGGER.info("Result: %s".formatted(parser.parse("https://github.com/TivM/Lab8/tree/main/Lab8/lib")));

    }
}
