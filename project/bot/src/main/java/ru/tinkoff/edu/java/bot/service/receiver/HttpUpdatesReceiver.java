package ru.tinkoff.edu.java.bot.service.receiver;

import com.pengrad.telegrambot.TelegramBot;
import org.openapitools.model.LinkUpdateRequest;
import ru.tinkoff.edu.java.bot.processor.message.MessageSender;

public class HttpUpdatesReceiver extends UpdatesReceiver{

    public HttpUpdatesReceiver(TelegramBot telegramBot, MessageSender messageSender) {
        super(telegramBot, messageSender);
    }

    @Override
    public void receiveUpdates(LinkUpdateRequest linkUpdateRequest) {
        this.alertUpdates(linkUpdateRequest);
    }
}
