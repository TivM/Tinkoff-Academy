package ru.tinkoff.edu.java.parser;

import org.springframework.lang.Nullable;

public interface ParserInterface {
    @Nullable
    ParseResult parse(String url);
}
