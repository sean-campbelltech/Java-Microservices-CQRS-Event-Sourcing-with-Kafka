package com.springbank.cqrs.core.handlers;

import com.springbank.cqrs.core.domain.AggregateRoot;

import java.util.UUID;

public interface EventSourcingHandler<T> {
    void save(AggregateRoot aggregate);
    T getById(String id);
    void republishEvents();
}
