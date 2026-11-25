import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<Song>();
    }
    public void addSong(Song song) {
        if (songs.contains(song)) System.out.println("Duplicate song: " + song.getTitle());
        else songs.add(song);
    }
    public void insertSongAt(int index, Song song) {
        if (index < 0 || index > songs.size()) {
            System.out.println("Invalid index.");
        } else if (songs.contains(song)) {
            System.out.println("Song already exists.");
        } else {
            songs.add(index, song);
        }
    }
    public void removeSongByTitle(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
                songs.remove(i);
                return;
            }
        }
        System.out.println("Song not found.");
    }
    public void replaceSong(int index, Song newSong) {
        if (index < 0 || index >= songs.size()) {
            System.out.println("Invalid index.");
        } else if (songs.contains(newSong)) {
            System.out.println("Song already exists.");
        } else {
            songs.set(index, newSong);
        }
    }
    public ArrayList<Song> findSongsByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<Song>();
        for (Song song : songs) {
            if (song.getArtist().equalsIgnoreCase(artist)) result.add(song);
        }
        return result;
    }
    public int getTotalDuration() {
        int total = 0;
        for (Song song : songs) total += song.getDurationInSeconds();
        return total;
    }
    public void displayPlaylist() {
        System.out.println("\nPlaylist: " + name);
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        for (int i = 0; i < songs.size(); i++)
            System.out.println((i + 1) + ". " + songs.get(i));
        int total = getTotalDuration();
        System.out.println("Total duration: " + (total / 60) + ":" +
                String.format("%02d", total % 60));
    }
}
