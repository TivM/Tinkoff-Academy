package ru.tinkoff.edu.java.scrapper.service.notifier;

import ru.tinkoff.edu.java.scrapper.entity.Link;
import ru.tinkoff.edu.java.scrapper.entity.TgChat;

import java.util.Collection;

public interface BotNotifier {

    void notifyBot(Link link, String description, Collection<TgChat> tgChats);
}
