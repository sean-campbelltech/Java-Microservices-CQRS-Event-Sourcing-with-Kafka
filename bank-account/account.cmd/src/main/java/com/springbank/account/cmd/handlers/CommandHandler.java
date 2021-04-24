package com.springbank.account.cmd.handlers;

import com.springbank.account.cmd.commands.CloseAccountCommand;
import com.springbank.account.cmd.commands.DepositFundsCommand;
import com.springbank.account.cmd.commands.OpenAccountCommand;
import com.springbank.account.cmd.commands.WithdrawFundsCommand;

public interface CommandHandler {
    void handle(OpenAccountCommand command);
    void handle(DepositFundsCommand command);
    void handle(WithdrawFundsCommand command);
    void handle(CloseAccountCommand command);
}
