package ru.tinkoff.edu.java.parser;

import org.springframework.lang.Nullable;

import java.util.Optional;

public interface ParserInterface {
    @Nullable
    TypesOfParsers parse(String url);
}
