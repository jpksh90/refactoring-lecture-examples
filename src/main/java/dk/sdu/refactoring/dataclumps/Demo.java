package dk.sdu.refactoring.dataclumps;

import java.time.LocalDateTime;

/** Data Clumps -> Extract Class, Introduce Parameter Object, Preserve Whole Object. */
public class Demo {
    public static void main(String[] args) {
        LocalDateTime monday = LocalDateTime.of(2026, 10, 5, 12, 0);
        LocalDateTime tuesday = monday.plusDays(1);

        System.out.println("--- before ---");
        var before = new dk.sdu.refactoring.dataclumps.before.WeatherStation();
        before.recordReading(12, monday);
        before.recordReading(15, tuesday);
        System.out.println(before.plot(12, monday));
        System.out.println(before.export(15, tuesday));
        System.out.println("avg " + dk.sdu.refactoring.dataclumps.before.WeatherStation
                .average(before.temperatures(), before.times()));

        System.out.println("--- after ---");
        var after = new dk.sdu.refactoring.dataclumps.after.WeatherStation();
        var r1 = new dk.sdu.refactoring.dataclumps.after.Reading(12, monday);
        var r2 = new dk.sdu.refactoring.dataclumps.after.Reading(15, tuesday);
        after.recordReading(r1);
        after.recordReading(r2);
        System.out.println(after.plot(r1));
        System.out.println(after.export(r2));
        System.out.println("avg " + dk.sdu.refactoring.dataclumps.after.WeatherStation.average(after.readings()));
    }
}
