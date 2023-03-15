package ru.tinkoff.edu.java.parser;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StackOverflowParser extends GenericParser{
    private static final String HOST = "stackoverflow.com";

    @Override
    protected TypesOfParsers parseUrl(String[] splitUrl) {
        if (!Objects.equals(splitUrl[1], HOST)){
            return null;
        }

        else if (splitUrl.length <= 4){
            return null;
        }

        //Types of link:
        //https://stackoverflow.com/questions/ID/QUESTION
        else
            return new TypesOfParsers.StackOverflowQuestionId(splitUrl[3]);
    }
}
