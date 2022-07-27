package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}.
 */

public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String STOP_MESSAGE = "Деактивировал все подписки!";

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),STOP_MESSAGE);

    }
}
