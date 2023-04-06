package ru.tinkoff.edu.java.bot.processor.message;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.Map;

public interface MessageSenderInterface {

    SendMessage sendMessage(Update update, String text);
    SendMessage sendTemplate(Update update, String templateName, Map<String, Object> root);

}

