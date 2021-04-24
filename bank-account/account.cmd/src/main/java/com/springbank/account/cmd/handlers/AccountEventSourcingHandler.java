package com.springbank.account.cmd.handlers;

import com.springbank.account.cmd.domain.AccountAggregate;
import com.springbank.cqrs.core.domain.AggregateRoot;
import com.springbank.cqrs.core.handlers.EventSourcingHandler;
import com.springbank.cqrs.core.infrastructure.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountEventSourcingHandler implements EventSourcingHandler<AccountAggregate> {

    @Autowired
    private EventStore eventStore;

    @Override
    public void save(AggregateRoot aggregate, int expectedVersion) {
        eventStore.saveEvents(aggregate.getId(), aggregate.getUncommittedChanges(), expectedVersion);
        aggregate.markChangesAsCommitted();
    }

    @Override
    public AccountAggregate getById(UUID id) {
        var aggregate = new AccountAggregate();
        var events = eventStore.getEvents(id);
        aggregate.replayEvents(events);

        return aggregate;
    }
}
