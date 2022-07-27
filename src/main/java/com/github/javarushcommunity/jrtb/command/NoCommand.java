package com.github.javarushcommunity.jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;

/**
 * No {@link Command}.
 */

public class NoCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public final static String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/)\n"
            + "Что посомтреть список команд введите /help";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);

    }
}
