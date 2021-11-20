package com.springbank.cqrs.core.commands;

import com.springbank.cqrs.core.commands.BaseCommand;

@FunctionalInterface
public interface CommandHandlerMethod<T extends BaseCommand> {
    void handle(T command);
}
