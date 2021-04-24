package com.springbank.account.cmd.commands;

import com.springbank.account.cmd.controllers.CloseAccountController;
import com.springbank.cqrs.core.commands.BaseCommand;

import java.util.UUID;

public class CloseAccountCommand extends BaseCommand {
    public CloseAccountCommand(UUID id) {
        super(id);
    }
}
