package dk.sdu.refactoring.dataclumps.after;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {

    // REFACTORING: Extract Class - two parallel lists became one list of Reading
    private final List<Reading> readings = new ArrayList<>();

    // REFACTORING: Introduce Parameter Object - (temperature, time) -> Reading
    public void recordReading(Reading reading) {
        readings.add(reading);
    }

    // REFACTORING: Preserve Whole Object - callers pass the Reading they already have
    public String plot(Reading reading) {
        return reading.plotLine();
    }

    public String export(Reading reading) {
        return reading.toCsv();
    }

    public static double average(List<Reading> readings) {
        double sum = 0;
        for (Reading r : readings) sum += r.temperature();
        return sum / readings.size();
    }

    public List<Reading> readings() {
        return List.copyOf(readings);
    }
}
