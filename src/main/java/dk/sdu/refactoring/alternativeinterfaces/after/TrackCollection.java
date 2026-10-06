package dk.sdu.refactoring.alternativeinterfaces.after;

import java.util.ArrayList;
import java.util.List;

/**
 * REFACTORING: Extract Superclass (slide 49) - once the protocols matched,
 * the duplicated list + total logic was pulled up into one place (Pull Up Field / Pull Up Method).
 */
public abstract class TrackCollection {

    private final List<Track> tracks = new ArrayList<>();

    public void addTrack(Track t) {
        tracks.add(t);
    }

    public int totalSeconds() {
        int sum = 0;
        for (Track t : tracks) sum += t.seconds();
        return sum;
    }
}
