package com.springbank.account.query.Infrastructure.handlers;

import com.springbank.account.common.events.AccountClosedEvent;
import com.springbank.account.common.events.AccountOpenedEvent;
import com.springbank.account.common.events.FundsDepositedEvent;
import com.springbank.account.common.events.FundsWithdrawnEvent;

public interface EventHandler {
    void on(AccountOpenedEvent event);
    void on(FundsDepositedEvent event);
    void on(FundsWithdrawnEvent event);
    void on(AccountClosedEvent event);
}