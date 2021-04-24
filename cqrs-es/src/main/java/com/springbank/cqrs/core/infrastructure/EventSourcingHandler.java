package com.springbank.cqrs.core.infrastructure;

import com.springbank.cqrs.core.domain.AggregateRoot;

import java.util.UUID;

public interface EventSourcingHandler<T> {
    void save(AggregateRoot aggregate, int expectedVersion);
    T getById(UUID id);
}
