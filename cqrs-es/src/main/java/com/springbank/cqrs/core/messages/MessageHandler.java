package com.springbank.cqrs.core.messages;

@FunctionalInterface
public interface MessageHandler<T extends Message> {
    void handle(T message);
}
