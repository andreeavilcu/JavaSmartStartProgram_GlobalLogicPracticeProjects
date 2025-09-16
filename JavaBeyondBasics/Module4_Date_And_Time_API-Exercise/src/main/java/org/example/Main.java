package org.example;

import java.time.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventManager manager = new EventManager();
        ZoneId nyZone = ZoneId.of("America/New_York");

        Event e1 = manager.createEvent("Meeting", LocalDateTime.of(2025, 9,15, 10, 0 ),
                LocalDateTime.of(2025, 9,15, 11, 0 ), nyZone);

        Event e2 = manager.createEvent("WorkShop", LocalDateTime.of(2025, 9,15, 13, 0 ),
                LocalDateTime.of(2025, 9,15, 15, 0 ), nyZone);

        List<Event> eventsOnDate = manager.listEventsForDate(LocalDate.of(2025, 9, 15));
        System.out.println("Events on 2025-09-15: " + eventsOnDate.size());

        boolean overlaps = manager.isOverlapping(LocalDateTime.of(2025, 9, 15, 10, 30),LocalDateTime.of(2025, 9, 15, 11, 30), nyZone);
        System.out.println("Overlap: " + overlaps);

        List<LocalTime> slots = manager.findAvailableSlots(LocalDate.of(2025, 9, 15),
                Duration.ofHours(1), nyZone);
        System.out.println("Available slots: " + slots);

        boolean rescheduled = manager.rescheduleEvent(e1, LocalDateTime.of(2025, 9, 15, 16, 0),
                LocalDateTime.of(2025, 9, 15, 17, 0), nyZone);
        System.out.println("Rescheduled: " + rescheduled);

        boolean canceled = manager.cancelEvent(e2);
        System.out.println("Canceled: " + canceled);
    }
}