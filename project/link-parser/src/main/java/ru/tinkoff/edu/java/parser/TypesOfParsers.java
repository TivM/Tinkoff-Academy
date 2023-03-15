package ru.tinkoff.edu.java.parser;

public sealed interface TypesOfParsers {
    record GitHubUserRepository(String userName, String repository) implements TypesOfParsers {}
    record StackOverflowQuestionId(String questionId) implements TypesOfParsers {}
}
