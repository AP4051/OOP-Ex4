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
        int minutes = durationInSeconds / 60;
        int seconds = durationInSeconds % 60;

        String minText = "" + minutes;
        if (minutes < 10) {
            minText = "0" + minutes;
        }

        String secText = "" + seconds;
        if (seconds < 10) {
            secText = "0" + seconds;
        }

        return minText + ":" + secText;
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + getFormattedDuration() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Song)) {
            return false;
        }
        Song other = (Song) obj;
        return this.title.equalsIgnoreCase(other.title) && this.artist.equalsIgnoreCase(other.artist);
    }
}