public class Song {
    private String title;
    private String artist;
    private int durationInSeconds;

    public Song(String title, String artist, int durationInSeconds) {
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

    public String toString() {
        return title + " - " + artist + " (" + getFormattedDuration() + ")";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Song)) return false;
        Song other = (Song) obj;
        return title.equalsIgnoreCase(other.title) && artist.equalsIgnoreCase(other.artist);
    }
}
