package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Event {
    private String eventName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ZoneId timeZone;
    private boolean recurring;
    private Duration recurrenceInterval;

    public Event(String eventName, LocalDateTime startDate, LocalDateTime endDate, ZoneId timeZone) {
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeZone = timeZone;
        this.recurring = false;
        this.recurrenceInterval = null;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public Duration getRecurrenceInterval() {
        return recurrenceInterval;
    }

    public void setRecurrenceInterval(Duration recurrenceInterval) {
        this.recurrenceInterval = recurrenceInterval;
    }
}
