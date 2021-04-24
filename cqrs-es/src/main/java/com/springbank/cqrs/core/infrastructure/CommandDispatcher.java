package com.springbank.cqrs.core.infrastructure;

import com.springbank.cqrs.core.commands.BaseCommand;
import com.springbank.cqrs.core.messages.Message;
import com.springbank.cqrs.core.handlers.MessageHandler;

public interface CommandDispatcher {
    <T extends Message> void registerHandler(Class<T> type, MessageHandler<T> handler);
    void send(BaseCommand command);
}
