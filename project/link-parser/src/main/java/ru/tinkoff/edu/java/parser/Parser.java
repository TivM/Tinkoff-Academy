package ru.tinkoff.edu.java.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.parser.parseresult.ParseResult;

import java.util.List;
import java.util.Objects;


@Service
public class Parser {

    @Autowired
    private List<ParserInterface> parsers;

    public ParseResult parse(String url){
        return parsers
                .stream()
                .map(parser -> parser.parse(url))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }
}
