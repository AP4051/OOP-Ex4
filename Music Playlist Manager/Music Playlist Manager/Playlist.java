import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(Song song) {
        if (songs.contains(song)) {
            System.out.println("Duplicate song, not added: " + song);
            return false;
        }
        songs.add(song);
        return true;
    }

    public boolean insertSongAt(int index, Song song) {
        if (index < 0 || index > songs.size()) {
            System.out.println("Invalid index: " + index);
            return false;
        }
        if (songs.contains(song)) {
            System.out.println("Duplicate song, not inserted: " + song);
            return false;
        }
        songs.add(index, song);
        return true;
    }

    public boolean removeSongByTitle(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
                songs.remove(i);
                return true;
            }
        }
        System.out.println("Song not found: " + title);
        return false;
    }

    public boolean replaceSong(int index, Song newSong) {
        if (index < 0 || index >= songs.size()) {
            System.out.println("Invalid index: " + index);
            return false;
        }
        songs.set(index, newSong);
        return true;
    }

    public ArrayList<Song> findSongsByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : songs) {
            if (s.getArtist().equalsIgnoreCase(artist)) {
                result.add(s);
            }
        }
        return result;
    }

    public int getTotalDuration() {
        int total = 0;
        for (Song s : songs) {
            total += s.getDurationInSeconds();
        }
        return total;
    }

    // Bonus
    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= songs.size() || toIndex < 0 || toIndex >= songs.size()) {
            System.out.println("Invalid index.");
            return;
        }
        songs.add(toIndex, songs.remove(fromIndex));
    }

    public void shuffle() {
        Collections.shuffle(songs);
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
        int total = getTotalDuration();
        System.out.println("Total duration: " + String.format("%02d:%02d", total / 60, total % 60));
    }
}
