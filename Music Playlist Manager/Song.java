public class Song {
    private String title;
    private String artist;
    private int durationInSeconds;

    public Song(String title, String artist, int durationInSeconds) {
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
        int min = durationInSeconds / 60;
        int sec = durationInSeconds % 60;
        return String.format("%02d:%02d", min, sec);
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + getFormattedDuration() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Song) {
            Song other = (Song) obj;
            if (title.equalsIgnoreCase(other.title) && artist.equalsIgnoreCase(other.artist)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (title.toLowerCase() + artist.toLowerCase()).hashCode();
    }
}