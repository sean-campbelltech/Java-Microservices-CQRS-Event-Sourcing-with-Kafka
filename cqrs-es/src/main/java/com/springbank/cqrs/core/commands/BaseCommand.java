package com.springbank.cqrs.core.commands;

import com.springbank.cqrs.core.messages.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class BaseCommand extends Message {
    public BaseCommand(UUID id) {
        super(id);
    }
}

