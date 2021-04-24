package com.springbank.account.common.events;

import com.springbank.cqrs.core.events.BaseEvent;
import lombok.experimental.SuperBuilder;
import lombok.Data;

@Data
@SuperBuilder
public class AccountClosedEvent extends BaseEvent {
}