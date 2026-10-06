package dk.sdu.refactoring.dataclumps.before;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * SMELL: Data Clumps (slides 37-38).
 * (temperature, time) always travel together - in parameters, in parallel lists,
 * and in parallel arrays. Test: if you deleted one of them, would the other still make sense?
 * No -> they belong together in an object.
 */
public class WeatherStation {

    // SMELL: parallel lists that must be kept in sync by hand
    private final List<Double> temperatures = new ArrayList<>();
    private final List<LocalDateTime> times = new ArrayList<>();

    public void recordReading(double temperature, LocalDateTime time) {
        temperatures.add(temperature);
        times.add(time);
    }

    public String plot(double temperature, LocalDateTime time) {
        return time.toLocalDate() + " " + "*".repeat((int) temperature);
    }

    public String export(double temperature, LocalDateTime time) {
        return time + ";" + temperature;
    }

    public static double average(double[] temperatures, LocalDateTime[] times) {
        double sum = 0;
        for (double t : temperatures) sum += t;
        return sum / temperatures.length;
    }

    public double[] temperatures() {
        return temperatures.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public LocalDateTime[] times() {
        return times.toArray(new LocalDateTime[0]);
    }
}
