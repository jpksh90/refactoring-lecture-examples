package dk.sdu.refactoring.dataclumps.after;

import java.time.LocalDateTime;

/**
 * REFACTORING: Extract Class (slide 38) - the clump (temperature, time) becomes a type.
 * Once the class exists, behaviour that only uses those two values moves in too
 * (Move Function): plotLine() and toCsv().
 */
public record Reading(double temperature, LocalDateTime time) {

    public String plotLine() {
        return time.toLocalDate() + " " + "*".repeat((int) temperature);
    }

    public String toCsv() {
        return time + ";" + temperature;
    }
}
