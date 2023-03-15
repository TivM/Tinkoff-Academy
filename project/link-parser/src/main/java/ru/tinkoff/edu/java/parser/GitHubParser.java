package ru.tinkoff.edu.java.parser;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class GitHubParser extends GenericParser{
    private static final String HOST = "github.com";
    @Override
    protected TypesOfParsers parseUrl(String[] splitUrl) {
        if (!Objects.equals(splitUrl[1], HOST)){
            return null;
        }

        else if(splitUrl.length < 4){
            return null;
        }

        //Types of link:
        //https://github.com/USERNAME/REPOSITORY/
        else
            return new TypesOfParsers.GitHubUserRepository(splitUrl[2], splitUrl[3]);
    }
}
