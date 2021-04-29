package com.springbank.cqrs.core.infrastructure;

import com.springbank.cqrs.core.domain.BaseEntity;
import com.springbank.cqrs.core.handlers.QueryHandlerMethod;
import com.springbank.cqrs.core.queries.BaseQuery;

import java.util.List;

public interface QueryDispatcher {
    <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
    <U extends BaseEntity> List<U> send(BaseQuery query);
}
