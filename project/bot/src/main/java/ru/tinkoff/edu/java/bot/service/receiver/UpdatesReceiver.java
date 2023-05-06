package ru.tinkoff.edu.java.bot.service.receiver;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.LinkUpdateRequest;
import ru.tinkoff.edu.java.bot.processor.message.MessageSender;

import java.util.Map;

@RequiredArgsConstructor
public class UpdatesReceiver {

    private final TelegramBot telegramBot;
    private final MessageSender messageSender;

    private static final String updateTemplate = "update.ftl";

    public void alertUpdates(LinkUpdateRequest linkUpdateRequest) {
        Map<String, Object> model = Map.of("description", linkUpdateRequest.getDescription(),
                "url", linkUpdateRequest.getUrl());

        for (long chatId : linkUpdateRequest.getTgChatIds()) {
            SendMessage message = messageSender.sendTemplateId(chatId, updateTemplate, model);
            telegramBot.execute(message);
        }
    }
}
