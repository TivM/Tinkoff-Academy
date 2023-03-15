package ru.tinkoff.edu.java.parser;


import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.net.URL;

public abstract class GenericParser implements ParserInterface{

    @Override
    public @Nullable
    TypesOfParsers parse(String url) {
        if(!isValid(url)){
            return null;
        }

        else{
            String urlForSplit = url.replaceAll("//", "/");
            return parseUrl(urlForSplit.split("/"));
        }


    }
    protected abstract @Nullable TypesOfParsers parseUrl(String[] splitUrl);

    private boolean isValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        }

        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
    }
}
