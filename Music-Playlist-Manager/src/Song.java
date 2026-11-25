public class Song {

    private String title;
    private String artist;
    private int durationInSeconds;

    public Song(String title,String artist,int durationInSeconds) {
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
        int mm = durationInSeconds / 60;
        int ss = durationInSeconds % 60;
        return String.format("%02d:%02d",mm,ss);
    }

    public String toString() {
        return title + " - " + artist + " (" + getFormattedDuration() + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Song))
            return false;
        Song other = (Song) obj;
        return title.equalsIgnoreCase(other.title) && artist.equalsIgnoreCase(other.artist);
    }
}