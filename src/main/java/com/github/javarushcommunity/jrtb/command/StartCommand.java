package com.github.javarushcommunity.jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;

/**
 * Start {@link Command}.
 */


public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Привет! Я [TEST] Java Telegram bot. Я помогу тебе быть в курсе " +
            "полсденних" + " статей тех авторов, которые тебе интересны.";

    /*
        Здесь не следует добавлять сервис через получение из Application Context.
        Потому что если это сделать, то будет циклическая зависимость, которая ломает
        работу приложения/бота
     */

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),START_MESSAGE);

    }
}
