package ru.tinkoff.edu.java.bot.botprocessor.messagesender;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;


import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MessageSender implements MessageSenderInterface{
    private final Configuration templateResolver;
    @Override
    public SendMessage sendMessage(Update update, String text) {
        return new SendMessage(update.message().chat().id(), text);
    }

    @Override
    @SneakyThrows
    public SendMessage sendTemplate(Update update, String templateName, Map<String, Object> root){
        Template template = templateResolver.getTemplate(templateName);
        Writer result = new StringWriter();
        template.process(root, result);
        return new SendMessage(update.message().chat().id(), result.toString())
                .parseMode(ParseMode.HTML);
    }
}
