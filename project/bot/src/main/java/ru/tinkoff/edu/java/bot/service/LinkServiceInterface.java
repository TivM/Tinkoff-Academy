package ru.tinkoff.edu.java.bot.service;

import ru.tinkoff.edu.java.bot.dto.LinkResponse;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.Optional;

public interface LinkServiceInterface {
    List<LinkResponse> getAllLinks(Long tgChatId);
    Optional<LinkResponse> trackLink(Long tgChatId, String link);
    Optional<LinkResponse> untrackLink(Long tgChatId, String link);

}
