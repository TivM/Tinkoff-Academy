package ru.tinkoff.edu.java.parser;

import org.springframework.lang.Nullable;
import ru.tinkoff.edu.java.parser.results.ParseResult;

public interface ParserInterface {
    @Nullable ParseResult parse(String url);
}
