package com.springbank.cqrs.core.domain;

import com.springbank.cqrs.core.events.BaseEvent;
import lombok.Getter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public abstract class AggregateRoot {

    protected UUID id;

    private final List<BaseEvent> changes = new ArrayList<>();
    private final Logger logger = Logger.getLogger(AggregateRoot.class.getName());

    public List<BaseEvent> getUncommittedChanges(){
        return changes;
    }

    public void markChangesAsCommitted() {
        changes.clear();
    }

    public void replayEvents(Iterable<BaseEvent> events) {
        events.forEach(event -> applyChange(event, false));
    }

    public void raiseEvent(BaseEvent event) {
        applyChange(event, true);
    }

    protected void applyChange(BaseEvent event, Boolean isNewEvent) {
        try {
            var method = getClass().getDeclaredMethod("apply", event.getClass());
            method.setAccessible(true);
            method.invoke(this, event);
        } catch (NoSuchMethodException ex) {
            logger.log(Level.WARNING, MessageFormat.format("The apply method was not found in the aggregate for {0}", event.getClass().getName()));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error applying event to Aggregate", e);
        }
        finally {
            if (isNewEvent) changes.add(event);
        }
    }
}
