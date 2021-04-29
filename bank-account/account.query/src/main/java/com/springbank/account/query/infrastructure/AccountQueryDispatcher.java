package com.springbank.account.query.infrastructure;

import com.springbank.cqrs.core.domain.BaseEntity;
import com.springbank.cqrs.core.handlers.QueryHandlerMethod;
import com.springbank.cqrs.core.infrastructure.QueryDispatcher;
import com.springbank.cqrs.core.queries.BaseQuery;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class AccountQueryDispatcher implements QueryDispatcher {
    private final Map<Class<? extends BaseQuery>, List<QueryHandlerMethod>> routes = new HashMap<>();

    @Override
    public <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler) {
        var handlers = routes.computeIfAbsent(type, c -> new LinkedList<>());
        handlers.add(handler);
    }

    @Override
    public <T extends BaseEntity> List<T> send(BaseQuery query) {
        var handlers = routes.get(query.getClass());
        if(handlers == null || handlers.size() <= 0) {
            throw new RuntimeException("No command handler was registered!");
        }
        if(handlers.size() > 1) {
            throw new RuntimeException("Cannot send command to more than one handler!");
        }
        return handlers.get(0).handle(query);
    }
}
