package dk.sdu.refactoring.alternativeinterfaces.after;

/**
 * REFACTORING: Change Function Declaration (slide 50) - appendSong(Song) -> addTrack(Track),
 *              duration() -> totalSeconds(), so both classes speak the same protocol.
 * REFACTORING: Move Function until protocols match, then Extract Superclass (TrackCollection).
 */
public class Playlist extends TrackCollection {
    // e.g. playlist-specific behaviour (shuffle, owner, ...) would go here
}
