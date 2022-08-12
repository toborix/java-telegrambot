package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import static com.github.javarushcommunity.jrtb.command.CommandName.*;

/**
 * Help {@link Command}.
 */

public class HelpCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    public final static String HELP_MESSAGE = String.format("""
                    📍<b>Доступные команды: </b>📍
                    
                    %s - <i>начать работу со мной</i>
                    
                    %s - <i>пристановить работу со мной</i>
                    
                    %s - <i>получить статистику по использованию бота</i>

                    %s - <i>получить помощь в работе со мной</i>
                    """,
            START.getCommandName(), STOP.getCommandName(),STAT.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);


    }
}
