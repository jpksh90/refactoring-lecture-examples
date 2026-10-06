package dk.sdu.refactoring.alternativeinterfaces.before;

import java.util.ArrayList;
import java.util.List;

public class TrackList {

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
