package dk.sdu.refactoring.alternativeinterfaces;

import dk.sdu.refactoring.alternativeinterfaces.after.*;

import java.util.List;

/**
 * Alternative Classes with Different Interfaces ("Different Interfaces")
 * -> Change Function Declaration, Move Function, Extract Superclass.
 */
public class Demo {
    public static void main(String[] args) {
        var tl = new dk.sdu.refactoring.alternativeinterfaces.before.TrackList();
        tl.addTrack(new dk.sdu.refactoring.alternativeinterfaces.before.Track("Intro", 90));
        var pl = new dk.sdu.refactoring.alternativeinterfaces.before.Playlist();
        pl.appendSong(new dk.sdu.refactoring.alternativeinterfaces.before.Song("Outro", 120));
        System.out.println("before: " + tl.totalSeconds() + " + " + pl.duration());

        // After: clients can treat both uniformly.
        List<TrackCollection> collections = List.of(new TrackList(), new Playlist());
        collections.get(0).addTrack(new Track("Intro", 90));
        collections.get(1).addTrack(new Track("Outro", 120));
        System.out.println("after : " + collections.get(0).totalSeconds() + " + " + collections.get(1).totalSeconds());
    }
}
