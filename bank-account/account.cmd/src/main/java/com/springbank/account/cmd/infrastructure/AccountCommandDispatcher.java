package com.springbank.account.cmd.infrastructure;

import com.springbank.cqrs.core.commands.BaseCommand;
import com.springbank.cqrs.core.infrastructure.CommandDispatcher;
import com.springbank.cqrs.core.messages.Message;
import com.springbank.cqrs.core.handlers.MessageHandler;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class AccountCommandDispatcher implements CommandDispatcher {
    private final Map<Class<? extends Message>, List<MessageHandler>> routes = new HashMap<>();

    @Override
    public <T extends Message> void registerHandler(Class<T> type, MessageHandler<T> handler) {
        var handlers = routes.computeIfAbsent(type, c -> new LinkedList<>());
        handlers.add(handler);
    }

    @Override
    public void send(BaseCommand command) {
        var handlers = routes.get(command.getClass());
        if(handlers == null || handlers.size() <= 0) {
            throw new RuntimeException("No command handler was registered!");
        }
        if(handlers.size() > 1) {
            throw new RuntimeException("Cannot send command to more than one handler!");
        }
        handlers.get(0).handle(command);
    }
}
