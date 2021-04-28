package com.springbank.account.cmd.api.commands;

import com.springbank.account.common.dto.AccountType;
import com.springbank.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class OpenAccountCommand extends BaseCommand {
    private String accountHolder;
    private AccountType accountType;
    private double openingBalance;
}
