package com.springbank.account.query.infrastructure.consumers;

import com.springbank.account.common.events.AccountClosedEvent;
import com.springbank.account.common.events.AccountOpenedEvent;
import com.springbank.account.common.events.FundsDepositedEvent;
import com.springbank.account.common.events.FundsWithdrawnEvent;
import com.springbank.account.query.infrastructure.handlers.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AccountConsumer implements EventConsumer {
    private final EventHandler eventHandler;

    @Autowired
    public AccountConsumer(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @KafkaListener(topics = "AccountOpenedEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(AccountOpenedEvent message) {
        eventHandler.on(message);
    }

    @KafkaListener(topics = "FundsDepositedEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(FundsDepositedEvent message) {
        eventHandler.on(message);
    }

    @KafkaListener(topics = "FundsWithdrawnEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(FundsWithdrawnEvent message) {
        eventHandler.on(message);
    }

    @KafkaListener(topics = "AccountClosedEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(AccountClosedEvent message) {
        eventHandler.on(message);
    }
}
