package com.springbank.account.cmd.handlers;

import com.springbank.account.cmd.commands.CloseAccountCommand;
import com.springbank.account.cmd.commands.OpenAccountCommand;
import com.springbank.account.cmd.domain.AccountAggregate;
import com.springbank.account.cmd.commands.DepositFundsCommand;
import com.springbank.account.cmd.commands.WithdrawFundsCommand;
import com.springbank.cqrs.core.handlers.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCommandHandler implements CommandHandler {

    @Autowired
    private EventSourcingHandler<AccountAggregate> eventSourcingHandler;

    @Override
    public void handle(OpenAccountCommand command) {
        var aggregate = new AccountAggregate(command);
        eventSourcingHandler.save(aggregate, -1);
    }

    @Override
    public void handle(DepositFundsCommand command) {
        var aggregate = eventSourcingHandler.getById(command.getId());
        aggregate.depositFunds(command.getAmount());

        eventSourcingHandler.save(aggregate, command.getExpectedVersion());
    }

    @Override
    public void handle(WithdrawFundsCommand command) {
        var aggregate = eventSourcingHandler.getById(command.getId());
        aggregate.withdrawFunds(command.getAmount());

        eventSourcingHandler.save(aggregate, command.getExpectedVersion());
    }

    @Override
    public void handle(CloseAccountCommand command) {
        var aggregate = eventSourcingHandler.getById(command.getId());
        aggregate.closeAccount();

        eventSourcingHandler.save(aggregate, command.getExpectedVersion());
    }
}
