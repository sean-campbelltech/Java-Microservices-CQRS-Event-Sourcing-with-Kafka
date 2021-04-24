package com.springbank.account.cmd.commands;

import com.springbank.account.common.models.AccountType;
import com.springbank.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class OpenAccountCommand extends BaseCommand {
    private String accountHolder;
    private AccountType accountType;
    private double openingBalance;
}
