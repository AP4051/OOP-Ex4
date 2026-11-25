public class Song {
    private final String title;
    private final String artist;
    private final int durationInSeconds;

    public Song(String title, String artist, int durationInSeconds) {
        if (durationInSeconds < 0) throw new IllegalArgumentException("Duration cannot be negative.");
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDurationInSeconds() { return durationInSeconds; }

    public String getFormattedDuration() {
        return String.format("%02d:%02d", durationInSeconds / 60, durationInSeconds % 60);
    }

    @Override
    public String toString() { return title + " - " + artist + " (" + getFormattedDuration() + ")"; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Song)) return false;
        Song other = (Song) obj;
        return title.equalsIgnoreCase(other.title) && artist.equalsIgnoreCase(other.artist);
    }

    @Override
    public int hashCode() {
        return 31 * title.toLowerCase().hashCode() + artist.toLowerCase().hashCode();
    }
}
