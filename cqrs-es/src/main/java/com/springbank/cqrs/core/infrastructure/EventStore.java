package com.springbank.cqrs.core.infrastructure;

import com.springbank.cqrs.core.events.BaseEvent;

import java.util.List;

public interface EventStore {
    void saveEvents(String aggregateId, Iterable<BaseEvent> events, int expectedVersion);
    List<BaseEvent> getEvents(String aggregateId);
}
