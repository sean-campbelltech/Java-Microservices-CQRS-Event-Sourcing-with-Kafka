package com.springbank.cqrs.core.handlers;

import com.springbank.cqrs.core.commands.BaseCommand;

@FunctionalInterface
public interface CommandHandlerMethod<T extends BaseCommand> {
    void handle(T command);
}
