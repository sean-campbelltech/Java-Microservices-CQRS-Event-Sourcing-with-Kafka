package com.springbank.account.query.consumers;

import com.springbank.account.common.events.AccountClosedEvent;
import com.springbank.account.common.events.AccountOpenedEvent;
import com.springbank.account.common.events.FundsDepositedEvent;
import com.springbank.account.common.events.FundsWithdrawnEvent;

public interface EventConsumer {
    void consume(AccountOpenedEvent message);
    void consume(FundsDepositedEvent message);
    void consume(FundsWithdrawnEvent message);
    void consume(AccountClosedEvent message);
}
