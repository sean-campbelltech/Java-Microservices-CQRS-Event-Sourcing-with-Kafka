package com.springbank.cqrs.core.handlers;

import com.springbank.cqrs.core.domain.BaseEntity;
import com.springbank.cqrs.core.queries.BaseQuery;

import java.util.List;

@FunctionalInterface
public interface QueryHandlerMethod<T extends BaseQuery> {
    List<BaseEntity> handle(T query);
}
