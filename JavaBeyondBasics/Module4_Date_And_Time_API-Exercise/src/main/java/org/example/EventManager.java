package org.example;

import java.time.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EventManager {
    private List<Event> events = new ArrayList<>();

    public Event createEvent(String name, LocalDateTime start, LocalDateTime end, ZoneId zone) {
        Event newEvent = new Event(name, start, end, zone);
        events.add(newEvent);
        return newEvent;
    }

    public List<Event> listEventsForDate(LocalDate date) {
        return events.stream()
                .filter(e -> e.getStartDate().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    public boolean isOverlapping(LocalDateTime newStart, LocalDateTime newEnd, ZoneId zone) {
        for (Event e : events) {
            ZonedDateTime existingStart = e.getStartDate().atZone(e.getTimeZone()).withZoneSameInstant(zone);
            ZonedDateTime existingEnd = e.getEndDate().atZone(e.getTimeZone()).withZoneSameInstant(zone);


            if (newStart.atZone(zone).isBefore(existingEnd) &&
                    newEnd.atZone(zone).isAfter(existingStart)) {
                return true;
            }
        }
        return false;
    }

    public List<LocalTime> findAvailableSlots(LocalDate date, Duration duration, ZoneId zone){
        List<Event> dailyEvents = listEventsForDate(date);
        dailyEvents.sort(Comparator.comparing(Event::getStartDate));

        List<LocalTime> availableSlots = new ArrayList<>();
        LocalTime startOfDay = LocalTime.of(9, 0); // Example working hours
        LocalTime endOfDay = LocalTime.of(18, 0);

        LocalDateTime slotStart = LocalDateTime.of(date, startOfDay);

        for (Event e : dailyEvents) {
            if (slotStart.isBefore(e.getStartDate())) {
                Duration gap = Duration.between(slotStart, e.getStartDate());
                if (!gap.minus(duration).isNegative()) {
                    availableSlots.add(slotStart.toLocalTime());
                }
            }
            slotStart = e.getEndDate().isAfter(slotStart) ? e.getEndDate() : slotStart;
        }

        if (!slotStart.toLocalTime().isAfter(endOfDay.minus(duration))) {
            availableSlots.add(slotStart.toLocalTime());
        }

        return availableSlots;
    }

    public boolean rescheduleEvent(Event event, LocalDateTime newStart, LocalDateTime newEnd, ZoneId zone){
        if(!isOverlapping(newStart, newEnd, zone)){
            event.setStartDate(newStart);
            event.setEndDate(newEnd);
            event.setRecurring(false);
            return true;
        }
        return false;
    }

    public boolean cancelEvent(Event event){
        return events.remove(event);
    }

}
