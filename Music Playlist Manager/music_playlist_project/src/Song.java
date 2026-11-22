import java.util.Objects;

public class Song {
    private String title;
    private String artist;
    private int durationInSeconds;

    public Song(String title, String artist, int durationInSeconds) {
        if (durationInSeconds < 0) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
    }

    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getDurationInSeconds() {
        return durationInSeconds;
    }
    public String getFormattedDuration() {
        return String.format("%02d:%02d", (durationInSeconds / 60), (durationInSeconds % 60));
    }
    @Override
    public String toString() {
        return title + " - " + artist + " - " + " (" +getFormattedDuration() + ")";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Song)) {
            return false;
        }
        Song otherSong = (Song) obj;
        return title.equals(otherSong.title) && artist.equals(otherSong.artist);
    }
}
