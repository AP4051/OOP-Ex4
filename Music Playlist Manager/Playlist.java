import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        if (songs.contains(song)) {
            System.out.println("This song is already in the playlist!");
        } else {
            songs.add(song);
        }
    }

    public void insertSongAt(int index, Song song) {
        if (index < 0 || index > songs.size()) {
            System.out.println("Invalid index!");
            return;
        }
        if (songs.contains(song)) {
            System.out.println("This song is already in the playlist!");
            return;
        }
        songs.add(index, song);
    }

    public void removeSongByTitle(String title) {
        for (int i = 0; i < songs.size(); i++) {
            Song current = songs.get(i);
            if (current.getTitle().equalsIgnoreCase(title)) {
                songs.remove(i);
                System.out.println("Removed: " + title);
                return;
            }
        }
        System.out.println("Song not found: " + title);
    }

    public void replaceSong(int index, Song newSong) {
        if (index < 0 || index >= songs.size()) {
            System.out.println("Invalid index!");
            return;
        }
        songs.set(index, newSong);
    }

    public ArrayList<Song> findSongsByArtist(String artist) {
        ArrayList<Song> foundSongs = new ArrayList<>();
        for (int i = 0; i < songs.size(); i++) {
            Song current = songs.get(i);
            if (current.getArtist().equalsIgnoreCase(artist)) {
                foundSongs.add(current);
            }
        }
        return foundSongs;
    }

    public int getTotalDuration() {
        int total = 0;
        for (int i = 0; i < songs.size(); i++) {
            total = total + songs.get(i).getDurationInSeconds();
        }
        return total;
    }

    public void displayPlaylist() {
        System.out.println("Playlist: " + name);
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }

        int totalSeconds = getTotalDuration();
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        String minText = (minutes < 10 ? "0" : "") + minutes;
        String secText = (seconds < 10 ? "0" : "") + seconds;

        System.out.println("Total Duration: " + minText + ":" + secText);
    }
}