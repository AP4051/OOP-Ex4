
import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        if (!songs.contains(song)) {
            songs.add(song);
            System.out.println("Song added: " + song.getTitle());
        } else {
            System.out.println("Duplicate song!");
        }
    }

    public void insertSongAt(int index, Song song) {
        if (index >= 0 && index <= songs.size()) {
            if (!songs.contains(song)) {
                songs.add(index, song);
                System.out.println("Song inserted.");
            } else {
                System.out.println("Duplicate song!");
            }
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void removeSongByTitle(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
                songs.remove(i);
                System.out.println("Song removed.");
                return;
            }
        }

        System.out.println("Song not found!");
    }

    public void replaceSong(int index, Song newSong) {
        if (index >= 0 && index < songs.size()) {
            if (!songs.contains(newSong)
                    || songs.get(index).equals(newSong)) {
                songs.set(index, newSong);
                System.out.println("Song replaced.");
            } else {
                System.out.println("Duplicate song!");
            }
        } else {
            System.out.println("Invalid index!");
        }
    }

    public ArrayList<Song> findSongsByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();

        for (Song song : songs) {
            if (song.getArtist().equalsIgnoreCase(artist)) {
                result.add(song);
            }
        }

        return result;
    }

    public int getTotalDuration() {
        int total = 0;

        for (Song song : songs) {
            total += song.getDurationInSeconds();
        }

        return total;
    }

    // BONUS 1: Move a song to another position
    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < songs.size()
                && toIndex >= 0 && toIndex < songs.size()) {

            Song song = songs.remove(fromIndex);
            songs.add(toIndex, song);

            System.out.println("Song moved.");
        } else {
            System.out.println("Invalid index!");
        }
    }

    // BONUS 2: Shuffle the playlist
    public void shuffle() {
        Collections.shuffle(songs);
        System.out.println("Playlist shuffled.");
    }

    public void displayPlaylist() {
        System.out.println("\nPlaylist: " + name);

        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }

        int total = getTotalDuration();

        System.out.println("Total Duration: "
                + String.format("%02d:%02d", total / 60, total % 60));
    }
}
