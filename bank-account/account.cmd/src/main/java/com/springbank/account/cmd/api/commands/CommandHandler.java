package com.springbank.account.cmd.api.commands;

import com.springbank.account.cmd.api.commands.CloseAccountCommand;
import com.springbank.account.cmd.api.commands.DepositFundsCommand;
import com.springbank.account.cmd.api.commands.OpenAccountCommand;
import com.springbank.account.cmd.api.commands.WithdrawFundsCommand;

// The 'AbstractColleague'
public interface CommandHandler {
    void handle(OpenAccountCommand command);
    void handle(DepositFundsCommand command);
    void handle(WithdrawFundsCommand command);
    void handle(CloseAccountCommand command);
    void handle(RestoreReadDbCommand command);
}
