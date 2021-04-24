package com.springbank.cqrs.core.commands;

import com.springbank.cqrs.core.messages.Message;
import lombok.Data;

@Data
public class BaseCommand extends Message {
    private int expectedVersion;
}

