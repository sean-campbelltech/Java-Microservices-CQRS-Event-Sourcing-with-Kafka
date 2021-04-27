package com.springbank.cqrs.core.commands;

import com.springbank.cqrs.core.messages.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseCommand extends Message {
    public BaseCommand(String id) {
        super(id);
    }
}

