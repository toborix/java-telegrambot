package com.github.javarushcommunity.jrtb.service;

public interface SendBotMessageService {
    /*
    Service for sending messages via telegram-bot

        here will be:
        @param chaiId - chatId in which messages would be sent
        @param message - provide message to be sent
     */

    void sendMessage(String chatId, String message);
}


