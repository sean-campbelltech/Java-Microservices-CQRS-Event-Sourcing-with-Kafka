package com.springbank.cqrs.core.handlers;

import com.springbank.cqrs.core.messages.Message;

@FunctionalInterface
public interface MessageHandler<T extends Message> {
    void handle(T message);
}
