package com.github.javarushcommunity.jrtb.command;


import com.github.javarushcommunity.jrtb.repository.entity.TelegramUser;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;

/**
 * Start {@link Command}.
 */


public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Привет! Я [TEST] Java Telegram bot. Я помогу тебе быть в курсе " +
            "последнних" + " статей тех авторов, которые тебе интересны.";
    


    /*
        Здесь не следует добавлять сервис через получение из Application Context.
        Потому что если это сделать, то будет циклическая зависимость, которая ломает
        работу приложения/бота
     */


    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;

    }


    @Override
    public void execute(Update update) {

        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                });

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);

    }
}
