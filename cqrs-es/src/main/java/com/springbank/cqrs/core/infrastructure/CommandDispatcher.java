package com.springbank.cqrs.core.infrastructure;

import com.springbank.cqrs.core.commands.BaseCommand;
import com.springbank.cqrs.core.handlers.CommandHandlerMethod;

public interface CommandDispatcher {
    <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);
    void send(BaseCommand command);
}
