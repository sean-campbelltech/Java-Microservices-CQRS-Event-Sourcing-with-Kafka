package com.springbank.cqrs.core.producers;

import com.springbank.cqrs.core.events.BaseEvent;

public interface EventProducer {
    void produce(String topic, BaseEvent event);
}