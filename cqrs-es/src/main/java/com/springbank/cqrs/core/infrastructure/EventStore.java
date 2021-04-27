package com.springbank.cqrs.core.infrastructure;

import com.springbank.cqrs.core.domain.AggregateRoot;
import com.springbank.cqrs.core.events.BaseEvent;
import com.springbank.cqrs.core.messages.Message;

import java.util.List;
import java.util.UUID;

public interface EventStore {
    <T extends AggregateRoot> void saveEvents(String aggregateId, Iterable<BaseEvent> events, int expectedVersion);
    List<BaseEvent> getEvents(String aggregateId);
}
