package ru.tinkoff.edu.java.bot.botprocessor.commands;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.botprocessor.CommandInterface;
import ru.tinkoff.edu.java.bot.botprocessor.messagesender.MessageSender;

@Component
@RequiredArgsConstructor
public class StartCommand implements CommandInterface {
    private final MessageSender messageSender;

    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String description() {
        return "get a welcome message";
    }

    @Override
    public SendMessage process(Update update) {
        return messageSender.sendMessage(update, "Welcome!");
    }

    @Override
    public boolean supports(Update update) {
        return CommandInterface.super.supports(update);
    }

    @Override
    public BotCommand toApiCommand() {
        return CommandInterface.super.toApiCommand();
    }
}
