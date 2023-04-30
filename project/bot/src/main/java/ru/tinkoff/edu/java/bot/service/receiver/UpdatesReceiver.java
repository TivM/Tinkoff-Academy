package ru.tinkoff.edu.java.bot.service.receiver;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.LinkUpdateRequest;
import ru.tinkoff.edu.java.bot.processor.message.MessageSender;

import java.util.Map;

@RequiredArgsConstructor
public abstract class UpdatesReceiver {

    private final TelegramBot telegramBot;
    private final MessageSender messageSender;

    public abstract void receiveUpdates(LinkUpdateRequest linkUpdateRequest);

    protected void alertUpdates(LinkUpdateRequest linkUpdateRequest) {
        Map<String, Object> model = Map.of("description", linkUpdateRequest.getDescription(),
                "url", linkUpdateRequest.getUrl());

        for (long chatId : linkUpdateRequest.getTgChatIds()) {
            SendMessage message = messageSender.sendTemplateId(chatId, "update.ftl", model);
            telegramBot.execute(message);
        }
    }
}
