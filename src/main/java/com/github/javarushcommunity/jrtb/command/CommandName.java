package com.github.javarushcommunity.jrtb.command;

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    NO("nocommand"),
    STAT("/stat"),
    HELP("/help");



    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }
}

