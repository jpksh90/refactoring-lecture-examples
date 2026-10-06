package dk.sdu.refactoring.alternativeinterfaces.before;

import java.util.ArrayList;
import java.util.List;

/**
 * SMELL: Alternative Classes with Different Interfaces (slides 49-50).
 * Playlist does the same job as TrackList, but with different names
 * (appendSong vs addTrack, duration vs totalSeconds) and a different element type.
 * Clients cannot treat them uniformly, and the logic is duplicated.
 */
public class Playlist {

    private final List<Song> songs = new ArrayList<>();

    public void appendSong(Song s) {
        songs.add(s);
    }

    public int duration() {
        int sum = 0;
        for (Song s : songs) sum += s.lengthInSeconds();
        return sum;
    }
}
