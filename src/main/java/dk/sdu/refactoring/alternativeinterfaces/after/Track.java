package dk.sdu.refactoring.alternativeinterfaces.after;

/** Song was merged into Track - one name for one concept. */
public record Track(String title, int seconds) {
}
